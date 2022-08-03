package com.company;

import java.util.ArrayList;

public class Modelo implements GlobalRepo{
    private String nome;
    private String motorizacao;
    private String tipoDeCombustivel;
    private Marca marca;
    public ArrayList<Modelo> modelo = new ArrayList<>();

    public Modelo(String nome, String motorizacao, String tipoDeCombustivel, Marca marca) {
        this.nome = nome;
        this.motorizacao = motorizacao;
        this.tipoDeCombustivel = tipoDeCombustivel;
        this.marca = marca;
    }
    public Modelo() {}


    public Modelo getModelo(int indice) {return modelo.get(indice);}

    public boolean compareWithInput(String nome, int indice) {
        return nomeDoModelo(indice).equals(nome.toLowerCase());
    }

    public String getNome() {return nome;}

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

    public String nomeDoModelo(int indice) { return getModelo(indice).getNome();}

    public String motorizacaoDoModelo(int indice) { return getModelo(indice).getMotorizacao();}

    public String tipoDeCombustivelDoModelo(int indice) { return getModelo(indice).getTipoDeCombustivel();}

}

