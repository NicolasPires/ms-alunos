package com.nksolucoes.msalunos.interactors;

import com.nksolucoes.msalunos.repository.DisciplinesRepository;
import com.nksolucoes.msalunos.transportlayer.documentacao.model.DisciplinesInput;
import com.nksolucoes.msalunos.transportlayer.documentacao.model.DisciplinesOutput;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DisciplinesUseCase {

    private final DisciplinesRepository disciplinesRepository;

    public DisciplinesUseCase(DisciplinesRepository disciplinesRepository) {
        this.disciplinesRepository = disciplinesRepository;
    }

    public List<DisciplinesOutput> getAllDisciplines() {
        return disciplinesRepository.getAll();
    }

    public DisciplinesOutput getDisciplneById(Long disciplineId) {
        DisciplinesOutput disciplinesOutput = this.disciplinesRepository.getDisciplineById(disciplineId);
        if (Objects.isNull(disciplinesOutput)) {
            new RuntimeException("No content Discipline!");
        }
        return disciplinesOutput;
    }

    public DisciplinesOutput createDiscipline(DisciplinesInput disciplinesInput) {
        return this.disciplinesRepository.createDiscipline(disciplinesInput);
    }
}
