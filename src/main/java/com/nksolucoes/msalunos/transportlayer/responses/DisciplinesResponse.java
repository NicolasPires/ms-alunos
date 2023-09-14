package com.nksolucoes.msalunos.transportlayer.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DisciplinesResponse {
    private Long id;
    private String name;
    private String grade;
    private Date createDate;

}
