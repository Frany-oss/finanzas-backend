package com.finance.backend.controllers;

import com.finance.backend.models.BonistaDto;
import com.finance.backend.models.CreateBonistaDto;
import com.finance.backend.models.LoginBonistaDto;
import com.finance.backend.services.BonistaService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/bonista")
@RequiredArgsConstructor
public class BonistaController {
    private final BonistaService bonistaService;

    @PostMapping("/signup")
    public BonistaDto registerBonista(@RequestBody CreateBonistaDto createBonistaDto)
            throws Exception {
        return bonistaService.registerBonista(createBonistaDto);
    }

    @PostMapping("/login")
    public BonistaDto loginBonista(@RequestBody LoginBonistaDto login) throws Exception {
        return bonistaService.loginBonista(login);
    }
}
