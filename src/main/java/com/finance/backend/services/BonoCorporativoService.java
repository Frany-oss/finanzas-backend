package com.finance.backend.services;

import java.util.Optional;

import java.util.Optional;

import com.finance.backend.entities.Bonista;
import com.finance.backend.entities.BonoCorporativo;
import com.finance.backend.models.BonoCorporativoDto;
import com.finance.backend.models.CreateBonoCorporativoDto;
import com.finance.backend.repositories.BonistaRepository;
import com.finance.backend.repositories.BonoCorporativoRepository;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BonoCorporativoService {
	private final BonoCorporativoRepository bonoCorporativoRepository;
    private final BonistaRepository bonistaRepository;
    private final ModelMapper modelMapper;

    public Optional<BonoCorporativo> CreateBonoCorporativo(CreateBonoCorporativoDto  createBonoCorporativoDto) throws Exception {
        Bonista bonista = bonistaRepository.findById(createBonoCorporativoDto.getCBonista()).orElseThrow(() -> new Exception("Error al obtener bonista"));
        return Optional.of(
            bonoCorporativoRepository.save(
                new BonoCorporativo()
                            .setBonista(bonista)
                            .setDEmision(createBonoCorporativoDto.getDEmision())
                            .setMValorComercial(createBonoCorporativoDto.getMValorComercial())
                            .setMValorNominal(createBonoCorporativoDto.getMValorNominal())
                            .setNCalculoBono(createBonoCorporativoDto.getNCalculoBono())
                            .setPerCavali(createBonoCorporativoDto.getPerCavali())
                            .setPerColocacion(createBonoCorporativoDto.getPerColocacion())
                            .setPerEstructuracion(createBonoCorporativoDto.getPerEstructuracion())
                            .setPerFlotacion(createBonoCorporativoDto.getPerFlotacion())
                            .setPerTasaAnualDescuento(createBonoCorporativoDto.getPerTasaAnualDescuento())
                            ));
    }
}
