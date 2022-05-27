package com.finance.backend.models;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PeriodoDto {
    private Long CPeriodo;
    private String NPeriodo;
    private Integer QDias;
}
