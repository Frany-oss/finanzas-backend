package com.finance.backend.entities;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Periodo")
@Data
@Accessors(chain = true)
public class Periodo {
    @Id private Long CPeriodo;
    private String NPeriodo;
    private Integer QDias;
}
