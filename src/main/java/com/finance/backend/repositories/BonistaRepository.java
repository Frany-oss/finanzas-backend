package com.finance.backend.repositories;

import com.finance.backend.entities.Bonista;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BonistaRepository extends JpaRepository<Bonista, Long> {
	@Query("SELECT b FROM Bonista b")
	List<Bonista> findAll();
}
