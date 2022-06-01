package com.finance.backend.models;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LoginBonistaDto {
  private String TCorreo;
  private String TContrasena;
}
