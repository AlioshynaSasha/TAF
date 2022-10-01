import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSumTest {
    private final Calculator calculator = new Calculator();

    @Test(dataProvider = "dataForSum", priority = 2)
    public void testSum(double a, double b, double expected) {
        Assert.assertEquals(calculator.sum(a, b), expected);
    }

    @DataProvider(name = "dataForSum")
    public Object[][] dataForSumTest() {
        return new Object[][] {
                {-2, -3, -5},
                {0, 0, 0},
                {2, 3, 5},
                {3, -4, -1},
                {-4, 6, 2},
        };
    }
}
