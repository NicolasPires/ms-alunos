package com.nksolucoes.msalunos.datasources;

import com.nksolucoes.msalunos.datasources.clients.DisciplinesClient;
import com.nksolucoes.msalunos.repository.DisciplinesRepository;
import com.nksolucoes.msalunos.transportlayer.documentacao.model.DisciplinesInput;
import com.nksolucoes.msalunos.transportlayer.documentacao.model.DisciplinesOutput;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Slf4j
public class DisciplinesDataSource implements DisciplinesRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(DisciplinesDataSource.class);

    private final DisciplinesClient disciplinesClient;

    private Map<Long, DisciplinesOutput> CACHE = new HashMap<>();

    public DisciplinesDataSource(DisciplinesClient disciplinesClient) {
        this.disciplinesClient = disciplinesClient;
    }

    @Override
    @CircuitBreaker(name = "DISCIPLINES_ALL_CB")
    public List<DisciplinesOutput> getAll() {
        return  this.disciplinesClient.getDisciplines();
    }

    @Override
    @CircuitBreaker(name = "DISCIPLINES_CB", fallbackMethod = "getAllFallBack")
    public DisciplinesOutput getDisciplineById(Long disciplineId) {
        DisciplinesOutput disciplinesOutput = null;

        LOGGER.info("Buscando a disciplina por Id");
        disciplinesOutput = this.disciplinesClient.getDisciplinesById(disciplineId);

        LOGGER.info("Alimentando Cache");
        CACHE.put(disciplineId, disciplinesOutput);

        return disciplinesOutput;
    }

    @Override
    public DisciplinesOutput createDiscipline(DisciplinesInput disciplinesInput) {
        return this.disciplinesClient.createDiscipline(disciplinesInput);
    }

    private DisciplinesOutput getAllFallBack(Long disciplineId, Throwable ex) {
        LOGGER.info("Buscando do Cache");
        DisciplinesOutput disciplinesOutput = new DisciplinesOutput();
        return CACHE.getOrDefault(disciplineId, disciplinesOutput);
    }
}
