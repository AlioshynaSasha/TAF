import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorIntDivideTest {
    private final Calculator calculator = new Calculator();

    @Test(
            dataProvider = "successDataForDivide",
            description = "Success divide test",
            priority = 1,
            dependsOnMethods = "testFailure",
            alwaysRun = true,
            groups = {"divide"}
    )
    public void testDivideSuccess(int a, int b, int expected) {
        Assert.assertEquals(calculator.divide(a, b), expected);
    }

    @DataProvider(name = "successDataForDivide")
    public Object[][] successDataForDivideTest() {
        return new Object[][]{
                {-15, -4, 3},
                {5, -2, -2},
                {9, 3, 3},
                {0, 4, 0},
        };
    }

    @Test(
            expectedExceptions = RuntimeException.class,
            description = "Failure divide test",
            priority = 1,
            groups = {"divide"}
    )
    public void testDivideFailure() {
        calculator.divide(3, 0);
    }

    @Test(enabled = false)
    public void testDisableMethod() {

    }

    @Test(retryAnalyzer = Retry.class)
    public void testFailure() {
        Assert.assertTrue(false);
    }
}
