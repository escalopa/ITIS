package GreedyAlgorithms;

import java.util.Scanner;

public class Code {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        int digits = scanner.nextInt();

        createCode(sum, digits);
    }

    private static void createCode(int sum, int digits) {
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        int stringSum = 0;

        for (int i = 0; i < digits; i++) {
            for (int j = 9; j >= 0; j--) {
                if (stringSum + j <= sum) {
                    stringSum += j;
                    num1.append(j);
                    break;
                }
            }
        }
        System.out.println(num1.toString() + " " + num1.toString());
    }
}
