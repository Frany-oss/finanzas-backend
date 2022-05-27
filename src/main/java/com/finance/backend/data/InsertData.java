package com.finance.backend.data;

import com.finance.backend.entities.Periodo;
import com.finance.backend.repositories.PeriodoRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InsertData implements ApplicationRunner {
    private final PeriodoRepository periodoRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.insertPeriodos();
    }

    private void insertPeriodos() {
        var periodos =
                List.of(
                        new Periodo().setCPeriodo(0L).setNPeriodo("Diario").setQDias(1),
                        new Periodo().setCPeriodo(1L).setNPeriodo("Quincenal").setQDias(15),
                        new Periodo().setCPeriodo(2L).setNPeriodo("Mensual").setQDias(30),
                        new Periodo().setCPeriodo(3L).setNPeriodo("Bimestral").setQDias(60),
                        new Periodo().setCPeriodo(4L).setNPeriodo("Trimestral").setQDias(90),
                        new Periodo().setCPeriodo(5L).setNPeriodo("Cuatrimestral").setQDias(120),
                        new Periodo().setCPeriodo(6L).setNPeriodo("Semestral").setQDias(180),
                        new Periodo().setCPeriodo(7L).setNPeriodo("Anual").setQDias(360));

        periodos.forEach(
                periodo -> {
                    if (periodoRepository.findByCPeriodo(0L).isEmpty())
                        periodoRepository.save(periodo);
                });
    }
}
