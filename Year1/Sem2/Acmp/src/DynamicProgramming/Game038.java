package DynamicProgramming;

import java.util.Scanner;

public class Game038 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=scanner.nextInt();
        }
        scanner.close();
        System.out.println(whoWon(n,arr));
    }

    public static int whoWon(int size,int[] array){

        return 0;
    }
}
