package com.finance.backend.models;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MonedaDto {
  private Long CMoneda;
  private String NMoneda;
  private String NSimbolo;
}
