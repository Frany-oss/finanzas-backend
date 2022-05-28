package com.finance.backend.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "BonoCorporativo")
@Data
@Accessors(chain = true)
public class BonoCorporativo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long CBonoCorporativo;

  private String NCalculoBono;
  private LocalDateTime DEmision;
  private BigDecimal MValorNominal;
  private BigDecimal MValorComercial;
  private BigDecimal PerCavali;
  private BigDecimal PerColocacion;
  private BigDecimal PerFlotacion;
  private BigDecimal PerEstructuracion;
  private BigDecimal PerlmportRenta;
  private BigDecimal PerTasaAnualDescuento;

  private Integer QAniosPago;
  private Integer QPeriodosGracia;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(
      name = "CBonista",
      nullable = false,
      referencedColumnName = "CBonista",
      foreignKey = @ForeignKey(name = "BonoCorporativo_Bonista_fk"))
  private Bonista Bonista;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      name = "CPeriodoFrecuenciaCupon",
      nullable = false,
      referencedColumnName = "CPeriodo",
      foreignKey = @ForeignKey(name = "BonoCorporativo_PeriodoFrecuenciaCupon_fk"))
  private Periodo PeriodoFrecuenciaCupon;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      name = "CPeriodoCapitalizacionTN",
      nullable = false,
      referencedColumnName = "CPeriodo",
      foreignKey = @ForeignKey(name = "BonoCorporativo_PeriodoCapitalizacionTN_fk"))
  private Periodo PeriodoCapitalizacionTN;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(
      name = "CTipoTasa",
      nullable = false,
      referencedColumnName = "CTipoTasa",
      foreignKey = @ForeignKey(name = "BonoCorporativo_TipoTasa_fk"))
  private TipoTasa TipoTasa;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(
      name = "CDia",
      nullable = false,
      referencedColumnName = "CDia",
      foreignKey = @ForeignKey(name = "BonoCorporativo_Dia_fk"))
  private Dia Dia;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(
      name = "CMoneda",
      nullable = false,
      referencedColumnName = "CMoneda",
      foreignKey = @ForeignKey(name = "BonoCorporativo_Moneda_fk"))
  private Moneda Moneda;
}
