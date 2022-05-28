package com.finance.backend.repositories;

import com.finance.backend.entities.Dia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaRepository extends JpaRepository<Dia, Long> {
  @Query("SELECT d FROM Dia d")
  List<Dia> findAll();
}
