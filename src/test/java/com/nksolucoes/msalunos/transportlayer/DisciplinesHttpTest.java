package com.nksolucoes.msalunos.transportlayer;

import com.nksolucoes.msalunos.interactors.DisciplinesUseCase;
import com.nksolucoes.msalunos.mock.DisciplinesMock;
import com.nksolucoes.msalunos.transportlayer.documentacao.model.DisciplinesDetail;
import com.nksolucoes.msalunos.transportlayer.documentacao.model.DisciplinesInput;
import com.nksolucoes.msalunos.transportlayer.documentacao.model.DisciplinesOutput;
import com.nksolucoes.msalunos.transportlayer.mappers.DisciplinesMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


import static org.hamcrest.Matchers.contains;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class DisciplinesHttpTest {

    @InjectMocks
    private DisciplinesHttp disciplinesHttp;

    @Mock
    private DisciplinesUseCase disciplinesUseCase;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetDisciplines() {
        List<DisciplinesOutput> mockDisciplinesOutput = DisciplinesMock.mockedListDisciplinesDetail();
        when(disciplinesUseCase.getAllDisciplines()).thenReturn(mockDisciplinesOutput);
        ResponseEntity<List<DisciplinesDetail>> responseEntity = disciplinesHttp.getDisciplines("exampleTitle");

        verify(disciplinesUseCase, times(1)).getAllDisciplines();
    }

    @Test
    public void testGetDisciplineById() {
        Long disciplineId = 1L;
        DisciplinesOutput mockDisciplinesOutput = DisciplinesMock.mockedDisciplinesOutput();

        when(disciplinesUseCase.getDisciplneById(disciplineId)).thenReturn(mockDisciplinesOutput);
        ResponseEntity<DisciplinesDetail> responseEntity = disciplinesHttp.getDisciplineById(disciplineId);

        verify(disciplinesUseCase, times(1)).getDisciplneById(disciplineId);
    }

    @Test
    public void testCreateDisciplines() {
        DisciplinesInput mockDisciplinesInput = DisciplinesMock.mockedDisciplinesInput();
        DisciplinesOutput mockDisciplinesOutput = DisciplinesMock.mockedDisciplinesOutput();

        when(disciplinesUseCase.createDiscipline(mockDisciplinesInput)).thenReturn(mockDisciplinesOutput);
        ResponseEntity<DisciplinesDetail> responseEntity = disciplinesHttp.createDisciplines(mockDisciplinesInput);

        verify(disciplinesUseCase, times(1)).createDiscipline(mockDisciplinesInput);
        assertSame(HttpStatus.CREATED, responseEntity.getStatusCode());
    }
}
