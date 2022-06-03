package com.finance.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BonistaDto {
  private Long bonistaId;
  private String nombre;
  private String correo;
  private Boolean activo;

  @JsonIgnore private String contrasena;
  @JsonIgnore private LocalDateTime fechaCreacion;
}
