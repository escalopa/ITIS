package Problems;

import java.util.Arrays;
import java.util.Scanner;

public class beautifulPainting {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        int count = 0;
        int max = Integer.MIN_VALUE;
        boolean change = false;
        for (int i = 0; i < n; i++) {
            if (a[i] != -1) {
                max = a[i];
                a[i] = -1;
                for (int j = i + 1; j < n; j++) {
                    if (a[j] > max) {
                        max = a[j];
                        a[j] = -1;
                        count++;
                        change = true;
                    }
                }
                if (!change) break;
            }
        }
        System.out.println(count);
    }
}

