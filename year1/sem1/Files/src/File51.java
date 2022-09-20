import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class File51 {

    public static void SortNumberData(String filename1, String filename2, String filename3) throws IOException {

        List<Integer> list = new ArrayList<Integer>();

        BufferedReader reader1 = new BufferedReader(new FileReader(filename1));
        BufferedReader reader2 = new BufferedReader(new FileReader(filename2));
        BufferedReader reader3 = new BufferedReader(new FileReader(filename3));

        String text ;
        while ((text = reader1.readLine()) != null) {
            for (String str:text.split(" ")){
                list.add(Integer.parseInt(str));
            }
        }
        while ((text = reader2.readLine()) != null) {
            for (String str:text.split(" ")){
                if(text.equals("")){continue;}
                list.add(Integer.parseInt(str));
            }
        }
        while ((text = reader3.readLine()) != null) {
            if(text.equals("")){continue;}
            for (String str:text.split(" ")){
                list.add(Integer.parseInt(str));
            }
        }

        reader1.close();
        reader2.close();
        reader3.close();
        Collections.sort(list, Collections.reverseOrder());



        BufferedWriter outputStream = new BufferedWriter(new FileWriter(
                "C:\\Users\\Ahmed\\Desktop\\output.txt"));
        int i = 0;
        String str;
        while (i < list.size()) {
            str=(list.get(i)+" ");
            outputStream.write(str);
            i++;
        }
        outputStream.close();
        System.out.println(list);

    }
}
