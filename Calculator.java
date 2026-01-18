import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nCalculator Menu:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            
            // Handle invalid input for choice
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.next(); // Consume invalid input
                System.out.print("Enter your choice (1-5): ");
            }
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter first number: ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); // Consume invalid input
                    System.out.print("Enter first number: ");
                }
                double num1 = scanner.nextDouble();

                System.out.print("Enter second number: ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); // Consume invalid input
                    System.out.print("Enter second number: ");
                }
                double num2 = scanner.nextDouble();

                switch (choice) {
                    case 1:
                        System.out.println("Result: " + add(num1, num2));
                        break;
                    case 2:
                        System.out.println("Result: " + subtract(num1, num2));
                        break;
                    case 3:
                        System.out.println("Result: " + multiply(num1, num2));
                        break;
                    case 4:
                        try {
                            System.out.println("Result: " + divide(num1, num2));
                        } catch (ArithmeticException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                }
            } else if (choice != 5) {
                System.out.println("Invalid choice. Please select a number between 1 and 5.");
            }
        } while (choice != 5);

        System.out.println("Exiting calculator. Goodbye!");
        scanner.close();
    }

    // Method for addition
    public static double add(double a, double b) {
        return a + b;
    }

    // Method for subtraction
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Method for multiplication
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Method for division with exception handling for division by zero
    public static double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }
}
