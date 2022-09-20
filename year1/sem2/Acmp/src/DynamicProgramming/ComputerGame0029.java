package DynamicProgramming;

import java.util.Scanner;

public class ComputerGame0029 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println(minJumps(arr));
    }

    public static int minJumps(int[] arr) {
        int[] steps = new int[arr.length + 1];
        int sum =0;
        steps[1] = 0;
        steps[2] = Math.abs(arr[0]-arr[1]);
        for (int i = 2; i < arr.length; i++) {
            steps[i+1] = Integer.min(Math.abs(arr[i]-arr[i-1])+steps[i],3*Math.abs(arr[i]-arr[i-2]+steps[i-1]));
            sum = steps[i+1];
        }
        return sum;
    }
}
