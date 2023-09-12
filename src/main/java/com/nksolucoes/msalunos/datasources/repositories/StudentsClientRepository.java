package com.nksolucoes.msalunos.datasources.repositories;

import com.nksolucoes.msalunos.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsClientRepository extends JpaRepository<Student, Long> {

}
