package com.finance.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BonistaDto {
  private String NBonista;
  private String TCorreo;
  private Boolean FActivo;

  @JsonIgnore private Long CBonista;
  @JsonIgnore private String TContrasena;
  @JsonIgnore private LocalDateTime DCreacion;
}
