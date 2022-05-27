package com.finance.backend.repositories;

import com.finance.backend.entities.Periodo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeriodoRepository extends JpaRepository<Periodo, Long> {
    @Query("SELECT p FROM Periodo p")
    List<Periodo> findAll();
}
