package com.company;

import javax.swing.JOptionPane;

public class Main implements GlobalRepo {
    static int resposta;

    public static void main(String[] args) {

        JOptionPane.showMessageDialog
            (null, "******* Bem vindo ao leilão de automóveis!! *******");

        do {
            resposta = Integer.parseInt(JOptionPane.showInputDialog
                ("Digite o número da opção que deseja realizar:" +
                    "\n1 - Cadastro de veículo" +
                    "\n2 - Ver lista de veículos" +
                    "\n3 - Sair"));
            switch (resposta) {
                case 1 -> {
                    resposta = Integer.parseInt(JOptionPane.showInputDialog(
                        "Você deseja cadastrar:" +
                            "\n1 - Marca" +
                            "\n2 - Modelo" +
                            "\n3 - Veiculo"));

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
                case 2 -> {
                    if (repositorioDeVeiculosGlobal.isEmpty()) {
                        JOptionPane.showMessageDialog
                            (null, "Não há veiculos cadastrados!");
                        break;
                    }
                    repositorioDeVeiculosGlobal.imprimirVeiculos();
                    resposta = Integer.parseInt(JOptionPane.showInputDialog(
                        "Você deseja:" +
                            "\n1 - Alterar as informações de algum veículo" +
                            "\n2 - Alterar as informações de alguma marca" +
                            "\n3 - Alterar as informaões de algum modelo" +
                            "\n4 - Remover veículo da lista" +
                            "\n5 - Ver todas as informações do veiculo" +
                            "\n6 - Comprar um veículo" +
                            "\n7 - Voltar ao menu anterior"));
                    int respostaListaVeiculos = input.nextInt();
                    switch (respostaListaVeiculos) {
                        case 1:
                            String editarVeiculo = JOptionPane.showInputDialog
                                ("Digite o ID do veiculo que deseja alterar as informações: ");
                            repositorioDeVeiculosGlobal.editarVeiculo(editarVeiculo);
                            break;
                        case 2:
                            String editarMarca = JOptionPane.showInputDialog
                                ("Digite o nome da marca que deseja alterar as informações");
                            repositorioDeMarcasGlobal.editarMarca(editarMarca);
                            break;
                        case 3:
                            String editarModelo = JOptionPane.showInputDialog
                                ("Digite o nome do modelo que deseja alterar as informações");
                            repositorioDeModelosGlobal.editarModelo(editarModelo);
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

        } while (resposta != 3);

        //JOptionPane.showMessageDialog(null, "Leilão encerrado. Volte sempre!");
    }
}
