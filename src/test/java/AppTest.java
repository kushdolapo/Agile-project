import static org.junit.Assert.*;
 import org.junit.Test;
 public class AppTest {
    @Test
    public void test() {
        AppMain myTest = new AppMain();
        assertEquals("Test Passed!", myTest.test());
    }
}

