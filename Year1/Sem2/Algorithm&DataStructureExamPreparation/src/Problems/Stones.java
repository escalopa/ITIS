package Problems;

import java.util.Scanner;

public class Stones {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        char[] c = sc.nextLine().toCharArray();
        int l = 1;
        int r = c.length;
        int[] a = new int[c.length + 1];
        for (int i = 1; i <= c.length; i++) {
            if (c[i - 1] == 'l')
                a[r--] = i;
            else
                a[l++] = i;
        }
        for (int i = 1; i <= c.length; i++) System.out.println(a[i]);
    }

}
