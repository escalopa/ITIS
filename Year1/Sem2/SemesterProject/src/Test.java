import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

public class Test {

    //Method to check if array is sorted
    public static boolean isSorted(int[] array) {
        return IntStream.range(0, array.length - 1).noneMatch(i -> array[i] > array[i + 1]);
    }

    // Program to print time needed with respect to input
    public static void main(String[] args) throws IOException {

        int[][] matrix = null;

        //DataGenerate.writeRandomSets("testCases.TXT");

        matrix = DataGenerate.readSets("testCases.TXT");

        DataAnalysis.sortAnalysisArray(matrix);

        System.out.println("\u001B[32m"+"Data created Successfully "+"\u001B[0m");

    }

}
