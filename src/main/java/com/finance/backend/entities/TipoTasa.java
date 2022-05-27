package com.finance.backend.entities;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TipoTasa")
@Data
@Accessors(chain = true)
public class TipoTasa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CTipoTasa;

    private String NtipoTasa;
}
