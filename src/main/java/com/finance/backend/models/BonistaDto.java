package com.finance.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BonistaDto {
  private String nombre;
  private String correo;
  private Boolean activo;

  @JsonIgnore private Long bonistaId;
  @JsonIgnore private String contrasena;
  @JsonIgnore private LocalDateTime fechaCreacion;
}
