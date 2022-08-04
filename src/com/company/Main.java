package com.company;

import javax.swing.JOptionPane;

public class Main implements GlobalRepo {
    static int resposta;

    public static void main(String[] args) {

        JOptionPane.showMessageDialog
            (null, "******* Bem vindo ao leilão de automóveis!! *******");

        do {
            try {
                resposta = Integer.parseInt(JOptionPane.showInputDialog
                    ("Digite o número da opção que deseja realizar:" +
                        "\n1 - Cadastro de veículo" +
                        "\n2 - Ver lista de veículos" +
                        "\n3 - Sair"));
            } catch (Exception e) {
                resposta = 3;
            }
            switch (resposta) {
                case 1 -> {
                    try {
                        resposta = Integer.parseInt(JOptionPane.showInputDialog(
                            "Você deseja cadastrar:" +
                                "\n1 - Marca" +
                                "\n2 - Modelo" +
                                "\n3 - Veiculo"));
                    } catch (Exception e) {
                        break;
                    }

                    switch (resposta) {
                        case 1 -> cadastro.cadastrarMarca();
                        case 2 -> {
                            if (repositorioDeMarcasGlobal.isEmpty()) {
                                JOptionPane.showMessageDialog
                                    (null, "Primeiro cadastre uma marca!");
                                cadastro.cadastrarMarca();
                            } else cadastro.cadastrarModelo();
                        }
                        default -> {
                            if (repositorioDeMarcasGlobal.isEmpty()) {
                                JOptionPane.showMessageDialog
                                    (null, "Primeiro cadastre uma marca!");
                                cadastro.cadastrarMarca();
                            } else if (repositorioDeModelosGlobal.isEmpty()) {
                                JOptionPane.showMessageDialog
                                    (null, "Primeiro cadaste um modelo!");
                                cadastro.cadastrarModelo();
                            } else cadastro.cadastrarVeiculos();
                            resposta = 0;
                        }
                    }
                }
                case 2 -> listaDeVeiculos();
                case 3 -> {}
                default -> JOptionPane.showMessageDialog(null, "Valor invalido!");
            }

        } while (resposta != 3);

        JOptionPane.showMessageDialog(null, "Leilão encerrado. Volte sempre!");
    }

    public static void listaDeVeiculos() {
        if (repositorioDeVeiculosGlobal.isEmpty()) {
            JOptionPane.showMessageDialog
                (null, "Não há veiculos cadastrados!");

        } else {
            repositorioDeVeiculosGlobal.imprimirVeiculos();
            resposta = 0;
            int respostaListaVeiculos = Integer.parseInt(JOptionPane.showInputDialog(
                "Você deseja:" +
                    "\n1 - Alterar as informações de algum veículo" +
                    "\n2 - Ver lista de Marcas" +
                    "\n3 - Ver lista de Modelos" +
                    "\n4 - Remover veículo da lista" +
                    "\n5 - Ver todas as informações do veiculo" +
                    "\n6 - Comprar um veículo" +
                    "\n7 - Voltar ao menu anterior"));
            switch (respostaListaVeiculos) {
                case 1:
                    String editarVeiculo = JOptionPane.showInputDialog
                        ("Digite o ID do veiculo que deseja alterar as informações: ");
                    repositorioDeVeiculosGlobal.editarVeiculo(editarVeiculo);
                    break;
                case 2:
                    catalogoDeVeiculos.listaDeMarcas();
                    break;
                case 3:
                    catalogoDeVeiculos.listaDeModelos();
                    break;
                case 4:
                    String removerVeiculo = JOptionPane.showInputDialog
                        ("Qual ID do veículo que deseja remover?");
                    repositorioDeVeiculosGlobal.removerVeiculo(removerVeiculo);
                    break;
                case 5:
                    String buscaVeiculo = JOptionPane.showInputDialog
                        ("Digite o id do veículo que deseja buscar:");
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
}
