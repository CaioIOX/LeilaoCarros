package com.company;

import javax.swing.JOptionPane;

public class RepositorioVeiculos extends Veiculos implements GlobalRepo {

    Modelo modeloEscolhido;

    public void adicionarVeiculo(Veiculos v) {
        veiculos.add(v);
    }

    public void procurarVeiculos(String id) {
        for (int indice = 0; indice < veiculos.size(); indice++) {
            if (compareWithInput(id, indice)) {
                JOptionPane.showInputDialog("Veículo: " + indice +
                    "\nID: " + idDoVeiculo(indice) +
                    repositorioDeMarcasGlobal.nomeDaMarca(indice) + " " +
                    repositorioDeModelosGlobal.nomeDoModelo(indice) + " Cor: " + corDoVeiculo(indice) +
                    "\nAno: " + anoDoVeiculo(indice) +
                    " Quilometragem: " + quilometragemDoVeiculo(indice) +
                    " Km rodados" +
                    "\nPaís de fabricação: " + repositorioDeMarcasGlobal.paisDeOrigemDaMarca(indice) +
                    " País de produção: " + repositorioDeMarcasGlobal.paisDeProducaoDaMarca(indice) +
                    "\nMotor: " + repositorioDeModelosGlobal.motorizacaoDoModelo(indice) +
                    " Tipos de combustivel: " + repositorioDeModelosGlobal.tipoDeCombustivelDoModelo(indice) +
                    "\nValor da divida: R$ " + dividaDoVeiculo(indice)
                    + " Lance Mínimo: R$ " + lanceMinimoDoVeiculo(indice) +
                    "\nEstado de conservação: " + descricaoDoVeiculo(indice));
                break;
            } else JOptionPane.showInputDialog("Veículo não encontrado!");
        }

    }

    public void editarVeiculo(String id) {
        for (int indice = 0; indice < veiculos.size(); indice++) {
            try {
                if (compareWithInput(id, indice)) {
                    JOptionPane.showInputDialog(
                        "O que deseja alterar?" +
                            "\n1 - Cor" +
                            "\n2 - Ano" +
                            "\n3 - Quilometragem" +
                            "\n4 - Valor da divida" +
                            "\n5 - Lance mínimo" +
                            "\n6 - Estado de econservação" +
                            "\n7 - Modelo" +
                            "\n8 - Id do veículo");
                    int resposta = input.nextInt();
                    switch (resposta) {
                        case 1 -> {
                            String novaCor = JOptionPane.showInputDialog
                                ("Escolha uma nova cor:").toLowerCase();
                            ;
                            veiculos.get(indice).setCor(novaCor);
                            JOptionPane.showInputDialog("Cor alterada para " + novaCor + " com sucesso!");
                        }
                        case 2 -> {
                            int novoAno = Integer.parseInt(JOptionPane.showInputDialog("Escolha um novo ano:"));
                            veiculos.get(indice).setAno(novoAno);
                            JOptionPane.showInputDialog("Ano alterado para " + novoAno + " com sucesso!");
                        }
                        case 3 -> {
                            int novaKm = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma nova quilometragem:"));
                            veiculos.get(indice).setQuilometragem(novaKm);
                            JOptionPane.showInputDialog("Quilometragem alterada para " + novaKm + "kms rodados com sucesso!");
                        }
                        case 4 -> {
                            double novaDivida = Double.parseDouble(JOptionPane.showInputDialog("Digite um nvoo valor da dívida: "));
                            veiculos.get(indice).setValorDivida(novaDivida);
                            JOptionPane.showInputDialog("Valor da dívida alterada para R$ " + novaDivida + " com sucesso!");
                        }
                        case 5 -> {
                            double novoLance = Double.parseDouble(JOptionPane.showInputDialog("Digite um novo lance mínimo:"));
                            veiculos.get(indice).setLanceMinimo(novoLance);
                            JOptionPane.showInputDialog("Lance mínimo alterado para R$ " + novoLance + " com sucesso!");
                        }
                        case 6 -> {
                            String novaConservacao = JOptionPane.showInputDialog("Digite um novo estado de conservação:").toLowerCase();
                            veiculos.get(indice).setDescricao(novaConservacao);
                            JOptionPane.showInputDialog("Descrição alterada com sucesso!");
                        }
                        case 7 -> {
                            repositorioDeModelosGlobal.imprimirModelo();
                            int modeloId = Integer.parseInt(JOptionPane.showInputDialog("Digite o número correspondente do novo modelo do veículo: "));
                            modeloEscolhido = repositorioDeModelosGlobal.getModelo(modeloId - 1);
                            repositorioDeVeiculosGlobal.getVeiculos(indice).setModelo(modeloEscolhido);
                        }
                        case 8 -> {
                            String novoId = JOptionPane.showInputDialog("Digite um novo id para o veículo: ");
                            veiculos.get(indice).setId(novoId);
                            repositorioDeVeiculosGlobal.getVeiculos(indice).setModelo(modeloEscolhido);
                        }
                        default -> JOptionPane.showInputDialog("Opção não disponivel!");
                    }
                } else JOptionPane.showInputDialog("Veiculo não encontrado!");
            } catch (Exception e) {
                JOptionPane.showInputDialog("Erro: dados invalidos");
            }
        }
    }

    public void removerVeiculo(String id) {
        for (int indice = 0; indice < veiculos.size(); indice++) {
            if (compareWithInput(id, indice)) {
                veiculos.remove(getVeiculos(indice));
                JOptionPane.showInputDialog("Veiculo removido com successo!");
            }

        }

    }

    public void imprimirVeiculos() {
        for (int indice = 0; indice < veiculos.size(); indice++) {
            System.out.println("##########");
            System.out.println("Veículo: " + (indice + 1));
            System.out.println("ID: " + idDoVeiculo(indice));
            System.out.println("Veiculo: " + repositorioDeMarcasGlobal.nomeDaMarca(indice) +
                " " + repositorioDeModelosGlobal.nomeDoModelo(indice));
            System.out.println("Valor da divida: R$ " + dividaDoVeiculo(indice)
                + " Lance Mínimo: R$ " + lanceMinimoDoVeiculo(indice) + "\n");
        }
    }

    public boolean isEmpty() {
        return veiculos.size() == 0;
    }
}
