package GreedyAlgorithms;

import java.util.Scanner;

public class FloatingNumber {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i <n ; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println(calculate(l, n, array));

    }

    public static int calculate(int l ,int n,int[] array){
        return 0;
    }
}
