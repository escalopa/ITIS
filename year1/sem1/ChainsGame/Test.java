import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class Test {

    //private static String[] dictionary;
    private static long size;
    private static HashMap<String,Integer> history;

    private static void readDictionary(String filename) throws IOException {
        File file = new File(filename);
        size = file.length() / 10;
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;

        history= new HashMap((int)size);
        //dictionary = new String[(int) size];
        while ((line = br.readLine()) != null) {
            //dictionary[i++] = line;
            history.put(line,0);
        }
        br.close();
    }


    public static boolean binarySearch(String findMe, String[] sorted) {
        int left = 0;
        int right = sorted.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (sorted[middle].compareTo(findMe) < 0) {
                left = middle + 1;
            } else if (sorted[middle].compareTo(findMe) > 0) {
                right = middle - 1;
            } else {
                return true;
            }
        }
        return false;
    }


    private static String[] getWords(String begin, String end) {
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < begin.length(); i++) {

            String current = begin;
            if (!(current.charAt(i) == end.charAt(i))) {
                for (int j = 0; j < abc.length(); j++) {

                    char[] word = current.toCharArray();
                    word[i] = abc.charAt(j);
                    current = String.valueOf(word);
                    if (!current.equals(begin) && history.containsKey(current) && (history.get(current)==0)){ 
                        history.replace(current,1);
                        sb.append(current).append(",");
                    }
                }
            }
        }
        return sb.toString().split(",");
    }
    public static void game(String begin, String end) {
        if (begin.equals(end)) {
            System.out.println("Found!");
            System.out.println(end);
            return;
        }

        System.out.print(begin + ": ");
        String[] words = getWords(begin, end);
        System.out.println(Arrays.toString(words));

        for (int i = 0; i < words.length; i++) {
            game(words[i], end);
        }

    }

    public static void main(String[] args) {
        // муха => слон
        // стук - сток - стон - слон
        String begin = "стук";
        String end = "слон";
        try {
            readDictionary("D:\\programming\\Code\\CommonCodes\\CommonTasks\\ChainsGame\\Test.java");
        } catch (IOException e) {
            e.printStackTrace();
        }
        game(begin, end);


    }

}
