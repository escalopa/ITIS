package GreedyAlgorithms;
import java.util.Scanner;

public class ComputationalBiology278 {
    static boolean search(String pat, String text) {
        int M = pat.length();
        int pointer = 0;
        for (char c : text.toCharArray()) {
            if (pointer == M)
                return true;
            if (c == pat.charAt(pointer)) {
                pointer++;
            }
        }
        return pointer == M;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.nextLine();
        String text = scanner.nextLine();
        if (search(pattern, text))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
