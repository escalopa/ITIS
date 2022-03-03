import lombok.Data;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Data
public class DataOperations extends Thread {

    public List<DataCollector> data;
    public double elementsSum = 0;
    public double median;
    private final String path;
    private long timeElapsed = 0;
    public boolean ready = true;
    DataOperations(String path) {
        this.path = path;
        data = new LinkedList<>();
    }

    @Override
    public void run() {
        long startTime = System.nanoTime();
        try {
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sortData();
        calculateMedian();
        timeElapsed = System.nanoTime() - startTime;
    }

    //read file
    private void readFile() throws IOException {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            System.err.println("502 — не найден");
            ready = false;
            return;
        }
        String line;
        String[] lineSplitted;
        br.readLine();
        while ((line = br.readLine()) != null) {
            lineSplitted = line.split(",");
            data.add(new DataCollector(Long.parseLong(lineSplitted[2]), Double.parseDouble(lineSplitted[4])));
        }
        br.close();
    }
    //sort file
    private void sortData() {
        Collections.sort(data);
    }

    //calculate median
    public void calculateMedian() {
        median = elementsSum / data.size();
    }
}
