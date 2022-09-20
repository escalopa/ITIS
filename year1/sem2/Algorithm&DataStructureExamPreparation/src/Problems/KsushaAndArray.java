package Problems;

import java.util.Arrays;
import java.util.Scanner;

public class KsushaAndArray {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int n = sc.nextInt();
        int[] a = new int[n];
        boolean hasOne = false;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (a[i] == 1) {
                hasOne = true;
                break;
            }
        }
        sc.close();
        if (hasOne)
            System.out.println(1);
        else
            System.out.println(solve(a));
    }

    private static int solve(int[] a) {
        a = Arrays.stream(a).distinct().sorted().toArray();
        boolean isDivisible = true;
        for (int i = 0; i < a.length; i++) {
            for (int j = a.length - 1; j >= i + 1; j--) {
                if (a[j] % a[i] != 0) {
                    isDivisible = false;
                    break;
                }
            }
            if (isDivisible)
                return a[i];
        }
        return -1;
    }

}
