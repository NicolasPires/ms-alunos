package com.nksolucoes.msalunos.transportlayer;

import com.nksolucoes.msalunos.interactors.DisciplinesUseCase;
import com.nksolucoes.msalunos.transportlayer.documentacao.model.DisciplinesDetail;
import com.nksolucoes.msalunos.transportlayer.documentacao.model.DisciplinesInput;
import com.nksolucoes.msalunos.transportlayer.documentacao.model.DisciplinesOutput;
import com.nksolucoes.msalunos.transportlayer.documentacao.openapi.DisciplinesApi;
import com.nksolucoes.msalunos.transportlayer.mappers.DisciplinesMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class DisciplinesHttp implements DisciplinesApi {

    private final DisciplinesUseCase disciplinesUseCase;

    public DisciplinesHttp(DisciplinesUseCase disciplinesUseCase) {
        this.disciplinesUseCase = disciplinesUseCase;    }


    @Override
    public ResponseEntity<DisciplinesDetail> createDisciplines(DisciplinesInput disciplinesInput) {
        DisciplinesOutput disciplinesOutput = null;
        disciplinesOutput = disciplinesUseCase.createDiscipline(disciplinesInput);

        return ResponseEntity.status(HttpStatus.CREATED).body(DisciplinesMapper.INSTANCE.mapDisciplineDetail(disciplinesOutput));
    }

    @Override
    public ResponseEntity<DisciplinesDetail> getDisciplineById(Long disciplineId) {
        DisciplinesOutput disciplinesOutput = null;
        disciplinesOutput = disciplinesUseCase.getDisciplneById(disciplineId);

        return ResponseEntity.ok(DisciplinesMapper.INSTANCE.mapDisciplineDetail(disciplinesOutput));
    }

    @Override
    public ResponseEntity<List<DisciplinesDetail>> getDisciplines(String title) {
        List<DisciplinesOutput> disciplinesOutput = disciplinesUseCase.getAllDisciplines();
        return ResponseEntity.ok(DisciplinesMapper.INSTANCE.mapListDisciplinesDetail(disciplinesOutput));
    }




}
