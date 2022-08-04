package com.company;

import javax.swing.JOptionPane;

public class RepositorioMarca extends Marca implements GlobalRepo {

    public void adicionar(Marca m) {
        marca.add(m);
    }

    public void procurarMarcas(String nome) {
        Marca temp = null;
        for (int indice = 0; indice < marca.size(); indice++) {
            if (compareWithInput(nome, indice)) {
                temp = marca.get(indice);
                JOptionPane.showInputDialog("Marca: " + nomeDaMarca(indice) +
                    "\nPais de origem: " + paisDeOrigemDaMarca(indice) +
                    "\nPais de produção: " + paisDeProducaoDaMarca(indice));
                break;
            }
        }
        if (temp == null) {
            JOptionPane.showInputDialog("Marca não encontrada!");
        }
    }

    public void editarMarca(String nome) {
        for (int indice = 0; indice < marca.size(); indice++) {
            try {
                if (compareWithInput(nome, indice)) {
                    int respostaAlterar = Integer.parseInt(JOptionPane.showInputDialog(
                        "O que deseja alterar?" +
                            "\n1 - Nome da Marca" +
                            "\n2 - País de Origem" +
                            "\n3 - País de produção"));
                    switch (respostaAlterar) {
                        case 1 -> {
                            String respostaNome = JOptionPane.showInputDialog
                                ("Digite um novo nome para a Marca: ");
                            marca.get(indice).setNome(respostaNome);
                        }
                        case 2 -> {
                            String respostaPaisDeOrigem =
                                ("Digite um novo país de origem: ");
                            marca.get(indice).setPaisDeOrigem(respostaPaisDeOrigem);
                        }
                        case 3 -> {
                            String respostaPaisDeproducao = JOptionPane.showInputDialog
                                ("Digite um novo país de produção: ");
                            marca.get(indice).setPaisDeProducao(respostaPaisDeproducao);
                        }
                        default -> JOptionPane.showInputDialog("Marca não encontrada!");
                    }
                }
            } catch (Exception e) {
                JOptionPane.showInputDialog("Erro: dados invalidos");
            }
        }
    }

    public void removerMarca(String nome) {
        for (int indice = 0; indice < marca.size(); indice++) {
            if (compareWithInput(nome, indice)) {
                marca.remove(getMarca(indice));
            }
        }
    }

    public void imprimirMarcas() {
        for (int indice = 0; indice < marca.size(); indice++) {
            JOptionPane.showInputDialog("#" + (indice + 1) + " - " + nomeDaMarca(indice));
        }
    }

    public boolean isEmpty() {
        return marca.size() == 0;
    }
}
