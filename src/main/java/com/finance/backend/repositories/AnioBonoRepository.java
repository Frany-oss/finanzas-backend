package com.finance.backend.repositories;

import com.finance.backend.entities.AnioBono;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnioBonoRepository extends JpaRepository<AnioBono, Long> {
    @Query("SELECT ab FROM AnioBono ab")
    List<AnioBono> findAll();
}
