package com.student.repository;

import com.student.model.Student;
import com.student.exception.InvalidStudentDataException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileStudentRepository implements IStudentRepository {

    private final String filePath;

    public FileStudentRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();

        File file = new File(filePath);
        if (!file.exists()) {
            return students;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 3) {
                    students.add(new Student(
                            parts[0],
                            Integer.parseInt(parts[1]),
                            Double.parseDouble(parts[2])
                    ));
                }
            }

        } catch (IOException | InvalidStudentDataException e) {
            throw new RuntimeException("Error reading file", e);
        }

        return students;
    }

    @Override
    public void saveAll(List<Student> students) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            for (Student student : students) {
                writer.write(student.getName() + "," +
                        student.getAge() + "," +
                        student.getGrade());
                writer.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("Error writing file", e);
        }
    }
}
