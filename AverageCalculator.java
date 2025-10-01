package msts;
import java.util.ArrayList;
import java.util.Scanner;

public class AverageCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Enter Numbers");
            System.out.println("2. Display Numbers");
            System.out.println("3. Calculate Average");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid menu choice. Please enter a number 1-4.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Enter numbers (type 'done' to finish):");
                    while (true) {
                        String input = sc.nextLine();
                        if (input.equalsIgnoreCase("done")) {
                            break;
                        }
                        try {
                            int num = Integer.parseInt(input);
                            numbers.add(num);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Invalid input, please enter a valid integer.");
                        }
                    }
                    break;

                case 2:
                    if (numbers.isEmpty()) {
                        System.out.println("The list is empty.");
                    } else {
                        System.out.println("Numbers: " + numbers);
                    }
                    break;

                case 3:
                    try {
                        if (numbers.isEmpty()) {
                            throw new ArithmeticException("Cannot calculate average of empty list.");
                        }
                        int sum = 0;
                        for (int num : numbers) {
                            sum += num;
                        }
                        double average = (double) sum / numbers.size();
                        System.out.println("Average: " + average);
                    } catch (ArithmeticException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    return;

                default:
                    System.out.println("Invalid choice. Please select 1-4.");
            }

        } while (true);
    }
}
