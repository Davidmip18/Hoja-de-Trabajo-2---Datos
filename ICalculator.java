/**
 * Abstract Data Type for a Postfix Calculator.
 * This interface defines the operations that any postfix calculator must implement.
 */
public interface ICalculator {
    
    /**
     * Evaluates a postfix expression and returns the result.
     * 
     * @param expression the postfix expression as a string (operands and operators separated by spaces)
     * @return the result of evaluating the expression
     * @throws ArithmeticException if there is a division by zero
     * @throws IllegalArgumentException if the expression contains invalid characters or insufficient operands
     */
    int evaluate(String expression) throws ArithmeticException, IllegalArgumentException;
}
