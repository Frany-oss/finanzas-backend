package com.finance.backend.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "TipoTasa")
@Data
@Accessors(chain = true)
public class TipoTasa {
    private Long CTipoTasa;
    private String NtipoTasa;
}
