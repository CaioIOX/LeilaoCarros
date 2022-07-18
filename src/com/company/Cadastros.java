package com.company;

import java.util.Scanner;

public class Cadastros {
    private final Scanner input = new Scanner(System.in);
    private final RepositorioVeiculos veiculosCadastro;
    private final RepositorioMarca marcaCadastro;
    private final RepositorioModelo modeloCadastro;

    public Cadastros(RepositorioVeiculos leilao, RepositorioMarca marca, RepositorioModelo modelo) {
        this.veiculosCadastro = leilao;
        this.marcaCadastro = marca;
        this.modeloCadastro = modelo;
    }

    // Metodo para cadastro de marcas
    public void inserirMarca() {
        System.out.println("Digite o nome da marca: ");
        String nomeMarca = input.next();
        System.out.println("Digte o país de origem: ");
        String paisOrigem = input.next();
        System.out.println("Digite o país de produção: ");
        String paisProducao = input.next();

        marcaCadastro.adicionar(new Marca(nomeMarca, paisOrigem, paisProducao));
    }

    // Metodo para cadastro de modelo
    public void inserirModelo() {
        System.out.println("Digite o nome do modelo: ");
        String nomeModelo = input.next();
        System.out.println("Digite o tipo do motor: ");
        String motorizacao = input.next();
        System.out.println("Digite o tipo de combustive: ");
        String tipoCombustivel = input.next();
        modeloCadastro.adicionar(new Modelo(nomeModelo, motorizacao, tipoCombustivel));
//        System.out.println("Escolha qual a marca deste modelo: ");
//        marcaCadastro.imprimirMarcas();
//        String marcaEscolhida = input.next();
//        ArrayList<RepositorioMarca> marcaCadastro = RepositorioMarca;
//        for (int indice = 0; indice < marcaCadastro.size(); indice++) {
//            if (marcaCadastro.get(indice).toString().equals(marcaEscolhida.toLowerCase())) {
//                modeloCadastro.adicionar(new Modelo(nomeModelo, motorizacao, tipoCombustivel,
//                marcaCadastro.get(indice)));
//                break;
//            }
//        }
    }

    // Metodo para cadastro de veiculos
    void inserirVeiculos() {
        System.out.println("Digite um id para o carro: ");
        String id = input.next();
        System.out.println("Digite a cor do carro: ");
        String cor = input.next();
        System.out.println("Digite o ano do carro: ");
        int ano = input.nextInt();
        System.out.println("Digite a quilometragem do carro: ");
        int quilometragem = input.nextInt();
        System.out.println("Digite o valor da dívida do carro: ");
        double valorDivida = input.nextDouble();
        System.out.println("Digite o lance mínimo do carro: ");
        double lanceMinimo = input.nextDouble();
        System.out.println("Descreva o estado de conservação do veículo: ");
        String descricao = input.next();
        System.out.println("Escolha qual a marca do veiculo: ");
        marcaCadastro.imprimirMarcas();
        String marcaEscolhida = input.next();
        System.out.println("Escolha qual o modelo do veículo: ");
        modeloCadastro.imprimirModelo();
        String modeloEscolhido = input.next();
        veiculosCadastro.adicionar(new Veiculos(cor, id, ano, quilometragem, valorDivida, lanceMinimo,
            descricao));

//        String modeloEscolhido = input.next();
//        ArrayList<Modelo> modeloCadastro = new ArrayList<>();
//        for (int indice = 0; indice < modeloCadastro.size(); indice++) {
//            if (modeloCadastro.get(indice).toString().equals(modeloEscolhido.toLowerCase())) {
//                veiculosCadastro.adicionar(new Veiculos(cor, id, ano,
//                    quilometragem, valorDivida, lanceMinimo, descricao, modeloCadastro.get(indice)));
//            }
//        }
    }
}
