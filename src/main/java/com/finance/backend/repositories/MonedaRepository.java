package com.finance.backend.repositories;

import com.finance.backend.entities.Moneda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonedaRepository extends JpaRepository<Moneda, Long> {
    @Query("SELECT m FROM Moneda m")
    List<Moneda> findAll();
}