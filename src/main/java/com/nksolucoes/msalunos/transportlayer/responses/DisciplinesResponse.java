package com.nksolucoes.msalunos.transportlayer.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DisciplinesResponse {
    private Long disciplineId;
    private String name;
    private String grade;
}
