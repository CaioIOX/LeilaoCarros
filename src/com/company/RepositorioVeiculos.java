package com.company;

public class RepositorioVeiculos extends Veiculos implements GlobalRepo {

    Modelo modeloEscolhido;

    public void adicionarVeiculo(Veiculos v) {
        veiculos.add(v);
    }

    public void procurarVeiculos(String id) {
        for (int indice = 0; indice < veiculos.size(); indice++) {
            if (compareWithInput(id, indice)) {
                System.out.println("Veículo: " + indice);
                System.out.println("ID: " + idDoVeiculo(indice));
                System.out.println(repositorioDeMarcasGlobal.nomeDaMarca(indice) + " " +
                    repositorioDeModelosGlobal.nomeDoModelo(indice) + " Cor: " + corDoVeiculo(indice));
                System.out.println("Ano: " + anoDoVeiculo(indice)
                    + " Quilometragem: " + quilometragemDoVeiculo(indice)
                    + " Km rodados");
                System.out.println("País de fabricação: " + repositorioDeMarcasGlobal.paisDeOrigemDaMarca(indice) +
                    " País de produção: " + repositorioDeMarcasGlobal.paisDeProducaoDaMarca(indice));
                System.out.println("Motor: " + repositorioDeModelosGlobal.motorizacaoDoModelo(indice) +
                    " Tipos de combustivel: " + repositorioDeModelosGlobal.tipoDeCombustivelDoModelo(indice));
                System.out.println("Valor da divida: R$ " + dividaDoVeiculo(indice)
                    + " Lance Mínimo: R$ " + lanceMinimoDoVeiculo(indice) + "");
                System.out.println("Estado de conservação: " + descricaoDoVeiculo(indice));
                System.out.println();
                break;
            } else System.out.println("Veículo não encontrado!");
        }

    }

    public void editarVeiculo(String id) {
        for (int indice = 0; indice < veiculos.size(); indice++) {
            try {
                if (compareWithInput(id, indice)) {
                    System.out.println(
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
                            System.out.println("Digite um novo estado de conservação:");
                            String novaConservacao = input.next().toLowerCase();
                            veiculos.get(indice).setDescricao(novaConservacao);
                            System.out.println("Descrição alterada com sucesso!");
                        }
                        case 7 -> {
                            System.out.println("Digite o número correspondente do novo modelo do veículo: ");
                            repositorioDeModelosGlobal.imprimirModelo();
                            int modeloId = input.nextInt();
                            modeloEscolhido = repositorioDeModelosGlobal.getModelo(modeloId - 1);
                            repositorioDeVeiculosGlobal.getVeiculos(indice).setModelo(modeloEscolhido);
                        }
                        case 8 -> {
                            System.out.println("Digite um novo id para o veículo: ");
                            String novoId = input.next();
                            veiculos.get(indice).setId(novoId);
                            repositorioDeVeiculosGlobal.getVeiculos(indice).setModelo(modeloEscolhido);
                        }
                        default -> System.out.println("Opção não disponivel!");
                    }
                } else System.out.println("Veiculo não encontrado!");
            } catch (Exception e) {
                System.out.println("Erro: dados invalidos");
            }
        }
    }

    public void removerVeiculo(String id) {
        for (int indice = 0; indice < veiculos.size(); indice++) {
            if (compareWithInput(id, indice)) {
                veiculos.remove(getVeiculos(indice));
                System.out.println("Veiculo removido com successo!");
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
