package com.finance.backend.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BonoCorporativoDto {
	
  @JsonIgnore private Long CBonoCorporativo;
  
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
  
  private List<BigDecimal> inflacionAnual;
}
