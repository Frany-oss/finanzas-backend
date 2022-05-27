package com.finance.backend.models;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CreateBonoCorporativoDto {
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
    private Long CBonista;
    private Long CPeriodoFrecuenciaCupon;
    private Long CPeriodoCapitalizacionTN;
    private Long  CTipoTasa;
    private Long CDia;
    private Long CMoneda;
}
