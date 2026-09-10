package com.crud.model;

public class Cupom {
    private int id;
    private String codigo;
    private double valorDesconto;
    private int quantidadeUsos;

    public Cupom(String codigo, double valorDesconto, int quantidadeUsos) {
        this.codigo = codigo;
        this.valorDesconto = valorDesconto;
        this.quantidadeUsos = quantidadeUsos;
    }

    // Getters
    public int getId() { return id; }
    public String getCodigo() { return codigo; }
    public double getValorDesconto() { return valorDesconto; }
    public int getQuantidadeUsos() { return quantidadeUsos; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public void setValorDesconto(double valorDesconto) { this.valorDesconto = valorDesconto; }
    public void setQuantidadeUsos(int quantidadeUsos) { this.quantidadeUsos = quantidadeUsos; }
}