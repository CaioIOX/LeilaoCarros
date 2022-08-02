package com.company;

public class Cadastros implements GlobalRepo {
    private final RepositorioVeiculos veiculosCadastro;
    private final RepositorioMarca marcaCadastro;
    private final RepositorioModelo modeloCadastro;
    Marca marcaEscolhida;
    Modelo modeloEscolhido;

    public Cadastros(RepositorioVeiculos leilao, RepositorioMarca marca, RepositorioModelo modelo) {
        this.veiculosCadastro = leilao;
        this.marcaCadastro = marca;
        this.modeloCadastro = modelo;
    }

    // Metodo para cadastro de marcas
    public void cadastrarMarca() {
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
    public void cadastrarModelo() {
        System.out.println("Digite o número correspondente da marca do veiculo: ");
        marcaCadastro.imprimirMarcas();
        int marcaId = input.nextInt();
        marcaEscolhida = repositorioDeMarcasGlobal.getMarca(marcaId-1);
        System.out.println("Digite o nome do modelo: ");
        String nomeModelo = input.next();
        System.out.println("Digite o tipo do motor: ");
        String motorizacao = input.next();
        System.out.println("Digite o tipo de combustive: ");
        String tipoCombustivel = input.next();

        modeloCadastro.adicionar(new Modelo(nomeModelo, motorizacao, tipoCombustivel, marcaEscolhida));
        System.out.println("Modelo cadastrado com sucesso!");
    }

    // Metodo para cadastro de veiculos
    void cadastrarVeiculos() {
        System.out.println("Digite o número correspondente do modelo do veículo: ");
        modeloCadastro.imprimirModelo();
        int modeloId = input.nextInt();
        modeloEscolhido = repositorioDeModelosGlobal.getModelo(modeloId-1);
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

        veiculosCadastro.adicionarVeiculo(new Veiculos(cor, id, ano, quilometragem, valorDivida, lanceMinimo,
                descricao, modeloEscolhido));
        System.out.println("Veiculo cadastrado com sucesso!");

    }

}
