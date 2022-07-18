package com.company;

import java.util.ArrayList;
import java.util.Scanner;

// Repositorio para os veiculos cadastrados
public class RepositorioVeiculos {
    private final ArrayList<Veiculos> veiculos;
    private int indice;
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
        while (indice < veiculos.size()) {
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
            indice++;
        }
        if (temp == null) {
            System.out.println("Veículo não encontrado!");
        }
    }

    // metodo para alterar as informações de um veiculos
    public void editarVeiculo(String numero) {
        while (indice < veiculos.size()) {
            if (veiculos.get(indice).getId().equals(numero)) {
                System.out.println("O que deseja alterar?" +
                    "\n1 - Cor" +
                    "\n2 - Ano" +
                    "\n3 - Quilometragem" +
                    "\n4 - Valor da divida" +
                    "\n5 - Lance mínimo" +
                    "\n6 - Estado de econservação");
                int resposta = input.nextInt();
                switch (resposta) {
                    case 1 -> {
                        System.out.println("Escolha uma nova cor:");
                        String novaCor = input.next();
                        veiculos.get(indice).setCor(novaCor);
                        System.out.println("Cor alterada para " + novaCor + " com sucesso!");
                    }
                    case 2 -> {
                        System.out.println("Escolha um novo ano:");
                        int novoAno = input.nextInt();
                        veiculos.get(indice).setAno(novoAno);
                        System.out.println("Ano alterado para " + novoAno + " com sucesso!");
                    }
                    case 3 -> {
                        System.out.println("Escolha uma nova quilometragem:");
                        int novaKm = input.nextInt();
                        veiculos.get(indice).setQuilometragem(novaKm);
                        System.out.println("Quilometragem alterada para " + novaKm + "kms rodados com sucesso!");
                    }
                    case 4 -> {
                        System.out.println("Digite um nvoo valor da dívida: ");
                        double novaDivida = input.nextDouble();
                        veiculos.get(indice).setValorDivida(novaDivida);
                        System.out.println("Valor da dívida alterada para R$ " + novaDivida + " com sucesso!");
                    }
                    case 5 -> {
                        System.out.println("Digite um novo lance mínimo:");
                        double novoLance = input.nextDouble();
                        veiculos.get(indice).setLanceMinimo(novoLance);
                        System.out.println("Lance mínimo alterado para R$ " + novoLance + " com sucesso!");
                    }
                    case 6 -> {
                        System.out.println("Digite um novo estado de conseervação:");
                        String novaConservacao = input.next();
                        veiculos.get(indice).setDescricao(novaConservacao);
                        System.out.println("Descrição alterada com sucesso!");
                    }
                    default -> System.out.println("Opção não disponivel!");
                }
            } else System.out.println("Veiculo não encontrado!");
            indice++;
        }
    }

    // metodo para remover algum veiculo já cadastrado
    public void removerVeiculo(String numero) {
        while (indice < veiculos.size()) {
            if (veiculos.get(indice).getId().equals(numero)) {
                veiculos.remove(indice);
            }
            indice++;
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
            indice++;
        }
    }
}
