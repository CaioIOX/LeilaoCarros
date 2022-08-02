package com.company;

public class CompraDeVeiculos extends AbstractPagamentos implements GlobalRepo{

    public double pagamentoAvista(double lance) {
        lance -= lance * 0.1;
        return lance;
    }

    public void pagamento12x(double lance) {
        entrada = lance * 0.3;
        parcela = (lance - entrada) / 12;
        System.out.println("Para realizar a compra deve-se dar uma entrada de R$ " + entrada
                + " e as parcelas ficarão em R$ " + parcela + " sem juros!");
    }

    public void pagamento24x(double lance) {
        entrada = lance * 0.2;
        parcela = (lance - entrada) / 24;
        System.out.println("Para realizar a compra deve-se dar uma entrada de R$ " + entrada
                + " e as parcelas ficarão em R$ " + parcela + " sem juros!");
    }

    public void compraVeiculos() {
        repositorioDeVeiculosGlobal.imprimirVeiculos();
        System.out.println("Digite o id do veiculo que deseja comprar: ");
        String id = input.next().toLowerCase();

        for (int indice = 0; indice < repositorioDeVeiculosGlobal.veiculos.size(); indice++) {
            if (repositorioDeVeiculosGlobal.compareWithInput(id, indice)) {
                System.out.println("Quanto deseja pagar?");
                double lance = input.nextDouble();
                if (lance < repositorioDeVeiculosGlobal.lanceMinimoDoVeiculo(indice)) {
                    System.out.println("Lance insuficiente!");
                } else {
                    System.out.println(
                        "Qual forma de pagamento deseja utilizar?:" +
                            "\n1 - A vista" +
                            "\n2 - Em 12x sem juros" +
                            "\n3 - Em 24x sem juros" +
                            "\n4 - Desistir da compra");
                    int respostaCompra = input.nextInt();
                    switch (respostaCompra) {
                        case 1 -> {
                            System.out.println("O valor do veiculo será: " + pagamentoAvista(lance));
                            System.out.println("Deseja finalizar a compra? 1 - SIM/2 - NÃO");
                            int compra = input.nextInt();
                            if (compra == 1) {
                                System.out.println("Compra realizada com sucesso!");
                                repositorioDeVeiculosGlobal.removerVeiculo(id);
                            } else System.out.println("Compra cancelada!");

                        }
                        case 2 -> {
                            pagamento12x(lance);
                            System.out.println("Deseja finalizar a compra? 1 - SIM/2 - NÃO");
                            int compra = input.nextInt();
                            if (compra == 1) {
                                System.out.println("Compra realizada com sucesso!");
                                repositorioDeVeiculosGlobal.removerVeiculo(id);
                            } else System.out.println("Compra cancelada!");
                        }
                        case 3 -> {
                            pagamento24x(lance);
                            System.out.println("Deseja finalizar a compra? 1 - SIM/2 - NÃO");
                            int compra = input.nextInt();
                            if (compra == 1) {
                                System.out.println("Compra realizada com sucesso!");
                                repositorioDeVeiculosGlobal.removerVeiculo(id);
                            } else System.out.println("Compra cancelada!");
                        }
                        default -> {
                        }
                    }
                }
            }
        }
    }
}
