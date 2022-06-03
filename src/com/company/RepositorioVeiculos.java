package com.company;

public class RepositorioVeiculos {
    private final static int MAX = 100;
    private final Veiculos[] veiculos;
    private int indice;

    public RepositorioVeiculos() {
        indice = 0;
        veiculos = new Veiculos[MAX];
    }

    public void adicionar(Veiculos v) {
        veiculos[indice] = v;
        indice++;
    }

    private Veiculos procurarVeiculos(String numero) {
        Veiculos temp = null;
        for (int i = 0; i < indice; i++) {
            if (veiculos[i].getId().equals(numero)) {
                temp = veiculos[i];
                break;
            }
        }
        if (temp == null) {
            System.out.println("Veículo não encontrado!");
        }
        return temp;
    }

    public void alterarVeiculo(String numero) {
        for (int i = 0; i < indice; i++) {
            if (veiculos[i].getId().equals(numero)) {
                veiculos[i] = veiculos[indice - 1];
                veiculos[indice - 1] = null;
                indice--;
            }
        }
    }
    public void removerVeiculo(String numero) {
        for (int i = 0; i < indice; i++) {
            if (veiculos[i].getId().equals(numero)) {
                veiculos[i] = veiculos[indice - 1];
                veiculos[indice - 1] = null;
                indice--;
            }
        }
    }

    public void imprimirVeiculos() {
        for (int i = 0; i < indice; i++) {
            System.out.println("##########");
            System.out.println("Veículo: " + i);
            System.out.println("Marca: " + veiculos[i].getMarca() + " Modelo: " + veiculos[i].getModelo());
            System.out.println("ID: " + veiculos[i].getId()
                + " Cor: " + veiculos[i].getCor());
            System.out.println("Ano: " + veiculos[i].getAno()
                + " Quilometragem: " + veiculos[i].getQuilometragem());
            System.out.println("Valor da divida: " + veiculos[i].getValorDivida()
                + " Lance Mínimo: " + veiculos[i].getLanceMinimo() + "");
            System.out.println("Estado de conservação: " + veiculos[i].getDescricao());
        }
    }

}
