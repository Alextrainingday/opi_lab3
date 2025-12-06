import beans.Result;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Parameterized tests to efficiently cover various regions and quadrants of the graph.
 */
@RunWith(Parameterized.class)
public class ParameterizedHitTest {
    // Fields to hold the parameterized data for each test run
    private final BigDecimal x;
    private final BigDecimal y;
    private final BigDecimal r;
    private final boolean expected;
    
    // The object under test
    private final Result result = new Result();
    
    // 1. Constructor: JUnit calls this for each set of data
    public ParameterizedHitTest(String x, String y, String r, boolean expected) {
        this.x = new BigDecimal(x);
        this.y = new BigDecimal(y);
        this.r = new BigDecimal(r);
        this.expected = expected;
    }

    // 2. Data Provider: Provides the data sets to the runner
    @Parameters(name = "X:{0}, Y:{1}, R:{2} -> Expected:{3}")
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][] {
            // Test Data Format: {X, Y, R, Expected Result}
            
            // Core Hits
            {"0.0", "0.0", "1.0", true},          // Origin (Hit)
            {"-1.0", "1.0", "3.0", true},         // Q2: Circle area hit
            {"1.0", "1.0", "4.0", true},          // Q1: Triangle area hit (R=4.0 ensures it fits)
            {"1.0", "-1.0", "3.0", true},         // Q4: Rectangle area hit
            
            // Core Misses
            {"-1.0", "-1.0", "2.0", false},       // Q3: Empty sector miss
            {"3.0", "3.0", "2.0", false},         // Q1: Outside triangle miss
            {"2.0", "-2.0", "2.0", false},        // Q4: Outside rectangle miss
        });
    }

    // 3. Setup: Set the values before each test run
    @Before
    public void setup() {
        result.setX(x);
        result.setY(y);
        result.setR(r);
    }

    // 4. Test Method: Runs the logic with the provided parameters
    @Test
    public void parameterizedHitCheck() {
        String message = String.format("Check for (X: %s, Y: %s, R: %s)", x, y, r);
        if (expected) {
            assertTrue(message, result.checkHit());
        } else {
            assertFalse(message, result.checkHit());
        }
    }
}