package com.finance.backend.data;

import com.finance.backend.entities.Dia;
import com.finance.backend.entities.Moneda;
import com.finance.backend.entities.Periodo;
import com.finance.backend.entities.TipoTasa;
import com.finance.backend.repositories.DiaRepository;
import com.finance.backend.repositories.MonedaRepository;
import com.finance.backend.repositories.PeriodoRepository;
import com.finance.backend.repositories.TipoTasaRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InsertData implements ApplicationRunner {
  private final PeriodoRepository periodoRepository;
  private final DiaRepository diaRepository;
  private final TipoTasaRepository tipoTasaRepository;
  private final MonedaRepository monedaRepository;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    this.insertPeriodos();
    this.insertDias();
    this.insertTipoTasa();
    this.insertMoneda();
  }

  private void insertPeriodos() {
    var periodos =
        List.of(
            new Periodo().setNPeriodo("Diario").setQDias(1),
            new Periodo().setNPeriodo("Quincenal").setQDias(15),
            new Periodo().setNPeriodo("Mensual").setQDias(30),
            new Periodo().setNPeriodo("Bimestral").setQDias(60),
            new Periodo().setNPeriodo("Trimestral").setQDias(90),
            new Periodo().setNPeriodo("Cuatrimestral").setQDias(120),
            new Periodo().setNPeriodo("Semestral").setQDias(180),
            new Periodo().setNPeriodo("Anual").setQDias(360));

    if (periodoRepository.findById(1L).isEmpty()) {
      periodos.forEach(periodo -> periodoRepository.save(periodo));
    }
  }

  private void insertDias() {
    var dias =
        List.of(
            new Dia().setNDia("Ordinarios").setQDia(360),
            new Dia().setNDia("Exactos").setQDia(365));

    if (diaRepository.findById(1L).isEmpty()) {
      dias.forEach(dia -> diaRepository.save(dia));
    }
  }

  private void insertTipoTasa() {
    var tiposTasa =
        List.of(
            new TipoTasa().setNtipoTasa("Tasa Efectiva"),
            new TipoTasa().setNtipoTasa("Tasa Nominal"));

    if (tipoTasaRepository.findById(1L).isEmpty()) {
      tiposTasa.forEach(tipoTasa -> tipoTasaRepository.save(tipoTasa));
    }
  }

  private void insertMoneda() {
    var monedas =
        List.of(
            new Moneda().setNMoneda("Nuevo Sol").setNSimbolo("PEN"),
            new Moneda().setNMoneda("Peso Colombiano").setNSimbolo("COP"),
            new Moneda().setNMoneda("Dólar estadounidense").setNSimbolo("USD"),
            new Moneda().setNMoneda("Euro").setNSimbolo("EUR"),
            new Moneda().setNMoneda("Yen japonés").setNSimbolo("JPY"),
            new Moneda().setNMoneda("Libra esterlina").setNSimbolo("GBP"),
            new Moneda().setNMoneda("Dólar australiano").setNSimbolo("AUD"),
            new Moneda().setNMoneda("Dólar canadiense").setNSimbolo("CAD"),
            new Moneda().setNMoneda("Franco suizo").setNSimbolo("CHF"),
            new Moneda().setNMoneda("Renminbi/yuan chino").setNSimbolo("CNY"),
            new Moneda().setNMoneda("Dólar de Hong Kong").setNSimbolo("HKD"),
            new Moneda().setNMoneda("Dólar de Nueva Zelanda").setNSimbolo("NZD"),
            new Moneda().setNMoneda("Corona sueca").setNSimbolo("SEK"),
            new Moneda().setNMoneda("Won surcoreano").setNSimbolo("KRW"),
            new Moneda().setNMoneda("Dólar de Singapur").setNSimbolo("SGD"),
            new Moneda().setNMoneda("Corona noruega").setNSimbolo("NOK"),
            new Moneda().setNMoneda("Peso mexicano").setNSimbolo("MXN"),
            new Moneda().setNMoneda("Rupia india").setNSimbolo("INR"),
            new Moneda().setNMoneda("Rublo ruso").setNSimbolo("RUB"),
            new Moneda().setNMoneda("Rand sudafricano").setNSimbolo("ZAR"),
            new Moneda().setNMoneda("Lira turca").setNSimbolo("TRY"),
            new Moneda().setNMoneda("Real brasileño").setNSimbolo("BRL"),
            new Moneda().setNMoneda("Nuevo dólar taiwanés").setNSimbolo("TWD"),
            new Moneda().setNMoneda("Corona danesa").setNSimbolo("DKK"),
            new Moneda().setNMoneda("Złoty polaco").setNSimbolo("PLN"),
            new Moneda().setNMoneda("Baht tailandés").setNSimbolo("THB"),
            new Moneda().setNMoneda("Rupia indonesia").setNSimbolo("IDR"),
            new Moneda().setNMoneda("Florín húngaro").setNSimbolo("HUF"),
            new Moneda().setNMoneda("Corona checa").setNSimbolo("CZK"),
            new Moneda().setNMoneda("Nuevo shekel israelí").setNSimbolo("ILS"),
            new Moneda().setNMoneda("Peso chileno").setNSimbolo("CLP"),
            new Moneda().setNMoneda("Peso filipino").setNSimbolo("PHP"));

    if (monedaRepository.findById(1L).isEmpty()) {
      monedas.forEach(moneda -> monedaRepository.save(moneda));
    }
  }
}
