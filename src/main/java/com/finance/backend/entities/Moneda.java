package com.finance.backend.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "Moneda")
@Data
@Accessors(chain = true)
public class Moneda {
    private Long CMoneda;
    private String NMoneda;

}
