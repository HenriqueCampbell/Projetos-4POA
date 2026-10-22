package com.poa.api_projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poa.api_projeto.model.RegistroClima;
import com.poa.api_projeto.service.RegistroClimaService;

@RestController
@RequestMapping("/api/clima")
public class RegistroClimaController {

    @Autowired
    private RegistroClimaService service;

    // Rota para registrar um novo registro de clima
    @PostMapping
    public RegistroClima adicionarRegistro(@RequestBody RegistroClima registro) {
        return service.registrar(registro);
    }
}