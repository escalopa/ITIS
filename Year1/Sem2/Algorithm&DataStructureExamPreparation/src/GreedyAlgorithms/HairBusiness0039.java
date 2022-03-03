package GreedyAlgorithms;
import java.util.*;

public class HairBusiness0039 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (scanner.nextInt());
        }
        scanner.close();
        System.out.println(maxMoney(arr));
    }

    public static int maxMoney(Integer[] arr) {
        int sum = 0;
        int days = 1;
        List<Integer> clone = new ArrayList<>(Arrays.asList(arr));
        clone.sort(Collections.reverseOrder());
        for (int i = 0 ; i < arr.length; i++, days++) {
            if (arr[i].equals(clone.get(0))) {
                sum += (days) * clone.get(0);
                days = 0;
            }
          clone.remove(arr[i]);
        }
        return sum;
    }
}
