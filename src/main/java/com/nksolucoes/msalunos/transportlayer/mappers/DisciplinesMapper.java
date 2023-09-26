package com.nksolucoes.msalunos.transportlayer.mappers;

import com.nksolucoes.msalunos.transportlayer.documentacao.model.DisciplinesDetail;
import com.nksolucoes.msalunos.transportlayer.documentacao.model.DisciplinesInput;
import com.nksolucoes.msalunos.transportlayer.documentacao.model.DisciplinesOutput;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface DisciplinesMapper {
    DisciplinesMapper INSTANCE = Mappers.getMapper(DisciplinesMapper.class);

    DisciplinesInput map(DisciplinesOutput disciplinesOutput);

    DisciplinesDetail mapDisciplineDetail(DisciplinesOutput disciplinesResponse);

    default List<DisciplinesDetail> mapListDisciplinesDetail(List<DisciplinesOutput> disciplinesOutputs) {
        final List<DisciplinesDetail> disciplinesDetails = new ArrayList<>();
        for (DisciplinesOutput disciplinesOutput : disciplinesOutputs) {
            DisciplinesDetail disciplinesDetail = DisciplinesMapper.INSTANCE.mapDisciplineDetail(disciplinesOutput);
            disciplinesDetails.add(disciplinesDetail);
        }
        return disciplinesDetails;
    }


}
