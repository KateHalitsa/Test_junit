import org.junit.Assert;
import org.junit.Test;

public class TestCalculator {
    @Test
    public void testAdd() throws Exception{
Calculator calculator=new Calculator();
int add=calculator.add(4,3);
        Assert.assertEquals(7,add);
    }
}
