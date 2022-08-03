package com.company;

public class Main implements GlobalRepo {
    static int resposta;

    public static void main(String[] args) {

        //Menu
        do {
            System.out.println(
                   "******* Bem vindo ao leilões de automóveis!! *******" +
                   "\nDigite o número da opção que deseja realizar:" +
                   "\n1 - Cadastro de veículo" +
                   "\n2 - Ver lista de veículos" +
                   "\n3 - Sair");
            resposta = input.nextInt();

            switch (resposta) {
                case 1 -> {
                    System.out.println(
                            "Você deseja cadastrar:" +
                            "\n1 - Marca" +
                            "\n2 - Modelo" +
                            "\n3 - Veiculo");
                    resposta = input.nextInt();
                    switch (resposta) {
                        case 1 -> {

                                cadastro.cadastrarMarca();

                        }
                        case 2 -> {
                            if (repositorioDeMarcasGlobal.isEmpty()) {
                                System.out.println("Primeiro cadastre uma marca!");
                                cadastro.cadastrarMarca();
                            } else cadastro.cadastrarModelo();
                        }
                        default -> {
                            if (repositorioDeMarcasGlobal.isEmpty()) {
                                System.out.println("Primeiro cadastre uma marca!");
                                cadastro.cadastrarMarca();
                            } else if (repositorioDeModelosGlobal.isEmpty()) {
                                System.out.println("Primeiro cadaste um modelo!");
                                cadastro.cadastrarModelo();
                            } else cadastro.cadastrarVeiculos();
                            resposta = 0;
                        }
                    }
                }
                case 2 -> {
                    if (repositorioDeVeiculosGlobal.isEmpty()) {
                        System.out.println("Não há veiculos cadastrados!");
                        break;
                    }
                    repositorioDeVeiculosGlobal.imprimirVeiculos();
                    System.out.println(
                            "Você deseja:" +
                            "\n1 - Alterar as informações de algum veículo" +
                            "\n2 - Alterar as informações de alguma marca" +
                            "\n3 - Alterar as informaões de algum modelo" +
                            "\n4 - Remover veículo da lista" +
                            "\n5 - Ver todas as informações do veiculo" +
                            "\n6 - Comprar um veículo" +
                            "\n7 - Voltar ao menu anterior");
                    int respostaListaVeiculos = input.nextInt();
                    switch (respostaListaVeiculos) {
                        case 1:
                            System.out.println("Digite o ID do veiculo que deseja alterar as informações: ");
                            String editarVeiculo = input.next();
                            repositorioDeVeiculosGlobal.editarVeiculo(editarVeiculo);
                            break;
                        case 2:
                            System.out.println("Digite o nome da marca que deseja alterar as informações");
                            String editarMarca = input.next();
                            repositorioDeMarcasGlobal.editarMarca(editarMarca);
                            break;
                        case 3:
                            System.out.println("Digite o nome do modelo que deseja alterar as informações");
                            String editarModelo = input.next();
                            repositorioDeModelosGlobal.editarModelo(editarModelo);
                        case 4:
                            System.out.println("Qual ID do veículo que deseja remover?");
                            String removerVeiculo = input.next();
                            repositorioDeVeiculosGlobal.removerVeiculo(removerVeiculo);
                            break;
                        case 5:
                            System.out.println("Digite o id do veículo que deseja buscar:");
                            String buscaVeiculo = input.next();
                            repositorioDeVeiculosGlobal.procurarVeiculos(buscaVeiculo);
                            break;
                        case 6:
                            repositorioDeVeiculosGlobal.compraVeiculos.compraVeiculos();
                            break;
                        case 7:
                            break;
                    }
                }
            }
        } while (resposta != 3);

        System.out.println("Leilão encerrado. Volte sempre!");
    }
}
