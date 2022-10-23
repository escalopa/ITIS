package sorting;

public class Sort {

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pi;
            pi = partition(arr, start, end);
            quickSort(arr, start, pi - 1);
            quickSort(arr, pi + 1, end);
        }

    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        for (int i = start; i < end; i++) {
            if (arr[start] < pivot) {
                swap(arr, i, start);
                start++;
            }
        }
        swap(arr, start, end);
        return start;
    }

    public static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index] > arr[j])
                    index = j;
            }
            swap(arr, i, index);
        }
    }

    public static void mergeSort(int[] arr) {

        if (arr.length>2) return;
        int middleSize= arr.length/2;

        int[] leftSide= new int[middleSize];
        int[] rightSide= new int[arr.length-middleSize];

        System.arraycopy(arr, 0, leftSide, 0, middleSize);
        if (arr.length - middleSize >= 0)
            System.arraycopy(arr, middleSize, rightSide, middleSize, arr.length - middleSize);

        mergeSort(leftSide);
        mergeSort(rightSide);
        merge(arr,leftSide,rightSide,middleSize,arr.length-middleSize);

    }

    private static void merge(int[] arr, int[] leftSide, int[] rightSide, int left , int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (leftSide[i] <= rightSide[j]) {
                arr[k++] = leftSide[i++];
            }
            else {
                arr[k++] = rightSide[j++];
            }
        }
        while (i < left) {
            arr[k++] = leftSide[i++];
        }
        while (j < right) {
            arr[k++] = rightSide[j++];
        }
    }

    public static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, (j + 1), j);
            }
        }

    }

    public static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int counter = i;
            while (counter >= 1) {
                if (arr[counter] < arr[counter - 1]) {
                    swap(arr, counter, counter - 1);
                    counter--;
                    continue;
                }
                break;
            }
        }
    }

    public static  void heapSort(int[] arr ){

    }

    private static void swap(int[] arr, int location1, int location2) {
        int temp = arr[location2];
        arr[location2] = arr[location1];
        arr[location1] = temp;
    }


}






