package com.company;

public class CompraDeVeiculos extends RepositorioVeiculos implements GlobalRepo{

    public void compraVeiculos() {
        imprimirVeiculos();
        System.out.println("Digite o id do veiculo que deseja comprar: ");
        String id = input.next().toLowerCase();

        for (int indice = 0; indice < veiculos.size(); indice++) {
            if (compareWithInput(id, indice)) {
                System.out.println("Quanto deseja pagar?");
                double lance = input.nextDouble();
                if (lance < lanceMinimoDoVeiculo(indice)) {
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
                                removerVeiculo(id);
                            } else System.out.println("Compra cancelada!");

                        }
                        case 2 -> {
                            pagamento12x(lance);
                            System.out.println("Deseja finalizar a compra? 1 - SIM/2 - NÃO");
                            int compra = input.nextInt();
                            if (compra == 1) {
                                System.out.println("Compra realizada com sucesso!");
                                removerVeiculo(id);
                            } else System.out.println("Compra cancelada!");
                        }
                        case 3 -> {
                            pagamento24x(lance);
                            System.out.println("Deseja finalizar a compra? 1 - SIM/2 - NÃO");
                            int compra = input.nextInt();
                            if (compra == 1) {
                                System.out.println("Compra realizada com sucesso!");
                                removerVeiculo(id);
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
