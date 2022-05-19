package com.finance.backend.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "Dia")
@Data
@Accessors(chain = true)
public class Dia {

    private Long CDia;
    private Integer QDia;
    private String NDia;
    
}
