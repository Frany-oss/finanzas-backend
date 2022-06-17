package com.finance.backend.controllers;

import com.finance.backend.models.BonoCorporativoDto;
import com.finance.backend.models.CreateBonoCorporativoDto;
import com.finance.backend.services.BonoCorporativoService;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class BonoCorporativoController {
  private final BonoCorporativoService bonoCorporativoService;

  @PostMapping("/bonos")
  public BonoCorporativoDto createBonoCorporativo(
      @RequestBody CreateBonoCorporativoDto createBonoCorporativoDto) throws Exception {
    return bonoCorporativoService.createBonoCorporativo(createBonoCorporativoDto);
  }

  @GetMapping("/bonos/id/{bonoId}")
  public BonoCorporativoDto getBonoByBonoId(@PathVariable("bonoId") Long bonoId) throws Exception {
    return bonoCorporativoService.getBonoByBonoId(bonoId);
  }

  @GetMapping("/bonos")
  public List<BonoCorporativoDto> getBonosByBonoNombre(
      @RequestParam(value = "id", required = false) Long bonoId,
      @RequestParam(value = "nombre", required = false) String bonoNombre)
      throws Exception {
    return Stream.of(
            bonoId == null
                ? Collections.<BonoCorporativoDto>emptyList()
                : List.of(bonoCorporativoService.getBonoByBonoId(bonoId)),
            bonoId == null
                ? bonoCorporativoService.getBonosByBonoNombre(bonoNombre)
                : Collections.<BonoCorporativoDto>emptyList())
        .flatMap(Collection::stream)
        .toList();
  }

  @GetMapping("/bonos/bonista/id/{bonistaId}")
  public List<BonoCorporativoDto> getBonosByBonistaId(@PathVariable("bonistaId") Long bonistaId)
      throws Exception {
    return bonoCorporativoService.getBonosByBonistaId(bonistaId);
  }

  @GetMapping("/bonos/bonista/correo/{correo}")
  public List<BonoCorporativoDto> getBonosCorporativoByBonistaCorreo(
      @PathVariable("correo") String correo) throws Exception {
    return bonoCorporativoService.getBonosCorporativoByBonistaCorreo(correo);
  }

  @DeleteMapping("/bonos/{bonoId}")
  public BonoCorporativoDto deleteBonoCorporativo(@PathVariable("bonoId") Long bonoId) throws Exception {
    return bonoCorporativoService.deleteBonoCorporativo(bonoId);
  }
}
