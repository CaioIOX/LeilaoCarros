package com.company;

import java.util.Scanner;

public class Cadastros {
    private final Scanner input = new Scanner(System.in);
    private final RepositorioVeiculos teste;

    public Cadastros(RepositorioVeiculos teste) {
        this.teste = teste;
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
        System.out.println("Escolha a marca do veículo:" +
            "\n1 - BMW" +
            "\n2 - Chevrolet" +
            "\n3 - Fiat" +
            "\n4 - Volkswagen" +
            "\n5 - Ford");
        String escolhaMarca = input.next();
        Modelo modelo = null;
        Marca marca = null;
        switch (escolhaMarca) {
            case "1" -> {
                marca = new Marca("BMW", "Alemanha", "Brasil");
                modelo = new Modelo("BMW i4", "2.0", "Elétrico");
            }
            case "2" -> {
                marca = new Marca("Chevrolet", "Estados Unidos", "Brasil");
                modelo = new Modelo("Camaro", "2.0", "Gasolina");
            }
            case "3" -> {
                marca = new Marca("Fiat", "Itália", "Brasil");
                modelo = new Modelo("Uno", "1.0", "Flex");
            }
            case "4" -> {
                marca = new Marca("Volkswagen", "Alemanha", "Brasil");
                modelo = new Modelo("Golf", "1.4", "Gasolina");
            }
            case "5" -> {
                marca = new Marca("Ford", "Estados Unidos", "Brasil");
                modelo = new Modelo("Focus", "1.6", "Flex");
            }
        }

        teste.adicionar(new Veiculos(cor, id, ano, quilometragem, valorDivida, lanceMinimo, descricao, marca, modelo));

    }

}
