class IllegalOperationException extends RuntimeException {
    public IllegalOperationException(String message) {
        super(message);
    }
}

public class Calculator {
    public static double calculate(double a, double b, String operator) {
        return switch(operator) {
            case "+" -> a + b;
            case "*" -> a * b;
            case "/" -> {
                if(b == 0) {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
                yield a / b;
            }
            case "" -> throw new IllegalArgumentException("Operation cannot be empty.");
            case null -> throw new IllegalArgumentException("Operation cannot be null.");
            default -> throw new IllegalOperationException("Invalid operator: " + operator);
        };
    }

    public static void main(String[] args) {
        // Test cases: {a, b, operator}
        Object[][] testCases = {
            {10.0, 5.0, "+"},
            {10.0, 5.0, "*"},
            {10.0, 2.0, "/"},
            {10.0, 0.0, "/"},   // Triggers ArithmeticException
            {10.0, 5.0, ""},    // Triggers IllegalArgumentException
            {10.0, 5.0, null},  // Triggers IllegalArgumentException
            {10.0, 5.0, "%"}    // Triggers IllegalOperationException
        };

        for (Object[] test : testCases) {
            double a = (double) test[0];
            double b = (double) test[1];
            String op = (String) test[2];

            try {
                double result = calculate(a, b, op);
                System.out.println(a + " " + op + " " + b + " = " + result);
            } catch (IllegalOperationException e) {
                System.out.println("Checked Error [" + op + "]: " + e.getMessage());
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println("Runtime Error [" + op + "]: " + e.getMessage());
            }
        }
    }
}
