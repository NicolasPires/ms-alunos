package com.nksolucoes.msalunos.datasources.clients;

import com.nksolucoes.msalunos.transportlayer.responses.DisciplinesResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ms-disciplines", url = "http://localhost:8090/disciplines")
public interface DisciplinesClient {
    @GetMapping
    List<DisciplinesResponse> getDisciplines();

}
