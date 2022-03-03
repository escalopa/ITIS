package Problems;

import java.util.Scanner;

public class SumOfDigits {

    static class Pair {
        String a;
        String b;

        public Pair(String a, String b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return a + " " + b;
        }
    }

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println(solve().toString());
    }

    private static Pair solve() {
        int m = sc.nextInt();
        int s = sc.nextInt();
        if (s == 0 && m == 1)
            return new Pair("0", "0");
        else if (s == 0 || 9 * m < s)
            return new Pair("-1", "-1");
        StringBuilder max = new StringBuilder();
        int sum = 0;
        int digits = 0;
        for (int i = 9; i >= 0 && digits < m; i--) {
            if (sum + i <= s) {
                sum += i;
                digits++;
                max.append(i);
                i++;
            }
        }
        StringBuilder min = new StringBuilder();
        if (max.charAt(digits - 1) == '0') {
            sum = 1;
            digits = 1;
            for (int i = 9; i >= 0 && digits < m; i--) {
                if (sum + i <= s) {
                    sum += i;
                    digits++;
                    min.append(i);
                    i++;
                }
            }
            min.reverse().insert(0, "1");
        } else
            min = new StringBuilder(max).reverse();

        return new Pair(min.toString(), max.toString());
    }

    private static int getMinFromString(StringBuilder s) {
        StringBuilder c = new StringBuilder(s).reverse();
        if (c.charAt(0) == '0') {
            for (int i = 1; i < c.length(); i++) {
                if (c.charAt(i) != '0') {
                    c.setCharAt(0, c.charAt(i));
                    c.setCharAt(i, '0');
                    break;
                }
            }
            return Integer.parseInt(c.toString());
        }
        return Integer.parseInt(c.toString());
    }
}
