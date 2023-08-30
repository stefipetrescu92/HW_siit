public class Main {
    public static void main(String[] args) {
        String expression = "10 cm + 1 m - 10 mm";
        int result = MetricCalculator.computeMetricValue(expression);
        System.out.println("Result: " + result + " mm");
    }
}
