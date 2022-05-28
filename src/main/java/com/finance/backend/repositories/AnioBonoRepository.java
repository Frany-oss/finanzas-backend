package com.finance.backend.repositories;

import com.finance.backend.entities.AnioBono;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnioBonoRepository extends JpaRepository<AnioBono, Long> {
  @Query("SELECT ab FROM AnioBono ab")
  List<AnioBono> findAll();
}
