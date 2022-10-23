package sorting;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.junit.jupiter.api.BeforeEach;

public class SortTest {

    int [] array = new int[100];

    @BeforeEach
    public void setUp()  {

        fillArray(array);

    }

    @Test
    public void testingQuickSort(){
        Sort.quickSort(array,0, array.length-1);
        Assert.assertTrue(isSortedAscending(array));
    }
    @Test
    public void testingSelectionSort(){
        Sort.selectionSort(array);
        Assert.assertTrue(isSortedAscending(array));
    }

    @Test
    public void testingBubbleSort(){
        Sort.bubbleSort(array);
        Assert.assertTrue(isSortedAscending(array));
    }
    @Test
    public void testingMergingSort(){
        Sort.mergeSort(array);
        Assert.assertTrue(isSortedAscending(array));
    }
    @Test
    public void testingInsertionSort(){
        Sort.insertionSort(array);
        Assert.assertTrue(isSortedAscending(array));
    }

    @Test
    public void testingHeapSort(){
        Sort.heapSort(array);
        Assert.assertTrue(isSortedAscending(array));
    }

    private void fillArray(int []arr){

        for(int i =0 ;i<arr.length ;i++){
            array[i]=(int)(Math.random()*100);
        }
    }

    private static boolean isSortedAscending(int []arr){

        for (int i = 0; i <arr.length-1 ; i++) {
            if (arr[i]>arr[i+1]) return  false;
        }
        return  true;
    }

}