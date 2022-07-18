package com.company;

public class Main implements GlobalRepo{
    static int resposta;

    public static void main (String[] args) {

        //Menu
        do {
            System.out.println("""
                    ******* Bem vindo ao leilões de automóveis!! *******
                    Digite o número da opção que deseja realizar:
                    1 - Cadastro de veículo
                    2 - Ver lista de veículos
                    3 - Sair""");
            resposta = input.nextInt();

            switch (resposta) {
                case 1 -> {
                    System.out.println("""
                            Você deseja cadastrar:\s
                            1 - Marca
                            2 - Modelo
                            3 - Veiculo""");
                    resposta = input.nextInt();
                    switch (resposta) {
                        case 1 -> cadastro.inserirMarca();
                        case 2 -> cadastro.inserirModelo();
                        default -> {
                            if (marcaMain.isEmpty()) {
                                System.out.println("Primeiro cadastre uma marca!");
                                cadastro.inserirMarca();
                            } else if (modeloMain.isEmpty()) {
                                System.out.println("Primeiro cadaste um modelo!");
                                cadastro.inserirModelo();
                            } else cadastro.inserirVeiculos();
                            resposta = 0;
                        }
                    }
                }
                case 2 -> {
                    if (veiculosMain.isEmpty()) {
                        System.out.println("Não há veiculos cadastrados!");
                        break;
                    }
                    veiculosMain.imprimirVeiculos();
                    System.out.println("""

                            Você deseja:\s
                            1 - Alterar as informações de algum veículo
                            2 - Remover veículo da lista
                            3 - Ver todas as informações do veiculo
                            4 - Voltar ao menu anterior""");
                    int respostaListaVeiculos = input.nextInt();
                    switch (respostaListaVeiculos) {
                        case 1:
                            System.out.println("Digite o ID do veiculo que deseja alterar as informações: ");
                            String editarVeiculo = input.next();
                            veiculosMain.editarVeiculo(editarVeiculo);
                            break;
                        case 2:
                            System.out.println("Qual ID do veículo que deseja remover?");
                            String removerVeiculo = input.next();
                            veiculosMain.removerVeiculo(removerVeiculo);
                            break;
                        case 3:
                            System.out.println("Digite o id do veículo que deseja buscar:");
                            String buscaVeiculo = input.next();
                            veiculosMain.procurarVeiculos(buscaVeiculo);
                            break;
                        case 4:
                            break;
                    }
                }
            }
        } while (resposta != 3);

        System.out.println("Leilão encerrado. Volte sempre!");
    }
}
