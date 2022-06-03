package com.finance.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonPropertyOrder({"bonoCorporativoId", "bonistaId", "*"})
public class BonoCorporativoDto {
  private Long bonoCorporativoId;

  @JsonProperty("bonistaId")
  private Long bonistaBonistaId;

  private String bonistaCorreo;
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
  private BigDecimal perTasaInteres;
  private BigDecimal perPrima;
  private Integer aniosPago;
  private Integer periodosGracia;
  private Boolean tipoTasaEfectiva;
  private Integer numeroDias;
  private Integer tipoPeriodoFrecuenciaCupon;
  private Integer tipoPeriodoCapitalTn;
  private String nombreMoneda;
  private List<BigDecimal> inflacionAnual;
}
