import java.util.LinkedList;
import java.util.List;

public class PossibleStrings {

    private  static final List<StringBuilder> stringList = new LinkedList<>();

    public static List<StringBuilder> possibleCombinations(int size , List<String> letters) {
        StringBuilder word = new StringBuilder();
        findCombinations(word, size, letters);
        System.out.println(stringList.size());
        return  stringList;
    }

    private static void findCombinations(StringBuilder word, int size, List<String> letters) {
        if (word.length() == size) {
            stringList.add(new StringBuilder(word));
        } else {
            for (String letter : letters) {
                word.append(letter);
                if (wordIsCorrect(word))
                    findCombinations(word, size, letters);
                word.deleteCharAt(word.length() - 1);
            }
        }
    }

    private static boolean wordIsCorrect(StringBuilder word) {
        int len =word.length();
        if (len <= 1) return true;
        if (word.charAt(len-2)=='A' & word.charAt(len-1)=='A')
            return false;
        if (len<3) return true;
        return (word.charAt(len-1)=='A' || word.charAt(len-2)=='A' || word.charAt(len-3)=='A');
    }
}
