import java.math.BigDecimal;
import java.util.HashMap;

public class Probability {

    HashMap<Integer,BigDecimal> events;

    public Probability(HashMap<Integer,BigDecimal> event){
        this.events = event;
    }

    private BigDecimal mathematicalExpectation = null;

    public BigDecimal calculateMathematicalExpectation(){
        mathematicalExpectation = new BigDecimal("0.0");
        for (Integer integer:events.keySet()) {
            mathematicalExpectation = mathematicalExpectation.add(events.get(integer).multiply(new BigDecimal(integer)));
        }
        return mathematicalExpectation;
    }
    public BigDecimal calculateVariance(){
        BigDecimal variance = new BigDecimal("0.0");
        for (Integer integer:events.keySet()) {
            variance = variance.add(events.get(integer).multiply(new BigDecimal(integer)).multiply(new BigDecimal(integer)));
        }
        return variance.subtract(mathematicalExpectation.multiply(mathematicalExpectation));
    }
}