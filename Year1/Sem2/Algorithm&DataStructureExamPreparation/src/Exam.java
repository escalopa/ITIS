import java.util.Arrays;
import java.util.Scanner;

public class Exam {

    static Scanner scanner = new Scanner(System.in);
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        solve();
        scanner.close();
    }

    public static void solve() {

        int[] a = readArray();
        Arrays.sort(a);
        int[] count = new int[max + 1 - min];
        count[0] = 0;
        for (int i = 0; i < a.length; i++) {
            if (count[a[i] - min] == 0)
                count[a[i] - min] = i;
        }
        int currentMax = count[count.length - 1];
        for (int i = count.length - 2; i > 0; i--) {
            if (count[i] == 0)
                count[i] = currentMax;
            else
                currentMax = count[i];
        }
        int q = scanner.nextInt();
        for (int i = 0, j; i < q; i++) {
            printTheValue(scanner.nextInt(),a,count);
        }
    }

    public static void printTheValue(int j,int[]a,int[]count){
        if (j > max)
            System.out.print(a.length + " ");
        else if (j <= min)
            System.out.print("0 ");
        else
            System.out.print(count[j - min] + " ");

    }
    private static int getMin(int[] a, int k) {
        int count = 0;
        for (int i = 0; i < a.length && a[i] < k; i++) {
            count++;
        }
        return count;
    }

    public static int[] readArray() {
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            min = Integer.min(min, a[i]);
            max = Integer.max(max, a[i]);
        }
        return a;
    }

    public static int[] readQueries() {
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        return a;
    }
}
