import lombok.Data;

import java.util.Date;

@Data
public class DataCollector implements Comparable<DataCollector> {

    public DataCollector(long date, double value) {
        this.date = date;
        this.value = value;
    }

    long date;
    double value;

    @Override
    public int compareTo(DataCollector o) {
        return Long.compare(date,o.date);
    }
}
