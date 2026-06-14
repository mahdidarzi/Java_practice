package com.student.repository;

import com.student.model.Student;
import java.util.List;

public interface IStudentRepository {

    List<Student> findAll();

    void saveAll(List<Student> students);
}
