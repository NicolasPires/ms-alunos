package com.nksolucoes.msalunos.repository;

import com.nksolucoes.msalunos.transportlayer.responses.DisciplinesResponse;

import java.util.List;

public interface DisciplinesRepository {
    List<DisciplinesResponse> getAll();
    DisciplinesResponse getDisciplineById(Long disciplineId);

}
