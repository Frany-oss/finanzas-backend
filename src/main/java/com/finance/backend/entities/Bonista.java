package com.finance.backend.entities;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
        name = "Bonista",
        uniqueConstraints = {
            @UniqueConstraint(name = "bonista_usuario_unico", columnNames = "TCorreo")
        })
@Data
@Accessors(chain = true)
public class Bonista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CBonista;

    private String NBonista;
    private String TCorreo;
    private String TContrasena;
    private LocalDateTime DCreacion;
    private Byte FActivo;
}
