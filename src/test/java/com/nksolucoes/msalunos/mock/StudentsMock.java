package com.nksolucoes.msalunos.mock;

import com.nksolucoes.msalunos.entities.Student;
import com.nksolucoes.msalunos.transportlayer.documentacao.model.*;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Slf4j
public class StudentsMock {

    public static StudentsDetail mockedStudentsDetail() {
        DisciplinesDetail disciplinesDetail = new DisciplinesDetail();
        disciplinesDetail.setDisciplineId(1L);
        disciplinesDetail.setName("Matematica");
        disciplinesDetail.setGrade(10L);

        StudentsDetail studentsDetail = new StudentsDetail();
        studentsDetail.setStudentId(1L);
        studentsDetail.setName("Fulano de Tal");
        studentsDetail.date(LocalDate.of(2023, 9, 1));
        studentsDetail.setDisciplines(List.of(disciplinesDetail));

        return studentsDetail;
    }

    public static Student mockedStudent() throws ParseException {
        String dateString = "25/09/2023";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse(dateString);

        return Student.builder()
                .studentId(1L)
                .name("Fulano de Tal")
                .school("Escola Estadual Teste")
                .date(date)
                .build();
    }

    public static List<StudentsDetail> mockedListStudentsDetail() {
        DisciplinesDetail disciplinesDetail = new DisciplinesDetail();
        disciplinesDetail.setDisciplineId(1L);
        disciplinesDetail.setName("Matematica");
        disciplinesDetail.setGrade(10L);

        StudentsDetail studentsDetail = new StudentsDetail();
        studentsDetail.setStudentId(1L);
        studentsDetail.setName("Fulano de Tal");
        studentsDetail.date(LocalDate.of(2023, 9, 1));
        studentsDetail.setDisciplines(List.of(disciplinesDetail));

        return List.of(studentsDetail);
    }

    public static List<Student> mockedListStudents() throws ParseException {
        DisciplinesDetail disciplinesDetail = new DisciplinesDetail();
        disciplinesDetail.setDisciplineId(1L);
        disciplinesDetail.setName("Matematica");
        disciplinesDetail.setGrade(10L);

        String dateString = "25/09/2023";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse(dateString);

        return List.of(Student.builder()
                .studentId(1L)
                .name("Fulano de Tal")
                .school("Escola Estadual Teste")
                .date(date)
                .build());
    }

    public static StudentsInput mockedStudentsInput() {
        StudentsInput studentsInput = new StudentsInput();
        studentsInput.setName("Fulano de Tal");
        studentsInput.setSchool("Escola Estadual Teste");
        studentsInput.date(LocalDate.of(2023, 9, 1));

        return studentsInput;
    }
}
