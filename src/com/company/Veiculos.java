package com.company;

public class Veiculos extends AbstractPagamentos {
    private String cor;
    private String id;
    private int ano;
    private int quilometragem;
    private double valorDivida;
    private double lanceMinimo;
    private String descricao;
    private Marca marca;
    private Modelo modelo;

    public Veiculos(
        String cor,
        String id,
        int ano,
        int quilometragem,
        double valorDivida,
        double lanceMinimo,
        String descricao) {

        this.cor = cor;
        this.id = id;
        this.ano = ano;
        this.quilometragem = quilometragem;
        this.valorDivida = valorDivida;
        this.lanceMinimo = lanceMinimo;
        this.descricao = descricao;

    }

    public String getMarca() {
        return marca.getNome()
            + "\nPais de origem: " + marca.getPaisDeOrigem()
            + "\nPais de produção: " + marca.getPaisDeProducao();
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo.getNome()
            + "\nMotorização: " + modelo.getMotorizacao()
            + "\nTipo de combustivel: " + modelo.getTipoDeCombustivel();
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

}
