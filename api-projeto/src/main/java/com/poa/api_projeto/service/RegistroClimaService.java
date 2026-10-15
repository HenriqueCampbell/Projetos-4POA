package com.poa.api_projeto.service;

import com.poa.api_projeto.model.RegistroClima;
import com.poa.api_projeto.repository.RegistroClimaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroClimaService {

    @Autowired
    private RegistroClimaRepository repository;

    public RegistroClima registrar(RegistroClima novoRegistro) {
        // Temperaturas no intervalo de -90ºC a 60ºC)
        if (novoRegistro.getTemperaturaCelsius() < -90.0 || novoRegistro.getTemperaturaCelsius() > 60.0) {
            throw new IllegalArgumentException("Erro no sensor: Temperatura fora da realidade terrestre!");
        }
        
        // Umidade tem que ser entre 0 e 100%
        if (novoRegistro.getUmidadePercentual() < 0 || novoRegistro.getUmidadePercentual() > 100) {
            throw new IllegalArgumentException("Umidade deve ser entre 0% e 100%.");
        }
        
        return repository.save(novoRegistro);
    }
}