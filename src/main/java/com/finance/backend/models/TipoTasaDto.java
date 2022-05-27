package com.finance.backend.models;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TipoTasaDto {
    private Long CTipoTasa;
    private String NtipoTasa;
}
