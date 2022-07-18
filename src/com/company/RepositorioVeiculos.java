package com.company;

import java.util.ArrayList;
import java.util.Scanner;

// Repositorio para os veiculos cadastrados
public class RepositorioVeiculos extends AbstractPagamentos {
    private final ArrayList<Veiculos> veiculos;
    private final Scanner input;

    public RepositorioVeiculos() {
        veiculos = new ArrayList<>();
        input = new Scanner(System.in);
    }

    public void adicionar(Veiculos v) {
        veiculos.add(v);

    }

    // Metodo para listar todas as informações de um determinado veiculo
    public void procurarVeiculos(String id) {
        Veiculos temp = null;
        for (int indice = 0; indice < veiculos.size(); indice++) {
            if (veiculos.get(indice).getId().equals(id.toLowerCase())) {
                temp = veiculos.get(indice);
                System.out.println("Veículo: " + indice);
                System.out.println("ID: " + veiculos.get(indice).getId()
                        + " Cor: " + veiculos.get(indice).getCor());
                System.out.println("Ano: " + veiculos.get(indice).getAno()
                        + " Quilometragem: " + veiculos.get(indice).getQuilometragem()
                        + " Km rodados");
                System.out.println("Valor da divida: R$ " + veiculos.get(indice).getValorDivida()
                        + " Lance Mínimo: R$ " + veiculos.get(indice).getLanceMinimo() + "");
                System.out.println("Estado de conservação: " + veiculos.get(indice).getDescricao());
                System.out.println();
                break;
            }
        }
        if (temp == null) {
            System.out.println("Veículo não encontrado!");
        }
    }

    // metodo para alterar as informações de um veiculos
    public void editarVeiculo(String id) {
        for (Veiculos veiculo : veiculos) {
            if (veiculo.getId().equals(id.toLowerCase())) {
                System.out.println("""
                        O que deseja alterar?
                        1 - Cor
                        2 - Ano
                        3 - Quilometragem
                        4 - Valor da divida
                        5 - Lance mínimo
                        6 - Estado de econservação""");
                int resposta = input.nextInt();
                switch (resposta) {
                    case 1 -> {
                        System.out.println("Escolha uma nova cor:");
                        String novaCor = input.next().toLowerCase();
                        veiculo.setCor(novaCor);
                        System.out.println("Cor alterada para " + novaCor + " com sucesso!");
                    }
                    case 2 -> {
                        System.out.println("Escolha um novo ano:");
                        int novoAno = input.nextInt();
                        veiculo.setAno(novoAno);
                        System.out.println("Ano alterado para " + novoAno + " com sucesso!");
                    }
                    case 3 -> {
                        System.out.println("Escolha uma nova quilometragem:");
                        int novaKm = input.nextInt();
                        veiculo.setQuilometragem(novaKm);
                        System.out.println("Quilometragem alterada para " + novaKm + "kms rodados com sucesso!");
                    }
                    case 4 -> {
                        System.out.println("Digite um nvoo valor da dívida: ");
                        double novaDivida = input.nextDouble();
                        veiculo.setValorDivida(novaDivida);
                        System.out.println("Valor da dívida alterada para R$ " + novaDivida + " com sucesso!");
                    }
                    case 5 -> {
                        System.out.println("Digite um novo lance mínimo:");
                        double novoLance = input.nextDouble();
                        veiculo.setLanceMinimo(novoLance);
                        System.out.println("Lance mínimo alterado para R$ " + novoLance + " com sucesso!");
                    }
                    case 6 -> {
                        System.out.println("Digite um novo estado de conseervação:");
                        String novaConservacao = input.next().toLowerCase();
                        veiculo.setDescricao(novaConservacao);
                        System.out.println("Descrição alterada com sucesso!");
                    }
                    default -> System.out.println("Opção não disponivel!");
                }
            } else System.out.println("Veiculo não encontrado!");
        }
    }

    // metodo para remover algum veiculo já cadastrado
    public void removerVeiculo(String id) {
        for (int indice = 0; indice < veiculos.size(); indice++) {
            if (veiculos.get(indice).getId().equals(id.toLowerCase())) {
                veiculos.remove(indice);
                System.out.println("Veiculo removido com successo!");
            }

        }

    }

    // metodo para listar todos os veiculos cadastrados
    public void imprimirVeiculos() {
        for (int indice = 0; indice < veiculos.size(); indice++) {
            System.out.println("##########");
            System.out.println("Veículo: " + (indice + 1));
            System.out.println("ID: " + veiculos.get(indice).getId());
            System.out.println("Valor da divida: R$ " + veiculos.get(indice).getValorDivida()
                    + " Lance Mínimo: R$ " + veiculos.get(indice).getLanceMinimo() + "\n");
        }
    }

    public void compraVeiculos(double lance) {

        imprimirVeiculos();
        System.out.println("Digite o id do veiculo que deseja comprar: ");
        String id = input.next().toLowerCase();

        for (Veiculos veiculo : veiculos) {
            if (veiculo.getId().equals(id)) {
                System.out.println("Quanto deseja pagar?");
                lance = input.nextDouble();
                if (lance < veiculo.getLanceMinimo()) {
                    System.out.println("Lance menor que lance minimo! Tente com um lance maior");
                } else {
                    System.out.println("""
                            Qual forma de pagamento deseja utilizar?:
                            1 - A vista
                            2 - Em 12x sem juros
                            3 - Em 24x sem juros
                            4 - Desistir da compra\s""");
                    int respostaCompra = input.nextInt();
                    switch (respostaCompra) {
                        case 1 -> {
                            System.out.println("O valor do veiculo será: " + pagamentoAvista(lance));
                            System.out.println("Deseja finalizar a compra? 1 - SIM/2 - NÃO");
                            int compra = input.nextInt();
                            if (compra == 1) {
                                System.out.println("Compra realizada com sucesso!");
                                removerVeiculo(id);
                            }

                        }
                        case 2 -> {
                            pagamento12x(lance);
                            System.out.println("Deseja finalizar a compra? 1 - SIM/2 - NÃO");
                            int compra = input.nextInt();
                            if (compra == 1) {
                                System.out.println("Compra realizada com sucesso!");
                                removerVeiculo(id);
                            }
                        }
                        case 3 -> {
                            pagamento24x(lance);
                            System.out.println("Deseja finalizar a compra? 1 - SIM/2 - NÃO");
                            int compra = input.nextInt();
                            if (compra == 1) {
                                System.out.println("Compra realizada com sucesso!");
                                removerVeiculo(id);
                            }
                        }
                        default -> {
                        }
                    }
                }
            }
        }
    }
}
