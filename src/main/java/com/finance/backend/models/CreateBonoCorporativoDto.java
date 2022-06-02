package com.finance.backend.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class CreateBonoCorporativoDto {
  private String nombreCalculoBono;
  private LocalDateTime fechaEmision;
  private BigDecimal valorNominal;
  private BigDecimal valorComercial;
  private BigDecimal perCavali;
  private BigDecimal perColocacion;
  private BigDecimal perFlotacion;
  private BigDecimal perEstructuracion;
  private BigDecimal perImportRenta;
  private BigDecimal perTasaAnualDescuento;
  private BigDecimal perTasaInteres; //
  private BigDecimal perPrima; //
  private Integer aniosPago;
  private Integer periodosGracia;
  private Boolean tipoTasaEfectiva;
  private Integer numeroDias;
  private Integer tipoPeriodoFrecuenciaCupon;
  private Integer tipoPeriodoCapitalTn;
  private String nombreMoneda;
  private String bonistaCorreo;
  private List<BigDecimal> inflacionesAnuales;
}
