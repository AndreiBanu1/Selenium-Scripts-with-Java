import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateDependencyBetweenTestCases {

    static int X;
    static int Y;

    @BeforeCLass
    public void setUp() {
        X=5;
        Y=10;
    }

    @Test
    public void TestMethod1() {
        assertEquals(15,14);
    }

    @Test(dependsOnMethods={"TestMethod1"})
    public void TestMethod2(){
        int Sum=X+Y;
        if(Sum==15)
            System.out.println("Test Case 2 Passed");
    }

    @Test(dependsOnMethods={"TestMethod2"})
    public void TestMethod3() {
        int division = Y/X
        if (division==2)
            System.out.println("Test Case 3 Passed");
    }
}