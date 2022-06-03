package com.company;

public class Modelo {
    private String nome;
    private String motorizacao;
    private String tipoDeCombustivel;

    public Modelo(String nome, String motorizacao, String tipoDeCombustivel) {
        this.nome = nome;
        this.motorizacao = motorizacao;
        this.tipoDeCombustivel = tipoDeCombustivel;
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

