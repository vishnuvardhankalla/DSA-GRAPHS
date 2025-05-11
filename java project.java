import java.io.FileWriter;
import java.io.IOException;

public class Calculator {

    public double add(double a, double b) throws IOException {
        double result = a + b;
        saveToHistory(a + " + " + b + " = " + result);
        return result;
    }

    public double subtract(double a, double b) throws IOException {
        double result = a - b;
        saveToHistory(a + " - " + b + " = " + result);
        return result;
    }

    public double multiply(double a, double b) throws IOException {
        double result = a * b;
        saveToHistory(a + " * " + b + " = " + result);
        return result;
    }

    public double divide(double a, double b) throws IOException {
        if (b == 0) throw new ArithmeticException("Division by zero not allowed.");
        double result = a / b;
        saveToHistory(a + " / " + b + " = " + result);
        return result;
    }

    private void saveToHistory(String data) throws IOException {
        FileWriter writer = new FileWriter("history.txt", true); // append mode
        writer.write(data + "\n");
        writer.close();
    }
}

import java.util.Scanner;
import java.io.*;

public class CalculatorApp {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        while (true) {
            System.out.println("\n===== Java Calculator =====");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. View History");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            double a, b, result;

            switch (choice) {
                case 1:
                    System.out.print("Enter two numbers: ");
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    result = calc.add(a, b);
                    System.out.println("Result: " + result);
                    break;

                case 2:
                    System.out.print("Enter two numbers: ");
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    result = calc.subtract(a, b);
                    System.out.println("Result: " + result);
                    break;

                case 3:
                    System.out.print("Enter two numbers: ");
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    result = calc.multiply(a, b);
                    System.out.println("Result: " + result);
                    break;

                case 4:
                    System.out.print("Enter two numbers: ");
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    try {
                        result = calc.divide(a, b);
                        System.out.println("Result: " + result);
                    } catch (ArithmeticException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("=== History ===");
                    BufferedReader reader = new BufferedReader(new FileReader("history.txt"));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                    reader.close();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
