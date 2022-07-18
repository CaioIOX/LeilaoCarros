package com.company;

import java.util.ArrayList;

public class RepositorioModelo implements GlobalRepo {
    private final ArrayList<Modelo> modelo;

    public RepositorioModelo() {
        modelo = new ArrayList<>();
    }

    public ArrayList<Modelo> getModelo() {
        return modelo;
    }

    public void adicionar(Modelo m) {
        modelo.add(m);
    }

    public void procurarModelo(String nome) {
        Modelo temp = null;
        for (int indice = 0; indice < modelo.size(); indice++) {
            if (modelo.get(indice).getNome().equals(nome.toLowerCase())) {
                temp = modelo.get(indice);
                System.out.println("Modelo: " + modelo.get(indice).getNome());
                System.out.println("Motorização: " + modelo.get(indice).getMotorizacao());
                System.out.println("Tipo de combustivel: " + modelo.get(indice).getTipoDeCombustivel());
                System.out.println();
                break;
            }
        }
        if (temp == null) {
            System.out.println("Modelo não encontrado!");
        }
    }

    public void editarModelo(String nome) {
        for (int indice = 0; indice < modelo.size(); indice++) {
            if (modelo.get(indice).getNome().equals(nome.toLowerCase())) {
                System.out.println(
                        "O que deseja alterar?" +
                        "\n1 - Nome do modelo" +
                        "\n2 - Motorização" +
                        "\n3 - Tipo de gasolina");
                int respostaAlterar = input.nextInt();
                switch (respostaAlterar) {
                    case 1 -> {
                        System.out.println("Digite um novo nome para o modelo: ");
                        String respostaNome = input.next();
                        modelo.get(indice).setNome(respostaNome);
                    }
                    case 2 -> {
                        System.out.println("Digite uma nova motorização: ");
                        String respostaMotorizacao = input.next();
                        modelo.get(indice).setMotorizacao(respostaMotorizacao);
                    }
                    case 3 -> {
                        System.out.println("Digite um novo tipo de combustivel: ");
                        String respostaTipoDeCombustivel = input.next();
                        modelo.get(indice).setTipoDeCombustivel(respostaTipoDeCombustivel);
                    }
                    default -> System.out.println("Modelo não encontrado!");
                }
            }
        }
    }

    public void removerModelo(String nome) {
        for (int indice = 0; indice < modelo.size(); indice++) {
            if (modelo.get(indice).getNome().equals(nome.toLowerCase())) {
                modelo.remove(indice);
            }
        }
    }

    public void imprimirModelo() {
        for (int indice = 0; indice < modelo.size(); indice++) {
            System.out.println("#" + (indice+1) + " - " + modelo.get(indice).getNome());
        }
    }

    public boolean isEmpty() {

        return modelo.size() == 0;
    }
}
