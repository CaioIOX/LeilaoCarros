package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        RepositorioVeiculos leilao = new RepositorioVeiculos();
        Cadastros cadastro = new Cadastros(leilao);

        //Variaveis para ler input do usuário
        int resposta;
        int respostaListaVeiculos;
        String removerVeiculo;
        String editarVeiculo;
        String buscaVeiculo;

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
                    cadastro.inserirVeiculos();
                    System.out.println("Veiculo cadastrado com sucesso!\n");
                }
                case 2 -> {
                    leilao.imprimirVeiculos();
                    System.out.println("\nVocê deseja: " +
                        "\n1 - Alterar as informações de algum veículo" +
                        "\n2 - Remover veículo da lista" +
                        "\n3 - Ver todas as informações do veiculo" +
                        "\n4 - Voltar ao menu anterior");
                    respostaListaVeiculos = input.nextInt();
                    switch (respostaListaVeiculos) {
                        case 1:
                            System.out.println("Digite o ID do veiculo que deseja alterar as informações: ");
                            editarVeiculo = input.next();
                            leilao.editarVeiculo(editarVeiculo);
                            cadastro.inserirVeiculos();
                            System.out.println("Veículo alterado com sucesso!");
                            break;
                        case 2:
                            System.out.println("Qual veículo deseja remover?");
                            removerVeiculo = input.next();
                            leilao.removerVeiculo(removerVeiculo);
                            System.out.println("Veículo removido com sucesso!");
                            break;
                        case 3:
                            System.out.println("Digite o id do veículo que deseja buscar:");
                            buscaVeiculo = input.next();
                            leilao.procurarVeiculos(buscaVeiculo);
                        case 4:
                            break;
                    }
                }
            }
        } while (resposta != 3);

        System.out.println("Leilão encerrado. Volte sempre!");
    }
}
