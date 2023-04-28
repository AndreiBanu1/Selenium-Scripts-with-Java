import java.util.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import com.htmlextra.annotations.*;
import com.htmlextra.listeners.*;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
@Listeners(HTMLReporter.class)
public class AddTest {
    public int addition(int x, int y, int z) {
        return x + y + z;
    }

    @Test
    public void testAddition() {
        assertEquals(addition(10, 11, 12), 33);
        assertNotEquals(addition(11, 12, 0), 44);
    }

    @Test
    public void testNegativeValue() {
        assertNotEquals(addition(-9, 25, 0), 6);
    }
}
