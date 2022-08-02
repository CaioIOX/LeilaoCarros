package com.company;

import java.util.ArrayList;

// Repositorio para os veiculos cadastrados
public class RepositorioVeiculos extends AbstractPagamentos implements GlobalRepo {
    private final ArrayList<Veiculos> veiculos;
    Modelo modeloEscolhido;
    public RepositorioVeiculos() {
        veiculos = new ArrayList<>();
    }
    public ArrayList<Veiculos> getVeiculos() {
        return veiculos;
    }

    public void adicionarVeiculo(Veiculos v) {
        veiculos.add(v);
    }

    // Metodo para listar todas as informações de um determinado veiculo
    public void procurarVeiculos(String id) {
        for (int indice = 0; indice < veiculos.size(); indice++) {
            if (veiculos.get(indice).getId().equals(id.toLowerCase())) {
                System.out.println("Veículo: " + indice);
                System.out.println("ID: " + veiculos.get(indice).getId());
                System.out.println(marcaMain.getMarca().get(indice).getNome() + " " +
                        modeloMain.getModelo().get(indice).getNome() + " Cor: " + veiculos.get(indice).getCor());
                System.out.println("Ano: " + veiculos.get(indice).getAno()
                        + " Quilometragem: " + veiculos.get(indice).getQuilometragem()
                        + " Km rodados");
                System.out.println("País de fabricação: " + marcaMain.getMarca().get(indice).getPaisDeOrigem() +
                        " País de produção: " + marcaMain.getMarca().get(indice).getPaisDeProducao());
                System.out.println("Motor: " + modeloMain.getModelo().get(indice).getMotorizacao() +
                        " Tipos de combustivel: " + modeloMain.getModelo().get(indice).getTipoDeCombustivel());
                System.out.println("Valor da divida: R$ " + veiculos.get(indice).getValorDivida()
                        + " Lance Mínimo: R$ " + veiculos.get(indice).getLanceMinimo() + "");
                System.out.println("Estado de conservação: " + veiculos.get(indice).getDescricao());
                System.out.println();
                break;
            } else System.out.println("Veículo não encontrado!");
        }


    }

    // metodo para alterar as informações de um veiculos
    public void editarVeiculo(String id) {
        for (int indice = 0; indice < veiculos.size(); indice++) {
            if (veiculos.get(indice).getId().equals(id.toLowerCase())) {
                System.out.println(
                        "O que deseja alterar?" +
                        "\n1 - Cor" +
                        "\n2 - Ano" +
                        "\n3 - Quilometragem" +
                        "\n4 - Valor da divida" +
                        "\n5 - Lance mínimo" +
                        "\n6 - Estado de econservação" +
                        "\n7 - Modelo");
                int resposta = input.nextInt();
                switch (resposta) {
                    case 1 -> {
                        System.out.println("Escolha uma nova cor:");
                        String novaCor = input.next().toLowerCase();
                        veiculos.get(indice).setCor(novaCor);
                        System.out.println("Cor alterada para " + novaCor + " com sucesso!");
                    }
                    case 2 -> {
                        System.out.println("Escolha um novo ano:");
                        int novoAno = input.nextInt();
                        veiculos.get(indice).setAno(novoAno);
                        System.out.println("Ano alterado para " + novoAno + " com sucesso!");
                    }
                    case 3 -> {
                        System.out.println("Escolha uma nova quilometragem:");
                        int novaKm = input.nextInt();
                        veiculos.get(indice).setQuilometragem(novaKm);
                        System.out.println("Quilometragem alterada para " + novaKm + "kms rodados com sucesso!");
                    }
                    case 4 -> {
                        System.out.println("Digite um nvoo valor da dívida: ");
                        double novaDivida = input.nextDouble();
                        veiculos.get(indice).setValorDivida(novaDivida);
                        System.out.println("Valor da dívida alterada para R$ " + novaDivida + " com sucesso!");
                    }
                    case 5 -> {
                        System.out.println("Digite um novo lance mínimo:");
                        double novoLance = input.nextDouble();
                        veiculos.get(indice).setLanceMinimo(novoLance);
                        System.out.println("Lance mínimo alterado para R$ " + novoLance + " com sucesso!");
                    }
                    case 6 -> {
                        System.out.println("Digite um novo estado de conseervação:");
                        String novaConservacao = input.next().toLowerCase();
                        veiculos.get(indice).setDescricao(novaConservacao);
                        System.out.println("Descrição alterada com sucesso!");
                    }
                    case 7 -> {
                        System.out.println("Digite o número correspondente do novo modelo do veículo: ");
                        modeloMain.imprimirModelo();
                        int modeloId = input.nextInt();
                        modeloEscolhido = modeloMain.getModelo().get(modeloId - 1);
                        veiculosMain.getVeiculos().get(indice).setModelo(modeloEscolhido);
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
            System.out.println("Veiculo: " + marcaMain.getMarca().get(indice).getNome() +
                    " " + modeloMain.getModelo().get(indice).getNome());
            System.out.println("Valor da divida: R$ " + veiculos.get(indice).getValorDivida()
                    + " Lance Mínimo: R$ " + veiculos.get(indice).getLanceMinimo() + "\n");
        }
    }

    public void compraVeiculos() {
        imprimirVeiculos();
        System.out.println("Digite o id do veiculo que deseja comprar: ");
        String id = input.next().toLowerCase();

        for (Veiculos veiculo : veiculos) {
            if (veiculo.getId().equals(id)) {
                System.out.println("Quanto deseja pagar?");
                double lance = input.nextDouble();
                if (lance < veiculo.getLanceMinimo()) {
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

    public boolean isEmpty() {

        return veiculos.size() == 0;
    }
}
