/**
 * Implementation of a Postfix Calculator using a stack.
 */
public class PostfixCalculator implements ICalculator {
    
    private IStack<Integer> stack;
    
    /**
     * Constructs a PostfixCalculator with the given stack implementation.
     * 
     * @param stack the stack implementation to use
     */
    public PostfixCalculator(IStack<Integer> stack) {
        this.stack = stack;
    }
    
    /**
     * Evaluates a postfix expression and returns the result.
     * 
     * @param expression the postfix expression as a string (operands and operators separated by spaces)
     * @return the result of evaluating the expression
     * @throws ArithmeticException if there is a division by zero
     * @throws IllegalArgumentException if the expression contains invalid characters or insufficient operands
     */
    @Override
    public int evaluate(String expression) throws ArithmeticException, IllegalArgumentException {
        stack.clear();
        
        String[] tokens = expression.trim().split("\\s+");
        
        for (String token : tokens) {
            if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Insufficient operands for operation: " + token);
                }
                
                int operandB = stack.pop();
                int operandA = stack.pop();
                int result = performOperation(operandA, operandB, token);
                stack.push(result);
            } else if (isOperand(token)) {
                try {
                    int value = Integer.parseInt(token);
                    stack.push(value);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid operand: " + token);
                }
            } else {
                throw new IllegalArgumentException("Invalid character: " + token);
            }
        }
        
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression: too many operands");
        }
        
        return stack.pop();
    }
    
    /**
     * Checks if a token is an operator.
     * 
     * @param token the token to check
     * @return true if the token is an operator, false otherwise
     */
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || 
               token.equals("/") || token.equals("%");
    }
    
    /**
     * Checks if a token is an operand (integer).
     * 
     * @param token the token to check
     * @return true if the token is an operand, false otherwise
     */
    private boolean isOperand(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * Performs the specified operation on two operands.
     * 
     * @param a the first operand
     * @param b the second operand
     * @param operator the operator
     * @return the result of the operation
     * @throws ArithmeticException if there is a division by zero
     */
    private int performOperation(int a, int b, String operator) throws ArithmeticException {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return a / b;
            case "%":
                if (b == 0) {
                    throw new ArithmeticException("Modulo by zero");
                }
                return a % b;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}
