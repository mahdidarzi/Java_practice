import java.io.*;
import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {

        if (student.getAge() < 5 || student.getAge() > 100) {
            System.out.println("Invalid age.");
            return;
        }

        if (student.getGrade() < 0 || student.getGrade() > 20) {
            System.out.println("Invalid grade.");
            return;
        }

        students.add(student);
        System.out.println("Student added successfully.");
    }


    public void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            student.showInfo();
        }
    }

    public void saveToFile() {
        try (FileWriter writer = new FileWriter("students.txt")) {
            for (Student student : students) {
                writer.write(student.getName() + "," + student.getAge() + "," + student.getGrade() + "\n");
            }
            System.out.println("Students saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving students to file.");
        }
    }

    public void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            students.clear();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 3) {
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    double grade = Double.parseDouble(parts[2]);

                    Student student = new Student(name, age, grade);
                    System.out.println("student is:" + name + " " + age + " " + grade);
                    students.add(student);
                }
            }

            System.out.println("Students loaded from file.");
        } catch (IOException e) {
            System.out.println("Error loading students from file.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid data format in file.");
        }
    }

    public void searchStudent(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)){
                student.showInfo();
                return;
            }
            System.out.println("Student not found.");
        }
    }
    public void removeStudent(String name){
        for (int i = 0; i <students.size() ; i++) {
            if (students.get(i).getName().equalsIgnoreCase(name)){
                students.remove(i);
                System.out.println("Student removed.");
                return;
            }

        }
    }
}

