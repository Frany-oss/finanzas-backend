package com.finance.backend.services;

import com.finance.backend.entities.Bonista;
import com.finance.backend.models.BonistaDto;
import com.finance.backend.models.CreateBonistaDto;
import com.finance.backend.models.LoginBonistaDto;
import com.finance.backend.repositories.BonistaRepository;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BonistaService {
    private final BonistaRepository bonistaRepository;
    private final ModelMapper modelMapper;

    public BonistaDto registerBonista(CreateBonistaDto createBonistaDto) throws Exception {
        return Optional.of(
                        bonistaRepository.save(
                                new Bonista()
                                        .setNBonista(createBonistaDto.getNombre())
                                        .setTCorreo(createBonistaDto.getCorreo())
                                        .setTContrasena(createBonistaDto.getContrasena())
                                        .setDCreacion(LocalDateTime.now())
                                        .setFActivo(true)))
                .map(b -> modelMapper.map(b, BonistaDto.class))
                .orElseThrow(() -> new Exception("Error al crear el bonista"));
    }

    public BonistaDto getBonistaByCorreo(String correo) throws Exception {
        return bonistaRepository
                .findByTCorreo(correo)
                .map(b -> modelMapper.map(b, BonistaDto.class))
                .orElseThrow(() -> new Exception("Error al obtener el bonista"));
    }

    public BonistaDto loginBonista(LoginBonistaDto login) throws Exception {
        return Optional.of(
                        bonistaRepository.findByTCorreoAndTContrasena(
                                login.getCorreo(), login.getContrasena()))
                .map(b -> modelMapper.map(b, BonistaDto.class))
                .orElseThrow(() -> new Exception("Credenciales incorrectos"));
    }
}
