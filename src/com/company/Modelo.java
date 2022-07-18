package com.company;

public class Modelo implements GlobalRepo{
    private String nome;
    private String motorizacao;
    private String tipoDeCombustivel;
    private Marca marca;

    public Modelo(String nome, String motorizacao, String tipoDeCombustivel, Marca marca) {
        this.nome = nome;
        this.motorizacao = motorizacao;
        this.tipoDeCombustivel = tipoDeCombustivel;
        this.marca = marca;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMotorizacao() {
        return motorizacao;
    }

    public void setMotorizacao(String motorizacao) {
        this.motorizacao = motorizacao;
    }

    public String getTipoDeCombustivel() {
        return tipoDeCombustivel;
    }

    public void setTipoDeCombustivel(String tipoDeCombustivel) {
        this.tipoDeCombustivel = tipoDeCombustivel;
    }

}

