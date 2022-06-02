package com.finance.backend.controllers;

import com.finance.backend.models.BonoCorporativoDto;
import com.finance.backend.models.CreateBonoCorporativoDto;
import com.finance.backend.services.BonoCorporativoService;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class BonoCorporativoController {
  private final BonoCorporativoService businessService;

  @PostMapping("/bonos")
  public BonoCorporativoDto createBonoCorporativo(
      @RequestBody CreateBonoCorporativoDto createBonoCorporativoDto) throws Exception {
    return businessService.createBonoCorporativo(createBonoCorporativoDto);
  }

  @GetMapping("/bonos/{correo}")
  public List<BonoCorporativoDto> getBonosCorporativoByBonistaCorreo(
      @PathVariable("correo") String correo) throws Exception {
    return businessService.getBonosCorporativoByBonistaCorreo(correo);
  }
}
