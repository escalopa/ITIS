import java.util.Comparator;

public class SizeTime implements Comparator<SizeTime> {

    private int size;
    private long timeNanoTim;
    private long timeNanoMerge;
    private long timeNanoInsertion;
    private int iterations;

    SizeTime() {

    }

    public SizeTime(int size, long timeNanoTim, long timeNanoMerge, long timeNanoInsertion, int iterations) {
        this.size = size;
        this.timeNanoTim = timeNanoTim;
        this.timeNanoMerge = timeNanoMerge;
        this.timeNanoInsertion = timeNanoInsertion;
        this.iterations = iterations;
    }

    public int getSize() {
        return size;
    }

    @Override
    public int compare(SizeTime o1, SizeTime o2) {
        return Integer.compare(o1.getSize(), o2.getSize());
    }

    @Override
    public String toString() {
        return this.size + "," + this.timeNanoTim + "," + this.timeNanoMerge + "," + this.timeNanoInsertion + "," + this.iterations;
    }
}
