import java.util.*;

class EmptyStudentListException extends Exception {
    public EmptyStudentListException(String message) {
        super(message);
    }
}

public class StudentListApp {
    private ArrayList<String> students = new ArrayList<>();

    public void addStudent(String name) {
        students.add(name);
        System.out.println(name + " added successfully!");
    }

    public void removeStudent(String name) {
        if (students.remove(name)) {
            System.out.println(name + " removed successfully!");
        } else {
            System.out.println("Error: " + name + " not found in the list!");
        }
    }

    public void displayStudents() throws EmptyStudentListException {
        if (students.isEmpty()) {
            throw new EmptyStudentListException("Student list is empty!");
        }
        Collections.sort(students);
        System.out.println("Sorted names: " + students);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentListApp app = new StudentListApp();
        int choice;

        do {
            System.out.println("\n--- Student List Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name to add: ");
                    String nameToAdd = sc.nextLine();
                    app.addStudent(nameToAdd);
                    break;

                case 2:
                    System.out.print("Enter student name to remove: ");
                    String nameToRemove = sc.nextLine();
                    app.removeStudent(nameToRemove);
                    break;

                case 3:
                    try {
                        app.displayStudents();
                    } catch (EmptyStudentListException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}

