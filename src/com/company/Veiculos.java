package com.company;

import java.util.ArrayList;

public class Veiculos implements GlobalRepo{
    private String cor;
    private String id;
    private int ano;
    private int quilometragem;
    private double valorDivida;
    private double lanceMinimo;
    private String descricao;
    private Modelo modelo;
    public ArrayList<Veiculos> veiculos = new ArrayList<>();

    public Veiculos(
        String cor,
        String id,
        int ano,
        int quilometragem,
        double valorDivida,
        double lanceMinimo,
        String descricao,
        Modelo modelo) {

        this.cor = cor;
        this.id = id;
        this.ano = ano;
        this.quilometragem = quilometragem;
        this.valorDivida = valorDivida;
        this.lanceMinimo = lanceMinimo;
        this.descricao = descricao;
        this.modelo = modelo;

    }

    public Veiculos() {}

    public Veiculos getVeiculos(int indice) {return veiculos.get(indice);}

    public boolean compareWithInput(String id, int indice) {
        return idDoVeiculo(indice).equals(id.toLowerCase());
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public double getValorDivida() {
        return valorDivida;
    }

    public void setValorDivida(double valorDivida) {
        this.valorDivida = valorDivida;
    }

    public double getLanceMinimo() {
        return lanceMinimo;
    }

    public void setLanceMinimo(double lanceMinimo) {
        this.lanceMinimo = lanceMinimo;
    }

    public String idDoVeiculo(int indice) { return getVeiculos(indice).getId();}

    public String corDoVeiculo(int indice) { return getVeiculos(indice).getCor();}

    public String descricaoDoVeiculo(int indice) { return getVeiculos(indice).getDescricao();}

    public int anoDoVeiculo(int indice) { return getVeiculos(indice).getAno();}

    public int quilometragemDoVeiculo(int indice) { return getVeiculos(indice).getQuilometragem();}

    public double dividaDoVeiculo(int indice) { return getVeiculos(indice).getValorDivida();}

    public double lanceMinimoDoVeiculo(int indice) { return getVeiculos(indice).getLanceMinimo();}



}
