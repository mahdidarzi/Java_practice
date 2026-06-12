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
            System.out.println("3. Search Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Save To File");
            System.out.println("6. Load From File");
            System.out.println("7. Exit");

            System.out.print("Choose an option: ");

            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {

                case 1:

                    System.out.print("Enter name: ");
                    String name = input.nextLine();

                    System.out.print("Enter age: ");
                    int age = input.nextInt();

                    System.out.print("Enter grade: ");
                    double grade = input.nextDouble();
                    input.nextLine();

                    Student student = new Student(name, age, grade);
                    manager.addStudent(student);
                    break;

                case 2:
                    manager.showAllStudents();
                    break;

                case 3:

                    System.out.print("Enter name to search: ");
                    String searchName = input.nextLine();

                    manager.searchStudent(searchName);
                    break;

                case 4:

                    System.out.print("Enter name to remove: ");
                    String removeName = input.nextLine();

                    manager.removeStudent(removeName);
                    break;

                case 5:
                    manager.saveToFile();
                    break;

                case 6:
                    manager.loadFromFile();
                    break;

                case 7:
                    System.out.println("Goodbye!");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }



        }
    }
}
