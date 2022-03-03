import java.util.HashMap;

public class StringProperties {

    public static HashMap<Character,Integer> lettersInString(String string){

        HashMap<Character,Integer> lettersConunt = new HashMap<>();
        for (char c  : string.toCharArray()) {
            if(lettersConunt.containsKey(c)){
                lettersConunt.put(c,lettersConunt.get(c)+1);
            }else
                lettersConunt.put(c,1);
        }
        return lettersConunt;
    }   
    
    public static HashMap<Character,Integer> lettersInStringWithSybmbols(String string){

        HashMap<Character,Integer> lettersConunt = new HashMap<>();
        for (char c  : string.toCharArray()) {
            if(!((c>=65 && c<=90) && (c>=97 && c<=122))) continue;
            if(lettersConunt.containsKey(c)){
                lettersConunt.put(c,lettersConunt.get(c)+1);
            }else
                lettersConunt.put(c,1);
        }
        return lettersConunt;
    } 
    
}
