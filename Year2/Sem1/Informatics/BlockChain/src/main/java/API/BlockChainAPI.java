package API;

import DB.BlockChain;
import DB.BlockModel;
import DB.DBWork;
import DB.DataModel;
import Security.SignService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bouncycastle.util.encoders.Hex;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;

public class BlockChainAPI {


    public String headers[] = new String[]{
            "Name",
            "Data",
            "Prev hash",
            "Public key",
            "Signature",
            "Date",
            "Verified"};

    //Security
    private final SignService signService;
    private final String publicKey;

    //BlockChain
    public BlockChain chain;

    public BlockChainAPI() throws Exception {

        //Security
        signService = new SignService();
        publicKey = Files.readString(Paths.get("public.key"));
        SignService.loadKeys();
        load();
    }

    public void load() throws IOException {
        //Initialize blockChain from server
        chain = new BlockChain();
        verify(chain);
    }

    public BlockModel createBlock(DataModel dataModel) throws Exception {
        BlockModel block = new BlockModel();
        String signature = new String(Hex.encode(signService.generateRSAPSSSignature(dataModel.toString().getBytes())));
        String prevHash = new String(Hex.encode(signService.getHash(chain.getLastBlock())));
        block.setPrevhash(prevHash);
        block.setData(dataModel);
        block.setSignature(signature);
        block.setPublickey(publicKey);
        return sendBlockToServer(block);
    }

    public BlockModel sendBlockToServer(BlockModel blockModel) {
        try {
            URL url = new URL("http://188.93.211.195/dis/newblock?block=" +
                    URLEncoder.encode(blockModel.toString(), "UTF-8"));

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int rcode = con.getResponseCode();
            if (rcode == 200) {
                ObjectMapper mapper = new ObjectMapper();
                NewBlockResponse blockResponse =
                        mapper.readValue(con.getInputStream(), NewBlockResponse.class);
                System.out.println(blockResponse);
                DBWork.addBlock(blockModel);
                return blockModel;
            } else {
                System.out.println("response code = " + rcode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void verify(BlockChain chain) {
        chain.getChain().forEach(b -> {
            try {
                b.setVerified(SignService.verifyRSAPSSSignature(
                        b.getPublickey()
                        , b.getData()
                        , b.getSignature()));
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            }
        });
    }
}