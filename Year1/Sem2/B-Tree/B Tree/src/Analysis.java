import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Analysis {

    static int size;

    private static List<Long> insertionTime = new LinkedList<>();
    private static List<Long> findTime = new LinkedList<>();
    private static List<Long> deletionTime = new LinkedList<>();

    private static long sumAllElements(List<Long> list) {
        long sum = 0;
        for (Long l : list) {
            sum += l;
        }
        return sum;
    }

    public static void printAverage() {
        System.out.println("Insertion Time: " + sumAllElements(insertionTime));
        System.out.println("Find Time: " + sumAllElements(findTime));
        System.out.println("Deletion Time: " + sumAllElements(deletionTime));
    }

    private static int[] generateArray(int size, int bound) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = new Random().nextInt(bound);
        }
        return array;
    }

    public static void analysisData(int T) {
        size = 10000;
        int bound = 10000;
        long start;
        long end;
        BTree bTree = new BTree(T);
        int[] array = generateArray(size, bound);

        //Insertion time calculations
        for (int j : array) {
            start = System.nanoTime();
            bTree.Insert(j);
            end = System.nanoTime();
            insertionTime.add(end - start);
        }

        //Find time calculation
        for (int i = 0; i < 100; i++) {
            int key = array[new Random().nextInt(size)];
            start = System.nanoTime();
            bTree.Contain(key);
            end = System.nanoTime();
            findTime.add(end - start);
        }

        //Deletion time calculation
        for (int i = 0; i < 1000; i++, size--) {
            int key = array[new Random().nextInt(size)];
            start = System.nanoTime();
            bTree.Remove(key);
            end = System.nanoTime();
            deletionTime.add(end - start);
        }
    }

    public static void writeData() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("Data.CSV"));
        bw.write("Size , Insertion Time\n");

        for (int i = 0; i < insertionTime.size(); i++) {
            bw.write((i + 1) + "," + insertionTime.get(i) + "\n");
        }

        bw.write("Find Time\n");
        for (Long aLong : findTime) {
            bw.write(aLong + "\n");
        }

        bw.write("Size , Deletion Time\n");
        for (int i = 0; i < deletionTime.size(); i++) {
            bw.write((size + deletionTime.size() - i) + "," + deletionTime.get(i) + "\n");

        }

        bw.close();


    }

}
