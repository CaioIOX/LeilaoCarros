package com.company;

import javax.swing.JOptionPane;

public class RepositorioModelo extends Modelo implements GlobalRepo {

    public void adicionar(Modelo m) {
        modelo.add(m);
    }

    public void procurarModelo(String nome) {
        Modelo temp = null;
        for (int indice = 0; indice < modelo.size(); indice++) {
            if (compareWithInput(nome, indice)) {
                temp = getModelo(indice);
                JOptionPane.showMessageDialog
                    (null, "Modelo: " + nomeDoModelo(indice) +
                    "\nMotorização: " + motorizacaoDoModelo(indice) +
                    "\nTipo de combustivel: " + tipoDeCombustivelDoModelo(indice));
                break;
            }
        }
        if (temp == null) {
            JOptionPane.showMessageDialog(null, "Modelo não encontrado!");
        }
    }

    public void editarModelo(String nome) {
        for (int indice = 0; indice < modelo.size(); indice++) {
            try {
                if (compareWithInput(nome, indice)) {
                    int respostaAlterar = Integer.parseInt(JOptionPane.showInputDialog(
                        "O que deseja alterar?" +
                            "\n1 - Nome do modelo" +
                            "\n2 - Motorização" +
                            "\n3 - Tipo de gasolina"));
                    switch (respostaAlterar) {
                        case 1 -> {
                            String respostaNome = JOptionPane.showInputDialog
                                ("Digite um novo nome para o modelo: ");
                            getModelo(indice).setNome(respostaNome);
                        }
                        case 2 -> {
                            String respostaMotorizacao = JOptionPane.showInputDialog
                                ("Digite uma nova motorização: ");
                            getModelo(indice).setMotorizacao(respostaMotorizacao);
                        }
                        case 3 -> {
                            String respostaTipoDeCombustivel = JOptionPane.showInputDialog
                                ("Digite um novo tipo de combustivel: ");
                            getModelo(indice).setTipoDeCombustivel(respostaTipoDeCombustivel);
                        }
                        default -> JOptionPane.showMessageDialog
                            (null, "Modelo não encontrado!");
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: dados invalidos");
            }
        }
    }

    public void removerModelo(String nome) {
        for (int indice = 0; indice < modelo.size(); indice++)
            if (compareWithInput(nome, indice)) modelo.remove(getModelo(indice));
    }


    public void imprimirModelo() {
        for (int indice = 0; indice < modelo.size(); indice++)
            JOptionPane.showMessageDialog
                (null, "#" + (indice + 1) + " - " + nomeDoModelo(indice));

    }

    public boolean isEmpty() {
        return modelo.size() == 0;
    }
}
