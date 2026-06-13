import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // ✅ Dependency Injection
        String filePath = ConfigLoader.getStudentFilePath();
        IStudentRepository repository = new FileStudentRepository(filePath);
        StudentManager manager = new StudentManager(repository);

        while (true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Show All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Save Changes");
            System.out.println("6. Show Average Grade");
            System.out.println("7. Sort By Grade (Descending)");
            System.out.println("8. Exit");
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

                            manager.addStudent(new Student(name, age, grade));
                            System.out.println("Student added successfully.");

                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input type.");
                            input.nextLine();
                        } catch (InvalidStudentDataException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 2:
                        manager.getAllStudents()
                                .forEach(System.out::println);
                        break;

                    case 3:
                        System.out.print("Enter name to search: ");
                        String searchName = input.nextLine();

                        manager.findByName(searchName)
                                .ifPresentOrElse(
                                        System.out::println,
                                        () -> System.out.println("Student not found.")
                                );
                        break;

                    case 4:
                        System.out.print("Enter name to remove: ");
                        String removeName = input.nextLine();
                        manager.removeStudent(removeName);
                        System.out.println("Operation completed.");
                        break;

                    case 5:
                        manager.saveChanges();
                        System.out.println("Data saved successfully.");
                        break;

                    case 6:
                        System.out.println("Average grade: " + manager.getAverageGrade());
                        break;

                    case 7:
                        manager.sortByGradeDescending();
                        System.out.println("Students sorted.");
                        break;

                    case 8:
                        System.out.println("Goodbye!");
                        input.close();
                        return;

                    default:
                        System.out.println("Invalid option.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                input.nextLine();
            }
        }
    }
}
