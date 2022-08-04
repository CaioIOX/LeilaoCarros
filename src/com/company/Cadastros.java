package com.company;

import javax.swing.JOptionPane;

public class Cadastros implements GlobalRepo {
    Marca marcaEscolhida;
    Modelo modeloEscolhido;

    public void cadastrarMarca() {
        try {
            String nomeMarca = JOptionPane.showInputDialog("Digite o nome da marca: ");
            String paisOrigem = JOptionPane.showInputDialog("Digte o país de origem: ");
            String paisProducao = JOptionPane.showInputDialog("Digite o país de produção: ");

            repositorioDeMarcasGlobal.adicionar(new Marca(
                nomeMarca,
                paisOrigem,
                paisProducao));
            JOptionPane.showMessageDialog(null, "Marca cadastrada com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: dados invalidos");
        }
    }

    public void cadastrarModelo() {
        try {
            repositorioDeMarcasGlobal.imprimirMarcas();
            int marcaId = Integer.parseInt(JOptionPane.showInputDialog
                ("Digite o número correspondente da marca do veiculo: "));
            marcaEscolhida = repositorioDeMarcasGlobal.getMarca(marcaId - 1);
            String nomeModelo = JOptionPane.showInputDialog("Digite o nome do modelo: ");
            String motorizacao = JOptionPane.showInputDialog("Digite o tipo do motor: ");
            String tipoCombustivel = JOptionPane.showInputDialog("Digite o tipo de combustive: ");

            repositorioDeModelosGlobal.adicionar(new Modelo(
                nomeModelo,
                motorizacao,
                tipoCombustivel,
                marcaEscolhida));
            JOptionPane.showMessageDialog(null, "Modelo cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: dados invalidos");
        }
    }

    void cadastrarVeiculos() {
        try {
            repositorioDeModelosGlobal.imprimirModelo();
            int modeloId = Integer.parseInt(JOptionPane.showInputDialog
                ("Digite o número correspondente do modelo do veículo: "));
            modeloEscolhido = repositorioDeModelosGlobal.getModelo(modeloId - 1);
            String id = JOptionPane.showInputDialog
                ("Digite um id para o veículo: ");
            String cor = JOptionPane.showInputDialog
                ("Digite a cor do veículo: ");
            int ano = Integer.parseInt(JOptionPane.showInputDialog
                ("Digite o ano do veículo: "));
            int quilometragem = Integer.parseInt(JOptionPane.showInputDialog
                ("Digite a quilometragem do veículo: "));
            double valorDivida = Double.parseDouble(JOptionPane.showInputDialog
                ("Digite o valor da dívida do veículo: "));
            double lanceMinimo = Double.parseDouble(JOptionPane.showInputDialog
                ("Digite o lance mínimo do veículo: "));
            String descricao = JOptionPane.showInputDialog
                ("Descreva o estado de conservação do veículo: ");

            repositorioDeVeiculosGlobal.adicionarVeiculo(new Veiculos(
                cor,
                id,
                ano,
                quilometragem,
                valorDivida,
                lanceMinimo,
                descricao,
                modeloEscolhido));
            JOptionPane.showMessageDialog(null, "Veiculo cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro: dados invalidos");
        }

    }

}
