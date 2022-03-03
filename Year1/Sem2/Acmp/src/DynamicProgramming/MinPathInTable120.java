package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class MinPathInTable120 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
        System.out.println(minPath(matrix, n, m));
    }

    public static int minPath(int[][] matrix, int n, int m) {

        int[][] minPathMatrix = new int[n][m];
        for (int[] arr : minPathMatrix) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        minPathMatrix[0][0] = matrix[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                move(matrix, minPathMatrix, n, m, i, j);
            }
        }

        return minPathMatrix[n - 1][m - 1];
    }

    private static void move(int[][] matrix, int[][] minPathMatrix, int n, int m, int i, int j) {

        //move right
        if (j < m - 1 && (minPathMatrix[i][j] + matrix[i][j + 1]) < minPathMatrix[i][j + 1])
            minPathMatrix[i][j + 1] = minPathMatrix[i][j] + matrix[i][j + 1];

        //move down
        if (i < n - 1 && (minPathMatrix[i][j] + matrix[i+1][j]) < minPathMatrix[i+1][j])
            minPathMatrix[i+1][j] = minPathMatrix[i][j] + matrix[i+1][j];
    }

}
