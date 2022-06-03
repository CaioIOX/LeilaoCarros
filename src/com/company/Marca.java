package com.company;

public class Marca {
    private String nome;
    private String paisDeOrigem;
    private String paisDeProducao;

    public Marca(String nome, String paisDeOrigem, String paisDeProducao) {
        this.nome = nome;
        this.paisDeOrigem = paisDeOrigem;
        this.paisDeProducao = paisDeProducao;
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


}
