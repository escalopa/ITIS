import java.util.stream.IntStream;

public class Sorting {

    public static int iterations = 0;

    public static boolean isSorted(int[] array) {
        return IntStream.range(0, array.length - 1).noneMatch(i -> array[i] > array[i + 1]);
    }

    static int MIN_MERGE = 64;

    private static int minRunLength(int n) {
        assert n >= 0;

        // Becomes 1 if any 1 bits are shifted off
        int r = 0;
        while (n >= MIN_MERGE) {
            r = n % 2 == 0 ? 0 : 1;
            //r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    // This function sorts array from left index to
    // to right index which is of size at most RUN
    public static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
                iterations++;
            }
            arr[j + 1] = temp;
        }
    }

    // Merge function merges the sorted runs
    private static void merge(int[] arr, int l, int m, int r) {
        // Original array is broken in two parts
        // left and right array
        int len1 = m - l + 1, len2 = r - m;
        int[] left = new int[len1];
        int[] right = new int[len2];
        if (len1 >= 0) System.arraycopy(arr, l, left, 0, len1);
        for (int x = 0; x < len2; x++) {
            right[x] = arr[m + 1 + x];
            iterations++;
        }

        int i = 0;
        int j = 0;
        int k = l;

        // After comparing, we merge those two array
        // in larger sub array
        while (i < len1 && j < len2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
            iterations++;
        }

        // Copy remaining elements
        // of left, if any
        while (i < len1) {
            arr[k] = left[i];
            k++;
            i++;
            iterations++;
        }

        // Copy remaining element
        // of right, if any
        while (j < len2) {
            arr[k] = right[j];
            k++;
            j++;
            iterations++;
        }
    }

    // Iterative Tim sort function to sort the
    // array[0...n-1] (similar to merge sort)
    public static void timSort(int[] arr, int n) {
        int minRun = minRunLength(MIN_MERGE);

        // Sort individual subArrays of size RUN
        for (int i = 0; i < n; i += minRun) {
            insertionSort(arr, i, Math.min((i + MIN_MERGE - 1), (n - 1)));
        }

        // Start merging from size
        // RUN (or 64). It will
        // merge to form size 128,
        // then 256, 512 and so on
        for (int size = minRun; size < n; size = 2 * size) {

            // Pick starting point
            // of left sub array. We
            // are going to merge
            // arr[left..left+size-1]
            // and arr[left+size, left+2*size-1]
            // After every merge, we
            // increase left by 2*size
            for (int left = 0; left < n; left += 2 * size) {

                // Find ending point of left sub array
                // mid+1 is starting point of right sub
                // array
                int mid = left + size - 1;
                int right = Math.min((mid + size), (n - 1));

                // Merge sub array arr[left.....mid] &
                // arr[mid+1....right]
                if (mid < right)
                    merge(arr, left, mid, right);
            }
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static void mergeSort(int[] arr, int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}
