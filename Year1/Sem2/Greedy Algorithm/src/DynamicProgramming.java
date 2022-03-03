import java.util.Arrays;

public class DynamicProgramming {

    public static int shortestPathTo1(int num) {
        int[] cache = new int[num + 1];
        cache[1] = 0;
        for (int i = 2; i < (num + 1); i++) {
            int min = cache[i - 1] + 1;
            if (i % 2 == 0)
                min = Math.min(min, 1 + cache[i / 2]);
            if (i % 3 == 0)
                min = Math.min(min, 1 + cache[i / 3]);
            cache[i] = min;
        }
        return cache[num];
    }

    public static int shortestPathToFirstStair(int num) {
        int[] cache = new int[num + 1];
        cache[1] = 1;
        cache[2] = 2;
        cache[3] = 4;
        for (int i = 4; i < num + 1; i++) {
            cache[i]=cache[i-1]+cache[i-2]+cache[i-3];
        }
        return cache[num];
    }


}
