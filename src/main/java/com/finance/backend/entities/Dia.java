package com.finance.backend.entities;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Dia")
@Data
@Accessors(chain = true)
public class Dia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CDia;

    private Integer QDia;
    private String NDia;
}
