package com.company;

import java.util.ArrayList;

public class Marca {
    private String nome;
    private String paisDeOrigem;
    private String paisDeProducao;
    public ArrayList<Marca> marca = new ArrayList<>();

    public Marca(String nome, String paisDeOrigem, String paisDeProducao) {
        this.nome = nome;
        this.paisDeOrigem = paisDeOrigem;
        this.paisDeProducao = paisDeProducao;
    }

    public Marca() {}

    public Marca getMarca(int indice) {return marca.get(indice);}

    public boolean compareWithInput(String nome, int indice) {
        return nomeDaMarca(indice).equals(nome.toLowerCase());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPaisDeOrigem() {
        return paisDeOrigem;
    }

    public void setPaisDeOrigem(String paisDeOrigem) {
        this.paisDeOrigem = paisDeOrigem;
    }

    public String getPaisDeProducao() {
        return paisDeProducao;
    }

    public void setPaisDeProducao(String paisDeProducao) {
        this.paisDeProducao = paisDeProducao;
    }

    public String nomeDaMarca(int indice) { return getMarca(indice).getNome();}

    public String paisDeOrigemDaMarca(int indice) { return getMarca(indice).getPaisDeOrigem();}

    public String paisDeProducaoDaMarca(int indice) { return getMarca(indice).paisDeProducaoDaMarca(indice);}


}
