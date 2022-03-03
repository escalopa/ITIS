import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DataGenerate {

    public static int[][] readSets(String filePath) throws IOException {

        int size;
        int[][] matrix;
        Scanner scanner = new Scanner(new File(filePath));
        size = scanner.nextInt();
        matrix = new int[size][];
        for (int i = 0; i < size; i++) {
            int arraySize = scanner.nextInt();
            matrix[i] = new int[arraySize];
            for (int j = 0; j < arraySize; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
        return matrix;
    }

    public static void writeRandomSets(String fileName) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));

        int[][] matrix = generateMatrixArrayArray();
        bufferedWriter.write(matrix.length + " ");
        for (int[] array : matrix) {
            bufferedWriter.write(array.length + " ");
            for (int value : array) {
                bufferedWriter.write(value + " ");
            }
        }
        bufferedWriter.close();
    }

    private static int generateSize(int max, int min) {
        return (new Random().nextInt(max - min + 1) + min);
    }

    static int row;
    static int column;

    public static int[][] generateMatrixArrayArray() {
        row = 100;
        int[][] matrix = new int[row][];
        for (int i = 0; i < row; i++) {
            column = generateSize(10000, 100);
            matrix[i] = new int[column];
            for (int j = 0; j < column; j++) {
                matrix[i][j] = new Random().nextInt(10000);
            }
        }
        return matrix;
    }

    public static List<List<Integer>> generateMatrixList() {
        row = generateSize(100, 50);
        List<List<Integer>> matrix = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            column = generateSize(10000, 100);
            matrix.set(i, new LinkedList<>());
            for (int j = 0; j < column; j++) {
                matrix.get(i).set(j, new Random().nextInt(10000));
            }
        }
        return matrix;
    }
}
