import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CharCounter {

    public static void CountElements(String filename) throws IOException {

        FileReader data= new FileReader(filename);

        List<Integer> elementsValue= new LinkedList<>();

        int letter;

        elementsValue.add(data.read());

        while ((letter = data.read()) != -1){

            if (!(elementsValue.contains(letter))){
                elementsValue.add(letter);
            }

        }

        Collections.sort(elementsValue);

        BufferedWriter outputStream = new BufferedWriter(new FileWriter(
                "C:\\Users\\Ahmed\\Desktop\\CharElements.txt"));
        int i = 0;
        while (i < elementsValue.size()) {
            outputStream.write(elementsValue.get(i));
            i++;
        }
        outputStream.close();

    }
}
