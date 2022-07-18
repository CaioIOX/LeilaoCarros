package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        RepositorioVeiculos veiculosMain = new RepositorioVeiculos();
        RepositorioMarca marcaMain = new RepositorioMarca();
        RepositorioModelo modeloMain = new RepositorioModelo();
        Cadastros cadastro = new Cadastros(veiculosMain, marcaMain, modeloMain);
        int resposta;

        //Menu
        do {
            System.out.println("" +
                "******* Bem vindo ao leilões de automóveis!! *******" +
                "\nDigite o número da opção que deseja realizar:" +
                "\n1 - Cadastro de veículo" +
                "\n2 - Ver lista de veículos" +
                "\n3 - Sair");
            resposta = input.nextInt();

            switch (resposta) {
                case 1 -> {
                    System.out.println("Você deseja cadastrar: " +
                        "\n1 - Marca" +
                        "\n2 - Modelo" +
                        "\n3 - Veiculo");
                    resposta = input.nextInt();
                    switch (resposta) {
                        case 1 -> {
                            cadastro.inserirMarca();
                        }
                        case 2 -> {
                            cadastro.inserirModelo();
                        }
                        default -> cadastro.inserirVeiculos();
                    }
                }
                case 2 -> {
                    veiculosMain.imprimirVeiculos();
                    System.out.println("\nVocê deseja: " +
                        "\n1 - Alterar as informações de algum veículo" +
                        "\n2 - Remover veículo da lista" +
                        "\n3 - Ver todas as informações do veiculo" +
                        "\n4 - Voltar ao menu anterior");
                    int respostaListaVeiculos = input.nextInt();
                    switch (respostaListaVeiculos) {
                        case 1:
                            System.out.println("Digite o ID do veiculo que deseja alterar as informações: ");
                            String editarVeiculo = input.next();
                            veiculosMain.editarVeiculo(editarVeiculo);
                            cadastro.inserirVeiculos();
                            System.out.println("Veículo alterado com sucesso!");
                            break;
                        case 2:
                            System.out.println("Qual veículo deseja remover?");
                            String removerVeiculo = input.next();
                            veiculosMain.removerVeiculo(removerVeiculo);
                            System.out.println("Veículo removido com sucesso!");
                            break;
                        case 3:
                            System.out.println("Digite o id do veículo que deseja buscar:");
                            String buscaVeiculo = input.next();
                            veiculosMain.procurarVeiculos(buscaVeiculo);
                        case 4:
                            break;
                    }
                }
            }
        } while (resposta != 3);

        System.out.println("Leilão encerrado. Volte sempre!");
    }
}
