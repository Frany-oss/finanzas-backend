package com.finance.backend.models;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LoginBonistaDto {
  private String correo;
  private String contrasena;
}
