package ConTest;

import java.util.Scanner;

public class ProblemB {

    public static void main(String[] args) {

        long n, k;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        scanner.close();
        System.out.println(minSteps(n, k));
    }

    private static long minSteps(long n, long m) {

        long[] cache = new long[(int) Long.max(5, n+1)];
        cache[0] = 0;
        cache[1] = 1%m;
        cache[2] = 1%m;
        cache[3] = 2%m;
        cache[4] = 4%m;
        for (int i = 5; i < n+1; i++) {
            cache[i] = (cache[i - 1]%m + cache[i - 2]%m + cache[i - 3]%m + cache[i - 4]%m)%m;
        }
        return cache[(int) (n)];
    }
}
