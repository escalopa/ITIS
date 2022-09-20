import java.util.Arrays;
import java.util.HashMap;

public class SortBySimilarity {

    public static void main(String[] args){

        String[] words= {"Skafyl", "slafyo", "s", "skofly", "oghfol"};

        System.out.println((Arrays.toString(words)));

        System.out.println((Arrays.toString((SortBySim("skafyl",words)))));

    } 

    public static String[] SortBySim(String findMe ,String[] words){

        HashMap<String,Integer> data = new HashMap<>(words.length);
        String[] sorted= new String[words.length];

        for (String word : words) {
            data.put(word, 0);
            for (int j = 0; j < word.length() && j < findMe.length(); j++) {
                if (findMe.charAt(j)==word.charAt(j))
                    data.replace(word, ((data.get(word)) + 1));
            }
        }

        int[] array=new int [words.length];

        for (int i = 0; i < array.length; i++) {
            array[i]=data.get(words[i]);
        }
        
        quicksort(array,0,array.length-1);

        for (int j = 0; j < array.length; j++) {
            sorted[j]=keyofValue(data, array[j]);
            data.remove(sorted[j]);
        }
        return sorted;
    }

    private static String keyofValue(HashMap<String,Integer> map,int value){

        for(String str:map.keySet()){
            if(map.get(str)==value){
                return str;
            }
        }
        return null;
    }

    private static void quicksort(int[] array,int left,int right){
        if(left<right){
            
            int pivot=partion(array,left,right);

            quicksort(array, left, pivot-1);
            quicksort(array, pivot+1, right);

        }
    }

    private static int partion(int[] array,int left,int right){
    
        int pivot=array[right]; 
        for (int i = left; i < right; i++) {
                if(array[i]>=pivot){
                    swap(array, left, i);
                    left++;
                }
        }		
        swap(array, left, right );
		return left;
    }

    private static void swap(int[] array,int index1, int index2){
        int temp=array[index2];
        array[index2]=array[index1];
        array[index1]=temp;

    }


}
