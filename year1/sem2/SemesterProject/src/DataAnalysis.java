import java.io.*;
import java.util.*;

public class DataAnalysis {

    static List<SizeTime> sizeTimes = new LinkedList<>();

    public static void sortAnalysisArray(int[][] matrix) throws IOException {

        for (int[] arr : matrix) {
            timeCalculator(arr);
            Sorting.iterations = 0;
        }
        writeData();
    }

    private static void writeData() throws IOException {

        int i = 0;
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Data1.CSV"));
        bufferedWriter.write("TestCase,Array Size,Time TimSort(NanoSecond),Time MergeSort(NanoSecond),Time InsertionSort(NanoSecond),Iterations\n");
        sizeTimes.sort(new SizeTime());
        for (SizeTime e : sizeTimes) {
            bufferedWriter.write("Test case " + i + "," + e.toString() + "\n");
            i++;
        }
        bufferedWriter.close();
    }

    private static void timeCalculator(int[] arr) {

        // Define the needed data
        int[] arrMerge = new int[arr.length];
        int[] arrInsertion = new int[arr.length];
        long startTime;
        long stopTime;
        long timSortTime;
        long mergeSortTime;
        long insertionSortTime;

        //Copy arrays
        System.arraycopy(arr,0,arrMerge,0,arr.length-1);
        System.arraycopy(arr,0,arrInsertion,0,arr.length-1);

        //Calculate Tim time
        startTime = System.nanoTime();
        Sorting.timSort(arr, arr.length);
        stopTime = System.nanoTime();
        timSortTime = stopTime - startTime;

        int iterations = Sorting.iterations;

        //Calculate Merge time
        startTime = System.nanoTime();
        Sorting.mergeSort(arrMerge,0,arrMerge.length-1);
        stopTime = System.nanoTime();
        mergeSortTime = stopTime - startTime;

        //Calculate Insertion time
        startTime = System.nanoTime();
        Sorting.insertionSort(arrInsertion,0,arrInsertion.length-1);
        stopTime = System.nanoTime();
        insertionSortTime = stopTime - startTime;

        sizeTimes.add(new SizeTime(arr.length,timSortTime,mergeSortTime,insertionSortTime, iterations));

    }
}
