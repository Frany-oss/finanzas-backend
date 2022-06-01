package com.finance.backend.services;

import com.finance.backend.entities.Bonista;
import com.finance.backend.models.BonistaDto;
import com.finance.backend.models.CreateBonistaDto;
import com.finance.backend.models.LoginBonistaDto;
import com.finance.backend.repositories.BonistaRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BonistaService {
  private final BonistaRepository bonistaRepository;
  private final ModelMapper modelMapper;

  public BonistaDto registerBonista(CreateBonistaDto createBonistaDto) throws Exception {
    return bonistaRepository.findByCorreo(createBonistaDto.getTCorreo()).isPresent()
        ? (BonistaDto)
            Optional.ofNullable(null)
                .orElseThrow(() -> new Exception("Correo ya registrado por otro huevón"))
        : Optional.of(
                bonistaRepository.save(
                    new Bonista()
                        .setNBonista(createBonistaDto.getNBonista())
                        .setTCorreo(createBonistaDto.getTCorreo())
                        .setTContrasena(createBonistaDto.getTContrasena())
                        .setDCreacion(LocalDateTime.now())
                        .setFActivo(true)))
            .map(b -> modelMapper.map(b, BonistaDto.class))
            .orElseThrow(() -> new Exception("Error al crear el bonista"));
  }

  public BonistaDto getBonistaByCorreo(String correo) throws Exception {
    return bonistaRepository
        .findByCorreo(TCorreo)
        .map(b -> modelMapper.map(b, BonistaDto.class))
        .orElseThrow(() -> new Exception("Error al obtener el bonista"));
  }

  public BonistaDto loginBonista(LoginBonistaDto login) throws Exception {
    return Optional.of(
            bonistaRepository.findByCorreoAndContrasena(login.getTCorreo(), login.getTContrasena()))
        .map(b -> modelMapper.map(b, BonistaDto.class))
        .orElseThrow(() -> new Exception("Credenciales incorrectos"));
  }
}
