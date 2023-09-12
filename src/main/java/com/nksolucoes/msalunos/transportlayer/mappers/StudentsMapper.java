package com.nksolucoes.msalunos.transportlayer.mappers;

import com.nksolucoes.msalunos.entities.Student;
import com.nksolucoes.msalunos.transportlayer.documentacao.model.StudentsDetail;
import com.nksolucoes.msalunos.transportlayer.documentacao.model.StudentsInput;
import com.nksolucoes.msalunos.transportlayer.documentacao.model.StudentsSummary;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface StudentsMapper {
    StudentsMapper INSTANCE = Mappers.getMapper(StudentsMapper.class);

    Student map(StudentsInput studentsInput);

    StudentsDetail mapDetail(Student student);

    StudentsSummary mapSummary(Student student);

    default List<StudentsDetail> mapListDetail(List<Student> studentList) {
        final List<StudentsDetail> studentsDetailList = new ArrayList<>();
        for (Student student: studentList) {
            StudentsDetail studentsDetail = StudentsMapper.INSTANCE.mapDetail(student);
            studentsDetailList.add(studentsDetail);
        }
        return studentsDetailList;
    }

    default List<StudentsSummary> mapListSummary(List<Student> studentList) {
        final List<StudentsSummary> studentsSummaryList = new ArrayList<>();
        for (Student student: studentList) {
            StudentsSummary studentsSummary = StudentsMapper.INSTANCE.mapSummary(student);
            studentsSummaryList.add(studentsSummary);
        }
        return studentsSummaryList;
    }

}
