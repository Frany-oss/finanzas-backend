package com.finance.backend.models;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BonistaDto {
  private Long CBonista;
  private String NBonista;
  private String TCorreo;
  private String TContrasena;
  private LocalDateTime DCreacion;
  private Boolean FActivo;
}
