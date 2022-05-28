package com.finance.backend.repositories;

import com.finance.backend.entities.TipoTasa;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTasaRepository extends JpaRepository<TipoTasa, Long> {
  @Query("SELECT ts FROM TipoTasa ts")
  List<TipoTasa> findAll();
}
