package com.nksolucoes.msalunos.datasources;

import com.nksolucoes.msalunos.datasources.clients.DisciplinesClient;
import com.nksolucoes.msalunos.repository.DisciplinesRepository;
import com.nksolucoes.msalunos.transportlayer.responses.DisciplinesResponse;
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

    private Map<Long, DisciplinesResponse> CACHE = new HashMap<>();

    public DisciplinesDataSource(DisciplinesClient disciplinesClient) {
        this.disciplinesClient = disciplinesClient;
    }

    @Override
    @CircuitBreaker(name = "DISCIPLINES_ALL_CB")
    public List<DisciplinesResponse> getAll() {
        return  this.disciplinesClient.getDisciplines();
    }

    @Override
    @CircuitBreaker(name = "DISCIPLINES_CB", fallbackMethod = "getAllFallBack")
    public DisciplinesResponse getDisciplineById(Long disciplineId) {
        DisciplinesResponse disciplinesResponse = null;

        LOGGER.info("Buscando a disciplina por Id");
        disciplinesResponse = this.disciplinesClient.getDisciplinesById(disciplineId);

        LOGGER.info("Alimentando Cache");
        CACHE.put(disciplineId, disciplinesResponse);

        return disciplinesResponse;
    }

    private DisciplinesResponse getAllFallBack(Long disciplineId, Throwable ex) {
        LOGGER.info("Buscando do Cache");
        return CACHE.getOrDefault(disciplineId, DisciplinesResponse.builder().build());
    }
}
