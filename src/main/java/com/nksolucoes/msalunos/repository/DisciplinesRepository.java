package com.nksolucoes.msalunos.repository;

import com.nksolucoes.msalunos.transportlayer.documentacao.model.DisciplinesInput;
import com.nksolucoes.msalunos.transportlayer.documentacao.model.DisciplinesOutput;

import java.util.List;

public interface DisciplinesRepository {

    List<DisciplinesOutput> getAll();
    DisciplinesOutput getDisciplineById(Long disciplineId);
    DisciplinesOutput createDiscipline(DisciplinesInput disciplinesInput);
}
