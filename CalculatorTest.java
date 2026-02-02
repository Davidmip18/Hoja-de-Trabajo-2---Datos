import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    
    private ICalculator calculator;
    
    @Before
    public void setUp() {
        IStack<Integer> stack = new StackArrayList<>();
        calculator = new PostfixCalculator(stack);
    }
    
    @Test
    public void testSimpleAddition() {
        int result = calculator.evaluate("1 2 +");
        assertEquals(3, result);
    }
    
    @Test
    public void testSimpleSubtraction() {
        int result = calculator.evaluate("5 3 -");
        assertEquals(2, result);
    }
    
    @Test
    public void testSimpleMultiplication() {
        int result = calculator.evaluate("4 5 *");
        assertEquals(20, result);
    }
    
    @Test
    public void testSimpleDivision() {
        int result = calculator.evaluate("20 4 /");
        assertEquals(5, result);
    }
    
    @Test
    public void testSimpleModulo() {
        int result = calculator.evaluate("10 3 %");
        assertEquals(1, result);
    }
    
    @Test
    public void testComplexExpression1() {
        // ((1 + 2) * 4) + 3 = 15
        int result = calculator.evaluate("1 2 + 4 * 3 +");
        assertEquals(15, result);
    }
    
    @Test
    public void testComplexExpression2() {
        // 6 * (2 + 3) = 30
        int result = calculator.evaluate("6 2 3 + *");
        assertEquals(30, result);
    }
    
    @Test
    public void testMultipleOperations() {
        // (15 / 3) + (2 * 4) = 5 + 8 = 13
        int result = calculator.evaluate("15 3 / 2 4 * +");
        assertEquals(13, result);
    }
    
    @Test
    public void testSingleNumber() {
        int result = calculator.evaluate("42");
        assertEquals(42, result);
    }
    
    @Test
    public void testMultiDigitNumbers() {
        int result = calculator.evaluate("100 200 +");
        assertEquals(300, result);
    }
    
    @Test
    public void testOrderOfOperands() {
        int result = calculator.evaluate("10 3 -");
        assertEquals(7, result); // 10 - 3 = 7, not 3 - 10 = -7
    }
    
    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        calculator.evaluate("5 0 /");
    }
    
    @Test(expected = ArithmeticException.class)
    public void testModuloByZero() {
        calculator.evaluate("5 0 %");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInsufficientOperands() {
        calculator.evaluate("1 +");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testTooManyOperands() {
        calculator.evaluate("1 2 3 +");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCharacter() {
        calculator.evaluate("1 2 # +");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidOperand() {
        calculator.evaluate("1 abc +");
    }
    
    @Test
    public void testExpressionWithExtraSpaces() {
        int result = calculator.evaluate("  1   2   +  ");
        assertEquals(3, result);
    }
    
    @Test
    public void testNegativeResults() {
        int result = calculator.evaluate("3 5 -");
        assertEquals(-2, result);
    }
    
    @Test
    public void testComplexExpression3() {
        // ((5 + 3) * 2) - 4 = 12
        int result = calculator.evaluate("5 3 + 2 * 4 -");
        assertEquals(12, result);
    }
}
