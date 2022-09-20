package Problems;

import java.math.BigInteger;
import java.util.Scanner;

public class Fib {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println(getFib(number).toString());
    }

    public static BigInteger getFib(int number) {
        if (number == 0 || number == 1) return new BigInteger("1");
        BigInteger[] a = new BigInteger[number + 1];
        a[0] = new BigInteger(String.valueOf(1));
        a[1] = new BigInteger(String.valueOf(1));
        int i = 2;
        while (true) {
            a[i] = a[i - 1].add(a[i - 2]);
            if (i == number) {
                break;
            }
            i++;
        }
        return a[i];
    }

    public static void isFib(long number) {
        long[] a = new long[50];
        a[1] = 1;
        a[2] = 1;
        int i = 3;
        while (true) {
            a[i] = a[i - 1] + a[i - 2];
            if (a[i] == number) {
                System.out.println(1 + "\n" + i);
                break;
            } else if (a[i] > number) {
                System.out.println(0);
                break;
            }
            i++;
        }
    }
}
