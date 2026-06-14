package com.student;

import com.student.model.Student;
import com.student.repository.FileStudentRepository;
import com.student.repository.IStudentRepository;
import com.student.service.StudentManager;
import com.student.exception.InvalidStudentDataException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Dependency Injection
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

                    case 1 -> addStudent(input, manager);
                    case 2 -> manager.getAllStudents().forEach(System.out::println);
                    case 3 -> searchStudent(input, manager);
                    case 4 -> removeStudent(input, manager);
                    case 5 -> {
                        manager.saveChanges();
                        System.out.println("Data saved successfully.");
                    }
                    case 6 -> System.out.println("Average grade: " + manager.getAverageGrade());
                    case 7 -> {
                        manager.sortByGradeDescending();
                        System.out.println("Students sorted.");
                    }
                    case 8 -> {
                        System.out.println("Goodbye!");
                        input.close();
                        return;
                    }
                    default -> System.out.println("Invalid option.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                input.nextLine();
            }
        }
    }

    private static void addStudent(Scanner input, StudentManager manager) {
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
    }

    private static void searchStudent(Scanner input, StudentManager manager) {
        System.out.print("Enter name to search: ");
        String name = input.nextLine();

        manager.findByName(name)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Student not found.")
                );
    }

    private static void removeStudent(Scanner input, StudentManager manager) {
        System.out.print("Enter name to remove: ");
        String name = input.nextLine();

        boolean removed = manager.removeStudent(name);
        System.out.println(removed ? "Student removed." : "Student not found.");
    }
}
