package com.finance.backend.models;

import lombok.Data;

@Data
public class CreateBonistaDto {
  private String nombre;
  private String correo;
  private String contrasena;
  private String telefono;
}
