package com.nksolucoes.msalunos.transportlayer.mappers;

import com.nksolucoes.msalunos.transportlayer.documentacao.model.DisciplinesDetail;
import com.nksolucoes.msalunos.transportlayer.responses.DisciplinesResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface DisciplinesMapper {

    DisciplinesMapper INSTANCE = Mappers.getMapper(DisciplinesMapper.class);

    DisciplinesDetail mapDisciplineDetail(DisciplinesResponse disciplinesResponse);

    default List<DisciplinesDetail> mapListDisciplinesDetail(List<DisciplinesResponse> disciplinesResponses) {
        final List<DisciplinesDetail> disciplinesDetails = new ArrayList<>();
        for (DisciplinesResponse disciplinesResponse : disciplinesResponses) {
            DisciplinesDetail disciplinesDetail = DisciplinesMapper.INSTANCE.mapDisciplineDetail(disciplinesResponse);
            disciplinesDetails.add(disciplinesDetail);
        }
        return disciplinesDetails;
    }


}
