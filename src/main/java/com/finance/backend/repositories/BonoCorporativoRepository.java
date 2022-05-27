package com.finance.backend.repositories;

import com.finance.backend.entities.BonoCorporativo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BonoCorporativoRepository extends JpaRepository<BonoCorporativo, Long> {
    @Query("SELECT bc FROM BonoCorporativo bc")
    List<BonoCorporativo> findAll();
}
