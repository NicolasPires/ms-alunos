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

    private final Map<Integer, List<DisciplinesResponse>> CACHE = new HashMap<>();

    public DisciplinesDataSource(DisciplinesClient disciplinesClient) {
        this.disciplinesClient = disciplinesClient;
    }

    @Override
    @CircuitBreaker(name = "DISCIPLINES_CB")
    public List<DisciplinesResponse> getAll() {
        Integer contador = 1;
        List<DisciplinesResponse> disciplinesResponses = new ArrayList<>();

        LOGGER.info("Buscando as disciplinas");
        disciplinesResponses = this.disciplinesClient.getDisciplines();

        LOGGER.info("Alimentando Cache");
        if (!CACHE.isEmpty()) {
             contador++;
        }
        CACHE.put(contador, disciplinesResponses);

        return disciplinesResponses;
    }
}
