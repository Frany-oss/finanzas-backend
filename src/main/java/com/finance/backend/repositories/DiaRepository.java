package com.finance.backend.repositories;

import com.finance.backend.entities.Dia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiaRepository extends JpaRepository<Dia, Long> {
    @Query("SELECT d FROM Dia d")
    List<Dia> findAll();
}
