package Security;

import DB.BlockModel;
import DB.DataModel;
import org.bouncycastle.util.encoders.DecoderException;
import org.bouncycastle.util.encoders.Hex;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class SignService {

    public static final String DIGEST_ALGORITHM = "SHA-256";
    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGN_ALGORITHM = "SHA256withRSA";

    public static String publicKey16 = "30819f300d06092a864886f70d010101050003818d00308189028181008d8a55db37bcbcba303d3955863f67cae13edb6e4b4fb4fed75aa77f66fc08a0ecc65bf16a83c38eea4fd4123cc7f8b1532a7ac720c9b31f8a61da112574b02f128858eace6f6374f90ebca37adbbed81590d81f7e9921761cd5067b027744b68c93bd085bcafc539d1acfcd3fcdffbde6701a6590efcbafb296ddb3272787f10203010001";
    public static String privateKey16 = "30820276020100300d06092a864886f70d0101010500048202603082025c020100028181008d8a55db37bcbcba303d3955863f67cae13edb6e4b4fb4fed75aa77f66fc08a0ecc65bf16a83c38eea4fd4123cc7f8b1532a7ac720c9b31f8a61da112574b02f128858eace6f6374f90ebca37adbbed81590d81f7e9921761cd5067b027744b68c93bd085bcafc539d1acfcd3fcdffbde6701a6590efcbafb296ddb3272787f10203010001028180077c04ad3a65cb0f0764fd66a5da2d795f6eccf8a897d6e8d0e774cafa5da2712c0413319161d551f5d6f1ce631369f5aa81a90b6592f4db5a9c71050e177d0773d69a4fdd3f2e868470a7be0a6b188aa87a4917c9f6dbac0c27c10b41b5896722b0eb99bd3e6141cdc5182d7fbe5351e0fbde3df88230419c53159bac327ba9024100dd0956ef72af89c8480bb640908a6e78613df177bd5a55a5483c9df979fd8a1027d0632c37c2aa597abc7be73d6f3e057561aaff34a6dee175126b9c6c03790d024100a3ede0854ee4785f2a973bd14dbce8f8fc3dce3c44b01aae163e90fc8becff1d9d4ea673cf38433076e269b86fc93cb35be93972efde0d10ae6a3082601ec9750240792c9d943773343db0017bb0798cea72e41c693c137a6a6969e891522b266b81dfd1c60c7fa5206e5d72e71a25fbce2c7fe54331155445eba39aad93db432c2102403203927bb99d35287bdb1651fe70c377aba5c3b559938d204e031ac32281d53818d5752d622c9d3b3d1a48fd0f860b3201b9bf6054d49f91d654e9a5ed63973d024100a8ea97d4340db2ad8fe2b88269843bcc1904c1d8f0dd68d743d62b36b949769d3e8eb95f855c42eaf41948a150eb8f1d874083d2b9deba5dfdf30120bef3f69c";

    public static PublicKey publicKey;
    public static PrivateKey privateKey;

    public byte[] getHash(BlockModel block) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        MessageDigest digest = MessageDigest.getInstance(DIGEST_ALGORITHM);

        byte[] result = digest.digest(
                concat(concat(block.getPrevhash() != null ? block.getPrevhash().getBytes() : null,
                                block.getData().toString().getBytes("UTF-8")),
                        block.getTs().getBytes()));
        return result;
    }

    public static byte[] concat(byte[] a, byte[] b) {
        if (a == null) return b;
        if (b == null) return a;
        int len_a = a.length;
        int len_b = b.length;
        byte[] C = new byte[len_a + len_b];
        System.arraycopy(a, 0, C, 0, len_a);
        System.arraycopy(b, 0, C, len_a, len_b);
        return C;
    }

    public static void loadKeys() throws Exception {

        byte[] publicKeyHex = publicKey16.getBytes();
        byte[] privateKeyHex = privateKey16.getBytes();

        publicKey = convertArrayToPublicKey(Hex.decode(publicKeyHex), KEY_ALGORITHM);
        privateKey = convertArrayToPrivateKey(Hex.decode(privateKeyHex), KEY_ALGORITHM);
    }

    public static PublicKey convertArrayToPublicKey(byte encoded[], String algorithm) throws Exception {
        X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(encoded);
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        PublicKey pubKey = keyFactory.generatePublic(pubKeySpec);

        return pubKey;
    }

    public static PrivateKey convertArrayToPrivateKey(byte encoded[], String algorithm) throws Exception {
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        PrivateKey priKey = keyFactory.generatePrivate(keySpec);
        return priKey;
    }

    public byte[] generateRSAPSSSignature(PrivateKey privateKey, byte[] input)
            throws GeneralSecurityException {
        Signature signature = Signature.getInstance(SIGN_ALGORITHM);

        signature.initSign(privateKey);

        signature.update(input);

        return signature.sign();
    }

    public byte[] generateRSAPSSSignature(byte[] input)
            throws Exception {
        Signature signature = Signature.getInstance(SIGN_ALGORITHM);

        signature.initSign(convertArrayToPrivateKey(Hex.decode(privateKey16), KEY_ALGORITHM));

        signature.update(input);

        return signature.sign();
    }

    public static boolean verifyRSAPSSSignature(String publicKey, DataModel blockModel, String encSignature)
            throws GeneralSecurityException {
        if (publicKey == null || encSignature == null)
            return false;
        // Form PK from string
        PublicKey pubKey = null;
        try {
            pubKey = convertStringToPublicKey(Hex.decode(publicKey));
        }catch (DecoderException e){
            System.out.println(e.getMessage());
        }

        // Magic
        Signature signature = Signature.getInstance(SIGN_ALGORITHM);
        signature.initVerify(pubKey);
        signature.update(blockModel.toString().getBytes(StandardCharsets.UTF_8));

        return signature.verify(Hex.decode(encSignature));
    }

    private static PublicKey convertStringToPublicKey(byte[] publicBytes) throws NoSuchAlgorithmException, InvalidKeySpecException {
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        return keyFactory.generatePublic(keySpec);
    }

}
