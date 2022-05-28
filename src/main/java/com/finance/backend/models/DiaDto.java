package com.finance.backend.models;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DiaDto {
  private Long CDia;
  private Integer QDia;
  private String NDia;
}
