package Problems;

import java.util.Scanner;

public class IlyaAndQueries {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        String s = " " + scanner.nextLine();
        int n = s.length();
        long[][] a = new long[s.length() + 1][];
        a[1] = new long[2];
        for (int i = 2; i < n; i++) {
            a[i] = new long[i + 1];
            int inc = 0;
            if (s.charAt(i - 1) == s.charAt(i))
                inc++;
            int j = 1;
            for (; j < i; j++) {
                a[i][j] = a[i - 1][j] + inc;
            }
        }
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            System.out.println(a[k][m]);
        }
    }
}
