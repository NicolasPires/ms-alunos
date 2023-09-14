package com.nksolucoes.msalunos.transportlayer;

import com.nksolucoes.msalunos.entities.Student;
import com.nksolucoes.msalunos.interactors.StudentsUseCase;
import com.nksolucoes.msalunos.transportlayer.documentacao.model.StudentsDetail;
import com.nksolucoes.msalunos.transportlayer.documentacao.model.StudentsInput;
import com.nksolucoes.msalunos.transportlayer.documentacao.model.StudentsSummary;
import com.nksolucoes.msalunos.transportlayer.documentacao.openapi.StudentsApi;
import com.nksolucoes.msalunos.transportlayer.mappers.StudentsMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class StudentsController implements StudentsApi {

    private final StudentsUseCase studentsUseCase;


    public StudentsController(StudentsUseCase studentsUseCase) {
        this.studentsUseCase = studentsUseCase;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return StudentsApi.super.getRequest();
    }

    @Override
    public ResponseEntity<StudentsDetail> createStudents(StudentsInput studentsInput) {
        Student student = null;
        student = studentsUseCase.createStudent(StudentsMapper.INSTANCE.map(studentsInput));

        return ResponseEntity.status(HttpStatus.CREATED).body(StudentsMapper.INSTANCE.mapDetail(student));
    }

    @Override
    public ResponseEntity<List<StudentsSummary>> getStudents(String title) {
        List<Student> studentList = null;
        studentList = studentsUseCase.getAll();
        return ResponseEntity.ok(StudentsMapper.INSTANCE.mapListSummary(studentList));
    }

    @Override
    public ResponseEntity<StudentsDetail> getStudentsById(Long studentId) {
        Student student = null;
        student = studentsUseCase.getStudentById(studentId);
        return ResponseEntity.ok(StudentsMapper.INSTANCE.mapDetail(student));
    }

    @Override
    public ResponseEntity<Void> removeStudent(Long studentId) {
        return this.studentsUseCase.deleteStudent(studentId);
    }

    @Override
    public ResponseEntity<StudentsDetail> updateStudent(Long studentId, StudentsInput studentsInput) {
        Student student = null;
        student = studentsUseCase.updateStudent(StudentsMapper.INSTANCE.map(studentsInput), studentId);
        return ResponseEntity.status(HttpStatus.OK).body(StudentsMapper.INSTANCE.mapDetail(student));
    }
}
