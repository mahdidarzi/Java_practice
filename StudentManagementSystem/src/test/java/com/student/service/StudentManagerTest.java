package com.student.service;

import com.student.model.Student;
import com.student.repository.IStudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StudentManagerTest {

    private StudentManager manager;
    private FakeStudentRepository fakeRepository;

    @BeforeEach
    void setUp() {
        fakeRepository = new FakeStudentRepository();
        manager = new StudentManager(fakeRepository);
    }

    @Test
    void shouldAddStudentSuccessfully() throws Exception {
        Student student = new Student("Ali", 20, 18.5);

        manager.addStudent(student);

        assertEquals(1, manager.getAllStudents().size());
        assertEquals("Ali", manager.getAllStudents().get(0).getName());
    }

    @Test
    void shouldFindStudentByName() throws Exception {
        Student student = new Student("Sara", 22, 19.0);
        manager.addStudent(student);

        Optional<Student> result = manager.findByName("Sara");

        assertTrue(result.isPresent());
        assertEquals("Sara", result.get().getName());
    }

    @Test
    void shouldReturnEmptyWhenStudentNotFound() {
        Optional<Student> result = manager.findByName("Unknown");

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldRemoveStudentSuccessfully() throws Exception {
        Student student = new Student("Reza", 21, 17.0);
        manager.addStudent(student);

        boolean removed = manager.removeStudent("Reza");

        assertTrue(removed);
        assertEquals(0, manager.getAllStudents().size());
    }

    @Test
    void shouldCalculateAverageGradeCorrectly() throws Exception {
        manager.addStudent(new Student("A", 20, 18.0));
        manager.addStudent(new Student("B", 21, 16.0));
        manager.addStudent(new Student("C", 22, 20.0));

        double average = manager.getAverageGrade();

        assertEquals(18.0, average);
    }

    @Test
    void shouldReturnZeroAverageWhenNoStudentsExist() {
        assertEquals(0.0, manager.getAverageGrade());
    }

    @Test
    void shouldSortStudentsByGradeDescending() throws Exception {
        manager.addStudent(new Student("A", 20, 15.0));
        manager.addStudent(new Student("B", 21, 19.0));
        manager.addStudent(new Student("C", 22, 17.0));

        manager.sortByGradeDescending();

        List<Student> students = manager.getAllStudents();

        assertEquals("B", students.get(0).getName());
        assertEquals("C", students.get(1).getName());
        assertEquals("A", students.get(2).getName());
    }

    @Test
    void shouldSaveChangesToRepository() throws Exception {
        manager.addStudent(new Student("Nima", 23, 18.0));

        manager.saveChanges();

        assertEquals(1, fakeRepository.savedStudents.size());
        assertEquals("Nima", fakeRepository.savedStudents.get(0).getName());
    }

    static class FakeStudentRepository implements IStudentRepository {

        private final List<Student> students = new ArrayList<>();
        private List<Student> savedStudents = new ArrayList<>();

        @Override
        public List<Student> findAll() {
            return new ArrayList<>(students);
        }

        @Override
        public void saveAll(List<Student> students) {
            savedStudents = new ArrayList<>(students);
        }
    }
}
