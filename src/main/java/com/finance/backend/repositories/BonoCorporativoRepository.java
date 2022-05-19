package com.finance.backend.repositories;

import com.finance.backend.entities.BonoCorporativo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BonoCorporativoRepository extends JpaRepository<BonoCorporativo, Long> {
	@Query("SELECT bc FROM BonoCorporativo bc")
	List<BonoCorporativo> findAll();
}
