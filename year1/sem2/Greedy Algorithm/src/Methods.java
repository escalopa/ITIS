import java.util.Arrays;

public class Methods {


    public static int fibRecursion(int n) {
        if (n == 1 || n == 2)
            return 1;
        return fibRecursion(n - 1) + fibRecursion(n - 2);
    }

    public static int fib(int n) {
        int[] cache = new int[n];
        Arrays.fill(cache, -1);
        return fibCash(n, cache);
    }

    private static int fibCash(int k, int[] cache) {
        if (cache[k] == -1) {
            if (k == 0 || k == 1)
                cache[k] = 1;
            else
                cache[k] = fibCash(k - 1, cache) + fibCash(k - 2, cache);
        }
        return cache[k];
    }

    public static int minCoins(int num, int[] coins) {
        Arrays.sort(coins);
        int clone = num;
        int usedCoins = 0;
        int lastCoin;
        int pointer = coins.length - 1;
        if (num == 0) return 0;
        while (clone > 0) {
            if (clone - coins[pointer] >= 0) {
                clone -= coins[pointer];
                lastCoin = coins[pointer];
                usedCoins++;
            } else
                pointer--;
        }
        return usedCoins;
    }
}
