import java.util.InputMismatchException;
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
            System.out.println("7. Show Average Grade");
            System.out.println("8. Sort By Grade (Descending)");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    case 1:
                        try {
                            System.out.print("Enter name: ");
                            String name = input.nextLine();

                            System.out.print("Enter age: ");
                            int age = input.nextInt();

                            System.out.print("Enter grade: ");
                            double grade = input.nextDouble();
                            input.nextLine();

                            Student student = new Student(name, age, grade);
                            manager.addStudent(student);

                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input type. Age must be integer and grade must be number.");
                            input.nextLine();
                        } catch (InvalidStudentDataException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
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
                        manager.showAverageGrade();
                        break;

                    case 8:
                        manager.sortByGradeDescending();
                        break;

                    case 9:
                        System.out.println("Goodbye!");
                        input.close();
                        return;

                    default:
                        System.out.println("Invalid option.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number for menu choice.");
                input.nextLine();
            }
        }
    }
}
