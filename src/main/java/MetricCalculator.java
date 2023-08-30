import java.util.HashMap;
import java.util.Map;

public class MetricCalculator {
    private static final Map<String, Integer> UNIT_CONVERSIONS = new HashMap<>();

    static {
        UNIT_CONVERSIONS.put("mm", 1);
        UNIT_CONVERSIONS.put("cm", 10);
        UNIT_CONVERSIONS.put("dm", 100);
        UNIT_CONVERSIONS.put("m", 1000);
        UNIT_CONVERSIONS.put("km", 1000000);
    }

    public static int computeMetricValue(String expression) {
        String[] tokens = expression.split("\\s+");

        int result = 0;
        int currentNumber = 0;
        String currentUnit = "mm";

        for (String token : tokens) {
            if (token.matches("[+-]")) {
                result += currentNumber * UNIT_CONVERSIONS.get(currentUnit);
                currentNumber = 0;
                if (token.equals("-")) {
                    currentNumber = currentNumber * (-1);
                }
            } else if (token.matches("\\d+")) {
                currentNumber = Integer.parseInt(token);
            } else if (UNIT_CONVERSIONS.containsKey(token)) {
                currentUnit = token;
            }
        }

        result += currentNumber * UNIT_CONVERSIONS.get(currentUnit);
        return result;
    }
}