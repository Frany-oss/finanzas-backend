package com.finance.backend.models;

import lombok.Data;

@Data
public class UpdateBonistaDto {
    private Long bonistaId;
    private String nombre;
    private String correo;
    private String telefono;
    private String contrasena;
}
