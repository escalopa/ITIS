import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static HashMap<Integer, BigDecimal> knockedPoints;
    private static HashMap<Integer, BigDecimal> possiblePoints;
    private static final int hitKnocks = 3;
    private static final int allShots = 5;
    private static int eventCount = 0;

    public static void main(String[] args) {
        initialize();
        insertValues();
        solve();
        printResults();
        Probability probability = new Probability(possiblePoints);
        System.out.println("математическое ожидание  = "+
                probability.calculateMathematicalExpectation());
        System.out.println("дисперсия = "+
                probability.calculateVariance());
        System.out.println(eventCount);
    }

    private static void initialize() {
        knockedPoints = new HashMap<>();
        possiblePoints = new HashMap<>();
    }

    private static void solve() {
        int shotsCount = 0;
        getAllEvents(shotsCount, new LinkedList<>());
    }

    private static void insertValues() {
        knockedPoints.put(0, new BigDecimal("0.1"));
        knockedPoints.put(2, new BigDecimal("0.3"));
        knockedPoints.put(1, new BigDecimal("0.2"));
        knockedPoints.put(3, new BigDecimal("0.4"));
    }

    private static void getAllEvents(int shotsCount, List<Integer> integers) {
        if (shotsCount == allShots) {
            incrementPossiblePointsValue(integers);
        } else {
            for (int i = 0; i <= hitKnocks; i++) {
                integers.add(i);
                getAllEvents(shotsCount + 1, integers);
                integers.remove(integers.size() - 1);
            }
        }
    }

    private static void incrementPossiblePointsValue(List<Integer> event) {
        int shots = countShots(event);
        eventCount++;
        BigDecimal probability = getProbability(event);
        if (possiblePoints.containsKey(shots)) {
            probability = probability.add(possiblePoints.get(shots));
        }
        possiblePoints.put(shots, probability);
    }

    private static int countShots(List<Integer> shots) {
        return shots.stream().mapToInt(Integer::intValue).sum();
    }

    private static BigDecimal getProbability(List<Integer> event) {
        BigDecimal prob = new BigDecimal("1.0");
        for (Integer integer : event) {
            prob = prob.multiply(knockedPoints.get(integer));
        }
        return prob;
    }


    private static void printResults() {
        for (Integer integer:possiblePoints.keySet()) {
            System.out.println(integer+" = "+possiblePoints.get(integer));
        }
        BigDecimal sum = new BigDecimal("0.0");
        for (BigDecimal d : possiblePoints.values()) {
            sum = sum.add(d);
        }
        System.out.println("Сумма всех событий = "+sum);
    }
}
