package com.nksolucoes.msalunos.mock;

import com.nksolucoes.msalunos.transportlayer.documentacao.model.DisciplinesDetail;
import com.nksolucoes.msalunos.transportlayer.documentacao.model.DisciplinesInput;
import com.nksolucoes.msalunos.transportlayer.documentacao.model.DisciplinesOutput;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
public class DisciplinesMock {

    public static DisciplinesDetail mockedDisciplinesDetail() {
        DisciplinesDetail disciplinesDetail = new DisciplinesDetail();
        disciplinesDetail.setDisciplineId(1L);
        disciplinesDetail.setName("Matematica");
        disciplinesDetail.setGrade(10L);

        return disciplinesDetail;
    }

    public static DisciplinesOutput mockedDisciplinesOutput() {
        DisciplinesOutput disciplinesOutput = new DisciplinesOutput();
        disciplinesOutput.setDisciplineId(1L);
        disciplinesOutput.setName("Matematica");
        disciplinesOutput.setGrade(10L);

        return disciplinesOutput;
    }

    public static List<DisciplinesOutput> mockedListDisciplinesDetail() {
        DisciplinesOutput disciplinesOutput = new DisciplinesOutput();
        disciplinesOutput.setDisciplineId(1L);
        disciplinesOutput.setName("Matematica");
        disciplinesOutput.setGrade(10L);

        return List.of(disciplinesOutput);
    }

    public static DisciplinesInput mockedDisciplinesInput() {
        DisciplinesInput disciplinesInput = new DisciplinesInput();
        disciplinesInput.setName("Matematica");
        disciplinesInput.setGrade(10L);

        return disciplinesInput;
    }
}
