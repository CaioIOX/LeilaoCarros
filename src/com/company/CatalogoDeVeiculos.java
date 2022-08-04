package com.company;

import javax.swing.JOptionPane;

public class CatalogoDeVeiculos implements GlobalRepo {
    static int resposta;

    public void listaDeMarcas() {
        try {
            repositorioDeMarcasGlobal.imprimirMarcas();
            resposta = Integer.parseInt(JOptionPane.showInputDialog(
                "Você deseja:" +
                    "\n1 - Alterar as informações de alguma Marca" +
                    "\n2 - Apagar alguma Marca" +
                    "\n3 - Voltar para a tela inicial"));
            switch (resposta) {
                case 1 -> {
                    String editarMarca = JOptionPane.showInputDialog
                        ("Digite o nome da marca que deseja alterar as informações");
                    repositorioDeMarcasGlobal.editarMarca(editarMarca);
                }
                case 2 -> {
                    String removerMarca = JOptionPane.showInputDialog
                        ("Digite o nome da marca que deseja apagar");
                    repositorioDeMarcasGlobal.removerMarca(removerMarca);
                }
                default -> {
                }
            }
        } catch (Exception e) {
            JOptionPane.showInputDialog("Erro: Entrada inválida");
        }
    }

    public void listaDeModelos() {
        try {
            repositorioDeModelosGlobal.imprimirModelo();
            resposta = Integer.parseInt(JOptionPane.showInputDialog(
                "Você deseja:" +
                    "\n1 - Alterar as informações de algum Modelo" +
                    "\n2 - Apagar algum Modelo" +
                    "\n3 - Voltar para a tela inicialr"));
            switch (resposta) {
                case 1 -> {
                    String editarModelo = JOptionPane.showInputDialog
                        ("Digite o nome do modelo que deseja alterar as informações");
                    repositorioDeModelosGlobal.editarModelo(editarModelo);
                }
                case 2 -> {
                    String removerModelo = JOptionPane.showInputDialog
                        ("Digite o nome do modelo que deseja apagar");
                    repositorioDeModelosGlobal.removerModelo(removerModelo);
                }
                default -> {
                }
            }
        }catch (Exception e) {
            JOptionPane.showInputDialog("Erro: Entrada inválida");
        }
    }
}

