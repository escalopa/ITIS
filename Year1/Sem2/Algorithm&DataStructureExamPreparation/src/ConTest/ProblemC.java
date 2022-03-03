package ConTest;

import java.util.HashMap;
import java.util.Scanner;

public class ProblemC {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(getWays(n, k));
        scanner.close();
    }

    private static String getWays(int n, int k) {

        StringBuilder stringBuilder = new StringBuilder();
        HashMap<Integer, Integer> lastIndex = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            lastIndex.put(x, i + 1);
        }

        for (int i = 0; i < k; i++) {
            int x = scanner.nextInt();
            int y = lastIndex.get(x);
            stringBuilder.append(y).append(" ");
            lastIndex.put(x, y - 1);
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

}

