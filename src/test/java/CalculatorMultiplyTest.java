import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorMultiplyTest {
    private final Calculator calculator = new Calculator();

    @Test(dataProvider = "dataForMultiply", priority = 2)
    public void testMultiply(double a, double b, double expected) {
        Assert.assertEquals(calculator.multiply(a, b), expected);
    }

    @DataProvider(name = "dataForMultiply")
    public Object[][] dataForMultiplyTest() {
        return new Object[][]{
                {-2, -3, 6},
                {0, 0, 0},
                {2, 3, 6},
                {3, -4, -12},
                {4, 0, 0},
                {0, 4, 0},
        };
    }
}
