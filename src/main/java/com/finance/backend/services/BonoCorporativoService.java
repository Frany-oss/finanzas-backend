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

  public List<BonoCorporativoDto> getBonosCorporativoByBonistaCorreo(String correo) {
    return bonoCorporativoRepository.findByBonistaCorreo(correo).stream()
        .map(bono -> modelMapper.map(bono, BonoCorporativoDto.class))
        .toList();
  }
}
