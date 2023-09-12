package com.nksolucoes.msalunos.interactors;

import com.nksolucoes.msalunos.entities.Student;
import com.nksolucoes.msalunos.repository.StudentsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentsUseCase {

    private final StudentsRepository studentsRepository;

    public StudentsUseCase(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public List<Student> getAll() {return this.studentsRepository.getAll();}

    public Student getStudentById(Long id) {
        Student studentData = this.studentsRepository.getStudentById(id);
        if (Objects.isNull(studentData)) {
            new RuntimeException("No content Student!");
        }
        return studentData;
    }

    public Student createStudent(Student student) {
        return this.studentsRepository.createStudent(student);
    }

    public Student updateStudent(Student student, Long id) {
        Student studentData = this.studentsRepository.getStudentById(id);

        if (!Objects.isNull(studentData)){
          return this.studentsRepository.updateStudent(Student.builder()
                  .id(studentData.getId())
                  .name(student.getName())
                  .school(student.getSchool())
                  .date(student.getDate())
                  .build());
        } else {
            throw new RuntimeException("Unable to find student for update");
        }
    }

    public ResponseEntity<Void> deleteStudent(Long id) {
        Student studentData = this.studentsRepository.getStudentById(id);
        if (!Objects.isNull(studentData)){
            this.studentsRepository.deleteStudent(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            throw new RuntimeException("Unable to find student for delete");
        }

    }
}
