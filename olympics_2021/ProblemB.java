package olympics_2021;

import java.util.Scanner;
import java.util.Stack;

public class ProblemB {

    static String line;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        line = scanner.nextLine();
        int x = scanner.nextInt();
        for (int i = 0; i < x; i++) {
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            System.out.println(minDeletedBrackets(y,z));
        }
    }

    private static int minDeletedBrackets(int y, int z) {
        Stack<Character> stack = new Stack<>();
        return -1;
    }



}
