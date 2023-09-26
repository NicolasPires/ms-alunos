package com.nksolucoes.msalunos.transportlayer;

import com.nksolucoes.msalunos.entities.Student;
import com.nksolucoes.msalunos.interactors.DisciplinesUseCase;
import com.nksolucoes.msalunos.interactors.StudentsUseCase;
import com.nksolucoes.msalunos.mock.DisciplinesMock;
import com.nksolucoes.msalunos.mock.StudentsMock;
import com.nksolucoes.msalunos.repository.StudentsRepository;
import com.nksolucoes.msalunos.transportlayer.documentacao.model.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

public class StudentsHttpTest {

    @InjectMocks
    private StudentsHttp studentsHttp;

    @Mock
    private StudentsUseCase studentsUseCase;

    @Mock
    private StudentsRepository studentsRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetStudents() throws ParseException {
        List<Student> mockStudents = StudentsMock.mockedListStudents();
        when(studentsUseCase.getAll()).thenReturn(mockStudents);
        ResponseEntity<List<StudentsSummary>> responseEntity = studentsHttp.getStudents("exampleTitle");

        verify(studentsUseCase, times(1)).getAll();
    }

    @Test
    public void testGetStudentsById() throws ParseException {
        Long studentId = 1L;
        Student mockStudent = StudentsMock.mockedStudent();

        when(studentsUseCase.getStudentById(studentId)).thenReturn(mockStudent);
        ResponseEntity<StudentsDetail> responseEntity = studentsHttp.getStudentsById(studentId);

        verify(studentsUseCase, times(1)).getStudentById(studentId);
    }

    @Test
    public void testCreateStudent() throws ParseException {
        StudentsInput studentsInput = StudentsMock.mockedStudentsInput();
        Student student = StudentsMock.mockedStudent();

        when(studentsUseCase.createStudent(student)).thenReturn(student);
        ResponseEntity<StudentsDetail> responseEntity = studentsHttp.createStudents(studentsInput);

        verify(studentsUseCase, times(1)).createStudent(student);
        assertSame(HttpStatus.CREATED, responseEntity.getStatusCode());
    }
}
