package com.finance.backend.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "BonoCorporativo")
@Data
@Accessors(chain = true)
public class BonoCorporativo {

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
    
    private Long CFrecuenciaCupon;
    private Long CBonista;
    private Long CTipoTasa;
    private Long CPeriodoCapitalizacionTN;
    private Long CDia;
    private Long CMoneda;
}
