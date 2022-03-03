import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class File45 {

    public static void FromShort2Long(String filename1, String filename2, String filename3) throws IOException {

        FileInputStream fileInputStream1 = new FileInputStream(filename1);
        FileInputStream fileInputStream2 = new FileInputStream(filename2);
        FileInputStream fileInputStream3 = new FileInputStream(filename3);

        HashMap<Integer,FileInputStream> inputs0= new HashMap(3);

        inputs0.put(fileInputStream1.available(),fileInputStream1);
        inputs0.put(fileInputStream2.available(),fileInputStream2);
        inputs0.put(fileInputStream3.available(),fileInputStream3);

        HashMap <Integer, String> inputs1= new HashMap(3);

        inputs1.put(fileInputStream1.available(),filename1);
        inputs1.put(fileInputStream2.available(),filename2);
        inputs1.put(fileInputStream3.available(),filename3);

        List<Integer> list= new ArrayList<>();

        list.add(fileInputStream1.available());
        list.add(fileInputStream2.available());
        list.add(fileInputStream3.available());

        Collections.sort(list);

        FileOutputStream output=new FileOutputStream((inputs1.get(list.get(2))));

        int b;
        System.out.println("Process started");
        while ((b = inputs0.get(list.get(0)).read()) != -1)  {
            output.write(b);
        }
        output.close();
        fileInputStream1.close();
        fileInputStream2.close();
        fileInputStream3.close();
        System.out.println("Transfer done successfully !");


    }
}
