package com.finance.backend.repositories;

import com.finance.backend.entities.Bonista;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonistaRepository extends JpaRepository<Bonista, Long> {
  List<Bonista> findAll();

  Optional<Bonista> findByCorreo(String correo);
  
  Optional<Bonista> findByCorreoAndContrasena(String correo, String contrasena);
  
}
