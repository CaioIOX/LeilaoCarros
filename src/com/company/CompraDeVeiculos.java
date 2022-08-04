package com.company;

import javax.swing.JOptionPane;

public class CompraDeVeiculos extends AbstractPagamentos implements GlobalRepo{

    public double pagamentoAvista(double lance) {
        lance -= lance * 0.1;
        return lance;
    }

    public void pagamento12x(double lance) {
        entrada = lance * 0.3;
        parcela = (lance - entrada) / 12;
        JOptionPane.showMessageDialog(null,
            "Para realizar a compra deve-se dar uma entrada de R$ " + entrada
                + " e as parcelas ficarão em R$ " + parcela + " sem juros!");
    }

    public void pagamento24x(double lance) {
        entrada = lance * 0.2;
        parcela = (lance - entrada) / 24;
        JOptionPane.showMessageDialog(null,
            "Para realizar a compra deve-se dar uma entrada de R$ " + entrada
                + " e as parcelas ficarão em R$ " + parcela + " sem juros!");
    }

    public void compraVeiculos() {
        repositorioDeVeiculosGlobal.imprimirVeiculos();
        String id = JOptionPane.showInputDialog
            ("Digite o id do veiculo que deseja comprar: ").toLowerCase();
        for (int indice = 0; indice < repositorioDeVeiculosGlobal.veiculos.size(); indice++) {
            if (repositorioDeVeiculosGlobal.compareWithInput(id, indice)) {
                double lance = Double.parseDouble(JOptionPane.showInputDialog("Quanto deseja pagar?"));
                if (lance < repositorioDeVeiculosGlobal.lanceMinimoDoVeiculo(indice)) {
                    JOptionPane.showMessageDialog(null, "Lance insuficiente!");
                } else {
                    int respostaCompra = Integer.parseInt(JOptionPane.showInputDialog(
                        "Qual forma de pagamento deseja utilizar?:" +
                            "\n1 - A vista" +
                            "\n2 - Em 12x sem juros" +
                            "\n3 - Em 24x sem juros" +
                            "\n4 - Desistir da compra"));
                    switch (respostaCompra) {
                        case 1 -> {
                            JOptionPane.showMessageDialog
                                (null, "O valor do veiculo será: " + pagamentoAvista(lance));
                            int compra = Integer.parseInt(JOptionPane.showInputDialog
                                ("Deseja finalizar a compra? 1 - SIM/2 - NÃO"));
                            if (compra == 1) {
                                JOptionPane.showMessageDialog
                                    (null, "Compra realizada com sucesso!");
                                repositorioDeVeiculosGlobal.removerVeiculo(id);
                            } else JOptionPane.showMessageDialog
                                (null, "Compra cancelada!");

                        }
                        case 2 -> {
                            pagamento12x(lance);
                            int compra = Integer.parseInt(JOptionPane.showInputDialog
                                ("Deseja finalizar a compra? 1 - SIM/2 - NÃO"));
                            if (compra == 1) {
                                JOptionPane.showMessageDialog
                                    (null, "Compra realizada com sucesso!");
                                repositorioDeVeiculosGlobal.removerVeiculo(id);
                            } else JOptionPane.showMessageDialog
                                (null,"Compra cancelada!");
                        }
                        case 3 -> {
                            pagamento24x(lance);
                            int compra = Integer.parseInt(JOptionPane.showInputDialog
                                ("Deseja finalizar a compra? 1 - SIM/2 - NÃO"));
                            if (compra == 1) {
                                JOptionPane.showMessageDialog
                                    (null, "Compra realizada com sucesso!");
                                repositorioDeVeiculosGlobal.removerVeiculo(id);
                            } else JOptionPane.showMessageDialog
                                (null,"Compra cancelada!");
                        }
                        default -> {
                        }
                    }
                }
            }
        }
    }
}
