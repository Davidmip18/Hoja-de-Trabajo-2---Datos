
public class PostfixCalculator implements ICalculator {
    
    private IStack<Integer> stack;
    
    public PostfixCalculator(IStack<Integer> stack) {
        this.stack = stack;
    }
    
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
    
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || 
               token.equals("/") || token.equals("%");
    }
    
    private boolean isOperand(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    

    private int performOperation(int a, int b, String operator) throws ArithmeticException {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
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
