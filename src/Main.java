import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Show All Students");
            System.out.println("3. Save To File");
            System.out.println("4. Load From File");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = input.nextLine();

                    System.out.print("Enter age: ");
                    int age = input.nextInt();

                    System.out.print("Enter grade: ");
                    double grade = input.nextDouble();
                    input.nextLine(); // consume newline

                    Student student = new Student(name, age, grade);
                    manager.addStudent(student);
                    break;

                case 2:
                    manager.showAllStudents();
                    break;

                case 3:
                    manager.saveToFile();
                    break;

                case 4:
                    manager.loadFromFile();
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
