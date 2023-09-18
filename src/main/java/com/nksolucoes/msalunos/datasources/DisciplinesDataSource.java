package com.nksolucoes.msalunos.datasources;

import com.nksolucoes.msalunos.datasources.clients.DisciplinesClient;
import com.nksolucoes.msalunos.repository.DisciplinesRepository;
import com.nksolucoes.msalunos.transportlayer.responses.DisciplinesResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DisciplinesDataSource implements DisciplinesRepository {

    private final DisciplinesClient disciplinesClient;

    public DisciplinesDataSource(DisciplinesClient disciplinesClient) {
        this.disciplinesClient = disciplinesClient;
    }

    @Override
    public List<DisciplinesResponse> getAll() {
        return this.disciplinesClient.getDisciplines();
    }
}
