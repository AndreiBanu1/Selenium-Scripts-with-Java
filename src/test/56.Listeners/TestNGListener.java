import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListenerTestCase.TestNGListenerExample.class)
public class TestNGListenerTestCase {
    @Test
    public void testMethod1() {
        System.out.println("Executing Test Method 1");
        Assert.assertEquals(2 + 2, 4);
    }

    @Test
    public void testMethod2() {
        System.out.println("Executing Test Method 2");
        Assert.assertTrue(true);
    }

    @Test
    public void testMethod3() {
        System.out.println("Executing Test Method 3");
        Assert.fail("Test Failed");
    }

    public static class TestNGListenerExample implements ITestListener {
        @Override
        public void onTestStart(ITestResult result) {
            System.out.println("Test Started: " + result.getName());
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            System.out.println("Test Passed: " + result.getName());
        }

        @Override
        public void onTestFailure(ITestResult result) {
            System.out.println("Test Failed: " + result.getName());
        }

        @Override
        public void onTestSkipped(ITestResult result) {
            System.out.println("Test Skipped: " + result.getName());
        }

        @Override
        public void onStart(ITestContext context) {
            System.out.println("Test Suite Started: " + context.getName());
        }

        @Override
        public void onFinish(ITestContext context) {
            System.out.println("Test Suite Finished: " + context.getName());
        }

        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
            // Ignored
        }
    }
}
