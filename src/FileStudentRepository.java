import java.io.*;
import java.util.*;

public class FileStudentRepository implements IStudentRepository {
    private final String filePath;

    // مسیر فایل به کلاس تزریق می‌شود
    public FileStudentRepository(String filePath) {
        this.filePath = filePath;
    }



    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) return students;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    students.add(new Student(parts[0], Integer.parseInt(parts[1]), Double.parseDouble(parts[2])));
                }
            }
        } catch (Exception e) {
            System.err.println("Error reading data: " + e.getMessage());
        }
        return students;
    }

    @Override
    public void saveAll(List<Student> students) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            for (Student s : students) {
                pw.println(s.getName() + "," + s.getAge() + "," + s.getGrade());
            }
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }
}
