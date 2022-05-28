package com.finance.backend.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BonoCorporativoDto {
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
  private BonistaDto Bonista;
  private PeriodoDto PeriodoFrecuenciaCupon;
  private PeriodoDto PeriodoCapitalizacionTN;
  private TipoTasaDto TipoTasa;
  private DiaDto Dia;
  private MonedaDto Moneda;
}
