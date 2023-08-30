import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class MetricCalculatorTest {
    private MetricCalculator testObject= new MetricCalculator();
    @Before
    public void setUp() throws Exception {
        System.out.println("setUp");
    }

    @Test
    public void test_ComputeMetricValue_Succes() {
        int result = testObject.computeMetricValue("10 cm + 1 m - 10 mm");
        assertEquals(1110, result);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
        testObject = null;
    }
}