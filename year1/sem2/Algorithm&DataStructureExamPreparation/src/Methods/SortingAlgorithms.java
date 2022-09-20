package Methods;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class SortingAlgorithms {


    public boolean isPrime(int n) {
        if (n == 2) return true;
        for (int i = 2; i < Math.sqrt(n) + 1; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public int primeInRange(int a, int b) {
        int count = 0;
        for (int i = a; i < b; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }

    public int[] generateArray(int size, int bound) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = new Random().nextInt(bound);
        }
        return arr;
    }

    public boolean isSorted(int[] arr) {
        return IntStream.range(0, arr.length - 1).noneMatch(i -> arr[i] > arr[i + 1]);
    }

    public void insertionSort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            if (a[i] < a[i - 1]) {
                int temp = a[i];
                int j = i - 1;
                for (; j >= 0 && a[j] > temp; j--) {
                    a[j + 1] = a[j];
                }
                a[j + 1] = temp;
            }
        }
    }

    public void countSort(int[] arr, int n, int min, int max) {
        int[] count = new int[max - min + 1];
        int[] output = new int[n];

        for (int i = 0; i < n; i++) {
            count[arr[i] - min]++;
        }
        for (int i = 1; i < (max - min + 1); i++) {
            count[i] += count[i - 1];
        }
        for (int i = 0; i < n; i++) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
        if (n >= 0) System.arraycopy(output, 0, arr, 0, n);
    }

    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            }
        }
    }

    public void quickSort(int[] arr, int l, int r) {
        if (l < r) {

            int p = setPivot(arr, l, r);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, r);
        }

    }

    private int setPivot(int[] arr, int l, int r) {
        int pivot = arr[r];
        int s = l;
        for (int i = l; i < r; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, s);
                s++;
            }
        }
        swap(arr, s, r);
        return s;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void mergeSort(int[] arr, int l, int r) {
        if (l < r) {

            int m = (l + r)/2;
            mergeSort(arr, l, m - 1);
            mergeSort(arr, m +1, r);

            merge(arr, l, m, r);

        }
    }

    private void merge(int[] arr, int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        for (int i = 0; i < n1; i++) {
            arr1[i] = arr[i + l];
        }
        for (int i = 0; i < n2; i++) {
            arr2[i] = arr[i + m + 1];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (arr1[i] > arr2[j]) {
                arr[k] = arr2[j];
                j++;
            } else {
                arr[k] = arr1[i];
                i++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = arr1[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = arr2[j];
            j++;
            k++;
        }
    }
}
