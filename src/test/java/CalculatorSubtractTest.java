import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSubtractTest {
    private final Calculator calculator = new Calculator();

    @Test(dataProvider = "dataForSubtract", priority = 2)
    public void testSubtract(double a, double b, double expected) {
        Assert.assertEquals(calculator.subtract(a, b), expected);
    }

    @DataProvider(name = "dataForSubtract")
    public Object[][] dataForSubtractTest() {
        return new Object[][]{
                {-2, -3, 1},
                {0, 0, 0},
                {2, 3, -1},
                {3, -4, 7},
                {-4, 6, -10},
        };
    }
}
