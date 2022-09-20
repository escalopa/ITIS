package ConTest;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProblemD {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int k = scanner.nextInt();
        int n = scanner.nextInt();

        System.out.println(groupsNumber(n,k));
    }

    private static int groupsNumber(int n, int k) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n ; i++) {
            int x = scanner.nextInt();
            set.add(getHexDecimalValue(x,k));
        }
        return set.size();
    }

    private static int getHexDecimalValue(int x,int k) {
        if (x ==0)
            return 0;
        return (x%k)*k + getHexDecimalValue(x/k,k);
    }
}
