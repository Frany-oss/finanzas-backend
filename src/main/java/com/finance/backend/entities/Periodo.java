package com.finance.backend.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "Periodo")
@Data
@Accessors(chain = true)
public class Periodo {
    private Long CPeriodo;
    private String NPeriodo;
    private Integer QDias;
}
