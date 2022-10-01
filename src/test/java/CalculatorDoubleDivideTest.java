import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorDoubleDivideTest {
    private final Calculator calculator = new Calculator();

    @Test(
            dataProvider = "successDataForDivide",
            priority = 1,
            groups = {"divide"},
            invocationCount = 3,
            invocationTimeOut = 300,
            threadPoolSize = 3
    )
    public void testDivideSuccess(double a, double b, double expected) {
        Assert.assertEquals(calculator.divide(a, b), expected);
    }

    @DataProvider(name = "successDataForDivide")
    public Object[][] successDataForDivideTest() {
        return new Object[][]{
                {-8, -4, 2},
                {5, -2, -2.5},
                {9, 3, 3},
                {0, 4, 0},
        };
    }

    @Test(
            expectedExceptions = RuntimeException.class,
            priority = 1,
            groups = {"divide"},
            timeOut = 50
    )
    public void testDivideFailure() {
        calculator.divide(3, 0);
    }
}
