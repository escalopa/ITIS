import java.util.HashMap;

public class PropertiesTest {

    public static void main (String[] args){

        //Task 1
        String cloneWithoutSymbols = "cfwtyotjmdfalsgfnvccmoaerhgnvijbldahdjkfarstiogjfasklgJBNGFLKKBMOIDSCKXFHDNKLBJSRDFILKJkfldbvnsuudfjkbnvuidhfbHDGRHSDFUGHBDF";
        HashMap<Character,Integer> mapOFStrings1= StringProperties.lettersInString(cloneWithoutSymbols);
        mapOFStrings1.entrySet().forEach(e -> System.out.print(e+" "));

        System.out.println("\n\n");


        String temp = "{}_+}}:?::dgg{}}[";
        //Task 1*
        String cloneWithSymbols = "trghjnbgftrdgxgdftaytryq32rqwuidojk2oi3wlrjgkdgfniofvbcniwoarvmcpiarndsfhilknrsiulfzvhbqadgbakuzdgbargiow3hnvkjarsdgbv98cp328oi?][##$%}&/YT:#?${Q#@$T?Rag/Q?WYG}W?y5g";
        HashMap<Character,Integer> mapOFStrings2= StringProperties.lettersInStringWithSybmbols(temp);
        mapOFStrings2.entrySet().forEach(e -> System.out.print(e+" "));
    }
    
}
