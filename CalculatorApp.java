import java.util.Scanner;

// Calculator interface
interface Calculator {
    double add(double num1, double num2);

    double subtract(double num1, double num2);

    double multiply(double num1, double num2);

    double divide(double num1, double num2);
}

// Calculator implementation
class BasicCalculator implements Calculator {
    @Override
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    @Override
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    @Override
    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    @Override
    public double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Division by zero is not allowed!");
        }
        return num1 / num2;
    }
}

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new BasicCalculator();

        System.out.println("Basic Calculator");
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        System.out.println("Select operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Enter your choice (1-4): ");
        int choice = scanner.nextInt();

        double result = 0.0;

        switch (choice) {
            case 1:
                result = calculator.add(num1, num2);
                System.out.println("Result: " + result);
                break;
            case 2:
                result = calculator.subtract(num1, num2);
                System.out.println("Result: " + result);
                break;
            case 3:
                result = calculator.multiply(num1, num2);
                System.out.println("Result: " + result);
                break;
            case 4:
                try {
                    result = calculator.divide(num1, num2);
                    System.out.println("Result: " + result);
                } catch (ArithmeticException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            default:
                System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
