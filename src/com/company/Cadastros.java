package com.company;

import java.util.Scanner;

public class Cadastros implements GlobalRepo {
    private final Scanner input = new Scanner(System.in);
    private final RepositorioVeiculos veiculosCadastro;
    private final RepositorioMarca marcaCadastro;
    private final RepositorioModelo modeloCadastro;
    String marcaEscolhida;
    String modeloEscolhido;

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
        System.out.println("Marca cadastrada com sucesso!");
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
        System.out.println("Modelo cadastrado com sucesso!");
    }

    // Metodo para cadastro de veiculos
    void inserirVeiculos() {
        System.out.println("Digite um id para o veículo: ");
        String id = input.next();
        System.out.println("Digite a cor do veículo: ");
        String cor = input.next();
        System.out.println("Digite o ano do veículo: ");
        int ano = input.nextInt();
        System.out.println("Digite a quilometragem do veículo: ");
        int quilometragem = input.nextInt();
        System.out.println("Digite o valor da dívida do veículo: ");
        double valorDivida = input.nextDouble();
        System.out.println("Digite o lance mínimo do veículo: ");
        double lanceMinimo = input.nextDouble();
        System.out.println("Descreva o estado de conservação do veículo: ");
        String descricao = input.next();
        System.out.println("Escolha qual a marca do veiculo: ");
        marcaCadastro.imprimirMarcas();
        marcaEscolhida = input.next();
        System.out.println("Escolha qual o modelo do veículo: ");
        modeloCadastro.imprimirModelo();
        modeloEscolhido = input.next();

        veiculosCadastro.adicionar(new Veiculos(cor, id, ano, quilometragem, valorDivida, lanceMinimo,
                descricao));
        System.out.println("Veiculo cadastrado com sucesso!");

    }

    public String getMarca() {
        return marcaEscolhida;
    }

    public String getModelo() {
        return modeloEscolhido;
    }
}
