package com.finance.backend.entities;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "anio_bono")
@Data
@Accessors(chain = true)
public class AnioBono {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "anio_bono_id")
  private Long anioBonoId;

  private Integer numeroAnio;
  private BigDecimal perInflacion;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      name = "bono_corporativo_id",
      nullable = false,
      referencedColumnName = "bono_corporativo_id",
      foreignKey = @ForeignKey(name = "anio_bono_bono_corporativo_fk"))
  private BonoCorporativo bonoCorporativo;
}
