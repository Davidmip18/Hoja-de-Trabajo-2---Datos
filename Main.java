import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Main program to evaluate postfix expressions from a file.
 */
public class Main {
    
    public static void main(String[] args) {
        // Create stack implementation
        IStack<Integer> stack = new StackArrayList<>();
        
        // Create calculator with the stack
        ICalculator calculator = new PostfixCalculator(stack);
        
        // Read and process the file
        String fileName = "datos.txt";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 1;
            
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    try {
                        int result = calculator.evaluate(line);
                        System.out.println("Expresión " + lineNumber + ": " + line);
                        System.out.println("Resultado: " + result);
                        System.out.println();
                    } catch (ArithmeticException e) {
                        System.err.println("Error aritmético en línea " + lineNumber + ": " + e.getMessage());
                        System.err.println("Expresión: " + line);
                        System.err.println();
                    } catch (IllegalArgumentException e) {
                        System.err.println("Error en línea " + lineNumber + ": " + e.getMessage());
                        System.err.println("Expresión: " + line);
                        System.err.println();
                    }
                    lineNumber++;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
