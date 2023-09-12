package com.nksolucoes.msalunos.datasources;

import com.nksolucoes.msalunos.datasources.repositories.StudentsClientRepository;
import com.nksolucoes.msalunos.entities.Student;
import com.nksolucoes.msalunos.repository.StudentsRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentsDataSource implements StudentsRepository {

    private StudentsClientRepository studentsClientRepository;

    public StudentsDataSource(StudentsClientRepository studentsClientRepository) {
        this.studentsClientRepository = studentsClientRepository;
    }

    @Override
    public List<Student> getAll() {
        return this.studentsClientRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> studentOptional =  this.studentsClientRepository.findById(id);
        if (studentOptional.isEmpty()){
            new RuntimeException("Student Not Found!");
        }
        return studentOptional.get();
    }

    @Override
    public Student createStudent(Student student) {
        return this.studentsClientRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return this.studentsClientRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        this.studentsClientRepository.deleteById(id);
    }
}
