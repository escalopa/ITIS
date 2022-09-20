import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        start();
    }

    /*
    EURUSD_200801_210901.csv
    EURRUB_200801_210901.csv
    */

    public static void start() {
        String pathFile1 ;
        String pathFile2 ;
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Enter the first path");
            DataOperations dataOperations1 = new DataOperations(scanner.next());
            System.out.println("Enter the second path");
            DataOperations dataOperations2 = new DataOperations(scanner.next());

            dataOperations1.start();
            dataOperations2.start();

            try {
                dataOperations1.join();
            } catch (InterruptedException e) {
                System.out.println("500 — ошибка");
            }
            try {
                dataOperations2.join();
            } catch (InterruptedException e) {
                System.out.println("500 — ошибка");
            }
            if (dataOperations1.ready && dataOperations2.ready) {
                double correlationCoefficient = calculateLinearCorrelationCoefficient(dataOperations1, dataOperations2);
                if (correlationCoefficient == -1) {
                    System.err.println("Rows length are not equal in length");
                }
                System.out.println("The linear correlation coefficient for the two currency pairs = "
                        + correlationCoefficient);

                System.out.println("Press /t to see time elapsed for each process");
                scanner = new Scanner(System.in);
                String timeInput = scanner.nextLine();
                if (timeInput.contains("\t")) {
                    System.out.println("Process time on the first file: " + dataOperations1.getTimeElapsed() + " nanosecond");
                    System.out.println("Process time on the second file: " + dataOperations2.getTimeElapsed() + " nanosecond");
                }
                running = false;
            }
        }
        scanner.close();
    }

    private static double calculateLinearCorrelationCoefficient(DataOperations dataOperations1, DataOperations dataOperations2) {
        if (dataOperations1.data.size() != dataOperations2.data.size())
            return -1;
        double numerator = 0;
        double changeX2 = 0;
        double changeY2 = 0;
        for (int i = 0; i < dataOperations1.data.size(); i++) {
            double xDiff = dataOperations1.data.get(i).value - dataOperations1.getMedian();
            double yDiff = dataOperations2.data.get(i).value - dataOperations2.getMedian();
            numerator += xDiff * yDiff;
            changeX2 += xDiff * xDiff;
            changeY2 += yDiff * yDiff;
        }
        // return the correlationCoefficient
        return numerator / (Math.pow(changeX2 * changeY2, 0.5));
    }
}
