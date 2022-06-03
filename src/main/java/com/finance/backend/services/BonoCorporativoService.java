package com.finance.backend.services;

import com.finance.backend.entities.AnioBono;
import com.finance.backend.entities.BonoCorporativo;
import com.finance.backend.models.BonoCorporativoDto;
import com.finance.backend.models.CreateBonoCorporativoDto;
import com.finance.backend.repositories.AnioBonoRepository;
import com.finance.backend.repositories.BonistaRepository;
import com.finance.backend.repositories.BonoCorporativoRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BonoCorporativoService {
  private final BonoCorporativoRepository bonoCorporativoRepository;
  private final BonistaRepository bonistaRepository;
  private final AnioBonoRepository anioBonoRepository;
  private final ModelMapper modelMapper;

  public BonoCorporativoDto createBonoCorporativo(CreateBonoCorporativoDto body) throws Exception {
    return Optional.of(
            bonoCorporativoRepository.save(
                new BonoCorporativo()
                    .setNombreCalculoBono(body.getNombreCalculoBono())
                    .setPerPrima(body.getPerPrima())
                    .setPerTasaInteres(body.getPerTasaInteres())
                    .setFechaEmision(body.getFechaEmision())
                    .setValorNominal(body.getValorNominal())
                    .setValorComercial(body.getValorComercial())
                    .setPerCavali(body.getPerCavali())
                    .setPerColocacion(body.getPerColocacion())
                    .setPerFlotacion(body.getPerFlotacion())
                    .setPerEstructuracion(body.getPerEstructuracion())
                    .setPerImportRenta(body.getPerImportRenta())
                    .setPerTasaAnualDescuento(body.getPerTasaAnualDescuento())
                    .setAniosPago(body.getAniosPago())
                    .setPeriodosGracia(body.getPeriodosGracia())
                    .setTipoTasaEfectiva(body.getTipoTasaEfectiva())
                    .setNumeroDias(body.getNumeroDias())
                    .setTipoPeriodoFrecuenciaCupon(body.getTipoPeriodoFrecuenciaCupon())
                    .setTipoPeriodoCapitalTn(body.getTipoPeriodoCapitalTn())
                    .setNombreMoneda(body.getNombreMoneda())
                    .setBonista(
                        bonistaRepository
                            .findByCorreo(body.getBonistaCorreo())
                            .orElseThrow(() -> new Exception("Error al obtener bonista")))))
        .map(
            bono ->
                modelMapper.map(
                    bono.setInflacionAnual(
                        IntStream.range(0, body.getAniosPago())
                            .boxed()
                            .map(
                                idx ->
                                    anioBonoRepository.save(
                                        new AnioBono()
                                            .setNumeroAnio(idx + 1)
                                            .setPerInflacion(body.getInflacionesAnuales().get(idx))
                                            .setBonoCorporativo(bono)))
                            .toList()),
                    BonoCorporativoDto.class))
        .orElseThrow(() -> new Exception("Error al guardar bono corporativo"));
  }

  public BonoCorporativoDto getBonoByBonoId(Long bonoId) throws Exception {
    return bonoCorporativoRepository
        .findById(bonoId)
        .map(bono -> modelMapper.map(bono, BonoCorporativoDto.class))
        .orElseThrow(() -> new Exception("Error al obtener bono"));
  }

  public List<BonoCorporativoDto> getBonosByBonoNombre(String bonoNombre) throws Exception {
    return bonoCorporativoRepository.findByNombreCalculoBonoIgnoreCase(bonoNombre).stream()
        .map(bono -> modelMapper.map(bono, BonoCorporativoDto.class))
        .toList();
  }

  public List<BonoCorporativoDto> getBonosCorporativoByBonistaCorreo(String correo)
      throws Exception {
    return bonistaRepository
        .findByCorreo(correo)
        .map(
            bonista ->
                bonoCorporativoRepository.findByBonistaCorreo(bonista.getCorreo()).stream()
                    .map(bono -> modelMapper.map(bono, BonoCorporativoDto.class))
                    .toList())
        .orElseThrow(() -> new Exception("Error al obtener bonista"));
  }

  public List<BonoCorporativoDto> getBonosByBonistaId(Long bonistaId) throws Exception {
    return bonistaRepository
        .findById(bonistaId)
        .map(
            bonista ->
                bonoCorporativoRepository.findByBonistaBonistaId(bonista.getBonistaId()).stream()
                    .map(bono -> modelMapper.map(bono, BonoCorporativoDto.class))
                    .toList())
        .orElseThrow(() -> new Exception("Error al obtener bonista"));
  }
}
