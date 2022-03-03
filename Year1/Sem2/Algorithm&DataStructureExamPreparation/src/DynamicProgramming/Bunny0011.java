package DynamicProgramming;
import java.util.Scanner;

public class Bunny0011 {

    public static void main(String[] args) {

        int k, n;
        Scanner scanner = new Scanner(System.in);
        k = scanner.nextInt();
        n = scanner.nextInt();
        scanner.close();
        System.out.println(minSteps(k, n));
    }

    private static int minSteps(int k, int n) {
        int[] cache = new int[n + 1];
        cache[1] = 1;
        for (int i = 2; i <= k; i++) {
            cache[i] = cache[i - 1] * 2;
        }
        for (int i = k + 1; i < n + 1; i++) {
            for (int j = 1; j <= k; j++) {
                cache[i] += cache[i - j];
            }
        }
        return cache[n];
    }
}
