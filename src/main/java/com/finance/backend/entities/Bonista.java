package com.finance.backend.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "Bonista")
@Data
@Accessors(chain = true)
public class Bonista {
    private Long CBonista;
    private String NUsuario;
    private String NBonista;
    private LocalDateTime DCreacion;

}
