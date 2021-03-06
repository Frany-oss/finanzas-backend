package com.finance.backend.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(
    name = "bonista",
    uniqueConstraints = {@UniqueConstraint(name = "bonista_usuario_unico", columnNames = "correo")})
@Data
@Accessors(chain = true)
public class Bonista {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "bonista_id")
  private Long CBonista;

  private String NBonista;
  private String TCorreo;
  private String TContrasena;
  private LocalDateTime DCreacion;
  private Boolean FActivo;
}
