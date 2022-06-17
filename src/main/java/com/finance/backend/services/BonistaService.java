package com.finance.backend.services;

import com.finance.backend.entities.Bonista;
import com.finance.backend.models.BonistaDto;
import com.finance.backend.models.CreateBonistaDto;
import com.finance.backend.models.LoginBonistaDto;
import com.finance.backend.models.UpdateBonistaDto;
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
    return bonistaRepository.findByCorreo(createBonistaDto.getCorreo()).isPresent()
        ? (BonistaDto)
            Optional.ofNullable(null)
                .orElseThrow(() -> new Exception("Correo ya registrado"))
        : Optional.of(
                bonistaRepository.save(
                    new Bonista()
                        .setNombre(createBonistaDto.getNombre())
                        .setTelefono(createBonistaDto.getTelefono())
                        .setCorreo(createBonistaDto.getCorreo())
                        .setContrasena(createBonistaDto.getContrasena())
                        .setFechaCreacion(LocalDateTime.now())
                        .setActivo(true)))
            .map(b -> modelMapper.map(b, BonistaDto.class))
            .orElseThrow(() -> new Exception("Error al crear el bonista"));
  }

  public BonistaDto getBonistaByCorreo(String correo) throws Exception {
    return bonistaRepository
        .findByCorreo(correo)
        .map(b -> modelMapper.map(b, BonistaDto.class))
        .orElseThrow(() -> new Exception("Error al obtener el bonista"));
  }

  public BonistaDto loginBonista(LoginBonistaDto login) throws Exception {
    return Optional.of(
            bonistaRepository.findByCorreoAndContrasena(login.getCorreo(), login.getContrasena()))
        .map(b -> modelMapper.map(b, BonistaDto.class))
        .orElseThrow(() -> new Exception("Credenciales incorrectos"));
  }

  public BonistaDto updateBonista(UpdateBonistaDto updateBonistaDto) throws Exception {
    return bonistaRepository.findByCorreo(updateBonistaDto.getCorreo()).isPresent()
        ? (BonistaDto)
            Optional.ofNullable(null)
                .orElseThrow(() -> new Exception("Correo ya registrado"))
        : bonistaRepository
        .findById(updateBonistaDto.getBonistaId())
        .map(
            b -> {
              b.setNombre(updateBonistaDto.getNombre());
              b.setTelefono(updateBonistaDto.getTelefono());
              b.setCorreo(updateBonistaDto.getCorreo());
              b.setContrasena(updateBonistaDto.getContrasena());
              return bonistaRepository.save(b);
            })
        .map(b -> modelMapper.map(b, BonistaDto.class))
        .orElseThrow(() -> new Exception("Error al actualizar el bonista"));
  }
}
