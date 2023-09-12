package com.nksolucoes.msalunos.repository;

import com.nksolucoes.msalunos.entities.Student;

import java.util.List;

public interface StudentsRepository {
    List<Student> getAll();
    Student getStudentById(Long id);
    Student createStudent(Student student);
    Student updateStudent(Student student);
    void deleteStudent(Long id);
}
