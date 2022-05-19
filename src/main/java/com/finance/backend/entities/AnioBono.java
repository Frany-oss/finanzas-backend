package com.finance.backend.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "AnioBono")
@Data
@Accessors(chain = true)
public class AnioBono {
    private Long CAnioBono;
    private Long CBonoCorporativo;

    private Integer NumAnio;
    private Float PerInflacion;
}
