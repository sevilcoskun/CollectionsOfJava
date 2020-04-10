package test.stacksTest;

import main.stacks.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @Test
    public void shouldEvaluateConstants(){
        int result = calculator.evaluate("1");
        assertEquals(1, result);
    }

    @Test
    public void shouldSupportAdding(){
        int result = calculator.evaluate("1 + 2");
        assertEquals(3, result);
    }

    @Test
    public void shouldSupportSubtraction(){
        int result = calculator.evaluate("1 - 2");
        assertEquals(-1, result);
    }

    @Test
    public void shouldSupportMultiplication(){
        int result = calculator.evaluate("1 * 2");
        assertEquals(2, result);
    }

    @Test
    public void shouldSupportDivision(){
        int result = calculator.evaluate("100 / 10");
        assertEquals(10,result);
    }

    @Test
    public void shouldSupportComplexStatements(){
        int result = calculator.evaluate("1 - 5 + 2 - 3");
        assertEquals(-5, result);
    }
}
