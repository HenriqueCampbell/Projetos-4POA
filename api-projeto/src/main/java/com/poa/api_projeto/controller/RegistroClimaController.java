package com.poa.api_projeto.controller;

import com.poa.api_projeto.model.RegistroClima;
import com.poa.api_projeto.service.RegistroClimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clima")
public class RegistroClimaController {

    @Autowired
    private RegistroClimaService service;

    // Rota para a estação meteorológica enviar os dados (POST)
    @PostMapping
    public RegistroClima adicionarRegistro(@RequestBody RegistroClima registro) {
        return service.registrar(registro);
    }
}