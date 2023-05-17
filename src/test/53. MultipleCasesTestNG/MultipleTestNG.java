import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public classs MultipleTestNG {
    static int X;
    static int Y;

    @BeforeClass
    public void setUp() {
        X=5;
        Y=10;
    }

    @Test
    public void TestMethod1() {
        int Mul=X*Y;
        if(Mul==50)
            System.out.println("Test Case 1 Passed: ");
    }

    @Test
    public void TestMethod2() {
        int Sum=X+Y;
        if(Sum==15)
            System.out.println("Test Case 2 Passed");
    }

    @Test
    public void TestMethod3(){
        int division = Y/X;
        if(division==2)
            System.out.println("Test Case 3 Passed")
    }
}