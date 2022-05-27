package com.finance.backend.entities;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;

@Entity
@Table(name = "AnioBono")
@Data
@Accessors(chain = true)
public class AnioBono {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CAnioBono;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "CBonoCorporativo",
            nullable = false,
            referencedColumnName = "CBonoCorporativo",
            foreignKey = @ForeignKey(name = "AnioBono_BonoCorporativo_fk"))
    private BonoCorporativo BonoCorporativo;

    private Integer NumAnio;
    private Float PerInflacion;
}
