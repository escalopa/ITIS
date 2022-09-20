import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        List<String> letters = new LinkedList<>();
        letters.add("A");
        letters.add("B");
        letters.add("C");
        List<StringBuilder> answers= PossibleStrings.possibleCombinations(5,letters);
        for (StringBuilder answer: answers) {
            System.out.println(answer);
        }
    }
}
