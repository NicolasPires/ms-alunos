package com.nksolucoes.msalunos.datasources.clients;

import com.nksolucoes.msalunos.transportlayer.documentacao.model.DisciplinesInput;
import com.nksolucoes.msalunos.transportlayer.documentacao.model.DisciplinesOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "ms-disciplines", url = "http://localhost:8090/disciplines")
public interface DisciplinesClient {
    @GetMapping
    List<DisciplinesOutput> getDisciplines();
    @PostMapping
    DisciplinesOutput createDiscipline(@RequestBody DisciplinesInput disciplinesInput);
    @GetMapping("/{disciplineId}")
    DisciplinesOutput getDisciplinesById(@PathVariable Long disciplineId);
}
