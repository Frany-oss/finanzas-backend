package com.finance.backend.repositories;

import com.finance.backend.entities.Periodo;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodoRepository extends JpaRepository<Periodo, Long> {
  List<Periodo> findAll();

  Optional<Periodo> findByCPeriodo(Long cPeriodo);
}
