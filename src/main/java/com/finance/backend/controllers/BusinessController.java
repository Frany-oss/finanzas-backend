package com.finance.backend.controllers;

import com.finance.backend.models.DiaDto;
import com.finance.backend.models.MonedaDto;
import com.finance.backend.models.PeriodoDto;
import com.finance.backend.models.TipoTasaDto;
import com.finance.backend.services.BusinessService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class BusinessController {
  private final BusinessService businessService;

  @GetMapping("/monedas")
  public List<MonedaDto> getMonedas() throws Exception {
    return businessService.getMonedas();
  }

  @GetMapping("/periodos")
  public List<PeriodoDto> getPeriodos() throws Exception {
    return businessService.getPeriodos();
  }

  @GetMapping("/tipostasa")
  public List<TipoTasaDto> getTiposTasa() throws Exception {
    return businessService.getTiposTasa();
  }

  @GetMapping("/dias")
  public List<DiaDto> getDias() throws Exception {
    return businessService.getDias();
  }
}
