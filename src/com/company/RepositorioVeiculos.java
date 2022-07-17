package com.company;

import java.util.ArrayList;
import java.util.Scanner;

// Repositorio para os veiculos cadastrados
public class RepositorioVeiculos {
    private final ArrayList<Veiculos> veiculos;
    private final int indice;
    private final Scanner input;


    public RepositorioVeiculos() {
        indice = 0;
        veiculos = new ArrayList<>();
        input = new Scanner(System.in);
    }

    public void adicionar(Veiculos v) {
        veiculos.add(v);

    }

    // Metodo para listar todas as informações de um determinado veiculo
    public void procurarVeiculos(String numero) {
        Veiculos temp = null;
        while (indice<veiculos.size()) {
            if (veiculos.get(indice).getId().equals(numero)) {
                temp = veiculos.get(indice);
                System.out.println("Veículo: " + indice);
                System.out.println("Marca: " + veiculos.get(indice).getMarca()
                    + " Modelo: " + veiculos.get(indice).getModelo());
                System.out.println("ID: " + veiculos.get(indice).getId()
                    + " Cor: " + veiculos.get(indice).getCor());
                System.out.println("Ano: " + veiculos.get(indice).getAno()
                    + " Quilometragem: " + veiculos.get(indice).getQuilometragem()
                    + " Km rodados");
                System.out.println("Valor da divida: R$ " + veiculos.get(indice).getValorDivida()
                    + " Lance Mínimo: R$ " + veiculos.get(indice).getLanceMinimo() + "");
                System.out.println("Estado de conservação: " + veiculos.get(indice).getDescricao());
                System.out.println();
                break;
            }
        }
        if (temp == null) {
            System.out.println("Veículo não encontrado!");
        }
    }

    // metodo para alterar as informações de um veiculos
    public void alterarVeiculo(String numero) {
        while (indice < veiculos.size()) {
            if (veiculos.get(indice).getId().equals(numero)) {
                System.out.println("O que deseja alterar?" +
                    "\n1 - Marca" +
                    "\n2 - Modelo" +
                    "\n3 - Cor" +
                    "\n4 - Ano" +
                    "\n5 - Quilometragem" +
                    "\n6 - Km rodados" +
                    "\n7 - Valor da divida" +
                    "\n8 - Lance mínimo" +
                    "\n9 - Estado de econservação");
                int resposta = input.nextInt();
                switch (resposta) {
                    case 1 -> {
                        System.out.println("Digite uma nova entrada para a Marca:");

                     //   veiculos.get(indice);
                    }
                    case 2 -> {
                        System.out.println();

                    }
                    case 3 -> {
                        System.out.println();

                    }
                    case 4 -> {
                        System.out.println();

                    }
                    case 5 -> {
                        System.out.println();

                    }
                    case 6 -> {
                        System.out.println();

                    }
                    case 7 -> {
                        System.out.println();

                    }
                    case 8 -> {
                        System.out.println();

                    }
                    case 9 -> {
                        System.out.println();

                    }

                }
              //  veiculos.get(indice)

            }
        }
    }

    // metodo para remover algum veiculo já cadastrado
    public void removerVeiculo(String numero) {
        while (indice < veiculos.size()) {
            if (veiculos.get(indice).getId().equals(numero)) {
                veiculos.remove(indice);
            }
        }
    }

    // metodo para listar todos os veiculos cadastrados
    public void imprimirVeiculos() {
        while (indice < veiculos.size()) {
            System.out.println("##########");
            System.out.println("Veículo: " + (indice + 1));
            System.out.println("Marca: " + veiculos.get(indice).getMarca()
                + " Modelo: " + veiculos.get(indice).getModelo());
            System.out.println("ID: " + veiculos.get(indice).getId());
            System.out.println("Valor da divida: R$ " + veiculos.get(indice).getValorDivida()
                + " Lance Mínimo: R$ " + veiculos.get(indice).getLanceMinimo() + "\n");
        }
    }

}
