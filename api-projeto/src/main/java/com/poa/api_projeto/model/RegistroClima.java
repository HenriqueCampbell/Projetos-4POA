package com.poa.api_projeto.model;

import jakarta.persistence.*;

@Entity
@Table(name = "registros_clima")
public class RegistroClima {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String cidade;
    private Double temperaturaCelsius;
    private Integer umidadePercentual;
    private String condicao; // Ex: Ensolarado, Chuvoso, Nublado

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public Double getTemperaturaCelsius() { return temperaturaCelsius; }
    public void setTemperaturaCelsius(Double temperaturaCelsius) { this.temperaturaCelsius = temperaturaCelsius; }
    public Integer getUmidadePercentual() { return umidadePercentual; }
    public void setUmidadePercentual(Integer umidadePercentual) { this.umidadePercentual = umidadePercentual; }
    public String getCondicao() { return condicao; }
    public void setCondicao(String condicao) { this.condicao = condicao; }
}