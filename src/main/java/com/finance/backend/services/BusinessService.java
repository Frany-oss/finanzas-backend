package com.finance.backend.services;

import com.finance.backend.entities.BonoCorporativo;
import com.finance.backend.models.BonoCorporativoDto;
import com.finance.backend.models.CreateBonoCorporativoDto;
import com.finance.backend.models.DiaDto;
import com.finance.backend.models.MonedaDto;
import com.finance.backend.models.PeriodoDto;
import com.finance.backend.models.TipoTasaDto;
import com.finance.backend.repositories.BonistaRepository;
import com.finance.backend.repositories.BonoCorporativoRepository;
import com.finance.backend.repositories.DiaRepository;
import com.finance.backend.repositories.MonedaRepository;
import com.finance.backend.repositories.PeriodoRepository;
import com.finance.backend.repositories.TipoTasaRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BusinessService {
  private final BonoCorporativoRepository bonoCorporativoRepository;
  private final BonistaRepository bonistaRepository;
  private final PeriodoRepository periodoRepository;
  private final TipoTasaRepository tipoTasaRepository;
  private final MonedaRepository monedaRepository;
  private final DiaRepository diaRepository;
  private final ModelMapper modelMapper;

  public BonoCorporativoDto CreateBonoCorporativo(CreateBonoCorporativoDto createBonoCorporativoDto)
      throws Exception {
    return Optional.of(
            bonoCorporativoRepository.save(
                new BonoCorporativo()
                    .setDEmision(createBonoCorporativoDto.getDEmision())
                    .setMValorComercial(createBonoCorporativoDto.getMValorComercial())
                    .setMValorNominal(createBonoCorporativoDto.getMValorNominal())
                    .setNCalculoBono(createBonoCorporativoDto.getNCalculoBono())
                    .setPerCavali(createBonoCorporativoDto.getPerCavali())
                    .setPerColocacion(createBonoCorporativoDto.getPerColocacion())
                    .setPerEstructuracion(createBonoCorporativoDto.getPerEstructuracion())
                    .setPerFlotacion(createBonoCorporativoDto.getPerFlotacion())
                    .setPerTasaAnualDescuento(createBonoCorporativoDto.getPerTasaAnualDescuento())
                    .setBonista(
                        bonistaRepository
                            .findById(createBonoCorporativoDto.getCBonista())
                            .orElseThrow(() -> new Exception("Error al obtener bonista")))
                    .setPeriodoFrecuenciaCupon(
                        periodoRepository
                            .findById(createBonoCorporativoDto.getCPeriodoFrecuenciaCupon())
                            .orElseThrow(() -> new Exception("Error al obtener periodo")))
                    .setPeriodoCapitalizacionTN(
                        periodoRepository
                            .findById(createBonoCorporativoDto.getCPeriodoCapitalizacionTN())
                            .orElseThrow(() -> new Exception("Error al obtener periodo")))
                    .setTipoTasa(
                        tipoTasaRepository
                            .findById(createBonoCorporativoDto.getCTipoTasa())
                            .orElseThrow(() -> new Exception("Error al obtener tipo tasa")))
                    .setMoneda(
                        monedaRepository
                            .findById(createBonoCorporativoDto.getCMoneda())
                            .orElseThrow(() -> new Exception("Error al obtener moneda")))
                    .setDia(
                        diaRepository
                            .findById(createBonoCorporativoDto.getCDia())
                            .orElseThrow(() -> new Exception("Error al obtener dia")))))
        .map(bonoCorporativo -> modelMapper.map(bonoCorporativo, BonoCorporativoDto.class))
        .orElseThrow(() -> new Exception("Error al guardar bono corporativo"));
  }

  public List<MonedaDto> getMonedas() throws Exception {
    return monedaRepository.findAll().stream()
        .map(moneda -> modelMapper.map(moneda, MonedaDto.class))
        .toList();
  }

  public List<PeriodoDto> getPeriodos() throws Exception {
    return periodoRepository.findAll().stream()
        .map(periodo -> modelMapper.map(periodo, PeriodoDto.class))
        .toList();
  }

  public List<TipoTasaDto> getTiposTasa() throws Exception {
    return tipoTasaRepository.findAll().stream()
        .map(tipoTasa -> modelMapper.map(tipoTasa, TipoTasaDto.class))
        .toList();
  }

  public List<DiaDto> getDias() throws Exception {
    return diaRepository.findAll().stream().map(dia -> modelMapper.map(dia, DiaDto.class)).toList();
  }
}
