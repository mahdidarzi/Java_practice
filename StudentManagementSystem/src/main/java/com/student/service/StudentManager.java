package com.student.service;

import com.student.model.Student;
import com.student.repository.IStudentRepository;

import java.util.*;

public class StudentManager {

    private final List<Student> students;
    private final IStudentRepository repository;

    public StudentManager(IStudentRepository repository) {
        this.repository = repository;
        this.students = new ArrayList<>(repository.findAll());
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public Optional<Student> findByName(String name) {
        return students.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public boolean removeStudent(String name) {
        return students.removeIf(s -> s.getName().equalsIgnoreCase(name));
    }

    public double getAverageGrade() {
        return students.stream()
                .mapToDouble(Student::getGrade)
                .average()
                .orElse(0.0);
    }

    public void sortByGradeDescending() {
        students.sort(Comparator.comparingDouble(Student::getGrade).reversed());
    }

    public void saveChanges() {
        repository.saveAll(students);
    }
}
