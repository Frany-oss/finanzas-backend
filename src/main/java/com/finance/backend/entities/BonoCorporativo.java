package com.finance.backend.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "bono_corporativo")
@Data
@Accessors(chain = true)
public class BonoCorporativo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "bono_corporativo_id")
  private Long CBonoCorporativo;
  
  private String NCalculoBono;
  private LocalDateTime DEmision;
  private BigDecimal MValorNominal;
  private BigDecimal MValorComercial;
  private BigDecimal PerCavali;
  private BigDecimal PerColocacion;
  private BigDecimal PerFlotacion;
  private BigDecimal PerEstructuracion;
  private BigDecimal PerImportRenta;
  private BigDecimal PerTasaAnualDescuento;
  private Integer QAniosPago;
  private Integer CFrecuenciaCupon;
  private Boolean CTipoTasa;
  private Integer CPeriodoCapitaltizacionTN;
  private Integer CDia;
  private Integer QPeriodosGracia;
  private String CMoneda;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(
      name = "bonista_id",
      nullable = false,
      referencedColumnName = "bonista_id",
      foreignKey = @ForeignKey(name = "bono_corporativo_bonista_fk"))
  private Bonista bonista;

  @OneToMany(
      fetch = FetchType.EAGER,
      cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
  @JoinColumn(name = "bono_corporativo_id")
  private List<AnioBono> inflacionAnual;
}
