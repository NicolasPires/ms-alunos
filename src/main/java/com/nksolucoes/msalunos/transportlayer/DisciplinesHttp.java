package com.nksolucoes.msalunos.transportlayer;

import com.nksolucoes.msalunos.entities.Student;
import com.nksolucoes.msalunos.interactors.StudentsUseCase;
import com.nksolucoes.msalunos.transportlayer.documentacao.model.DisciplinesDetail;
import com.nksolucoes.msalunos.transportlayer.documentacao.model.StudentsDetail;
import com.nksolucoes.msalunos.transportlayer.documentacao.model.StudentsInput;
import com.nksolucoes.msalunos.transportlayer.documentacao.model.StudentsSummary;
import com.nksolucoes.msalunos.transportlayer.documentacao.openapi.DisciplinesApi;
import com.nksolucoes.msalunos.transportlayer.documentacao.openapi.StudentsApi;
import com.nksolucoes.msalunos.transportlayer.mappers.DisciplinesMapper;
import com.nksolucoes.msalunos.transportlayer.mappers.StudentsMapper;
import com.nksolucoes.msalunos.transportlayer.responses.DisciplinesResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class DisciplinesHttp implements DisciplinesApi {

    private final StudentsUseCase studentsUseCase;

    public DisciplinesHttp(StudentsUseCase studentsUseCase) {
        this.studentsUseCase = studentsUseCase;
    }

    @Override
    public ResponseEntity<List<DisciplinesDetail>> getDisciplines(String title) {
        List<DisciplinesResponse> disciplinesResponses = studentsUseCase.getAllDisciplines();
        return ResponseEntity.ok(DisciplinesMapper.INSTANCE.mapListDisciplinesDetail(disciplinesResponses));
    }

}
