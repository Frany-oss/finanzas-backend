package com.finance.backend.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
  private BigDecimal perlmportRenta;
  private BigDecimal perTasaAnualDescuento;
  private Integer aniosPago;
  private Integer periodosGracia;
  private String bonistaCorreo;
  private Long periodoFrecuenciaCuponId;
  private Long periodoCapitalizacionId;
  private Long tipoTasaId;
  private Long diaId;
  private Long monedaId;
}
