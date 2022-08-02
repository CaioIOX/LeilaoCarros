package com.company;

public class RepositorioModelo extends Modelo implements GlobalRepo {

    public void adicionar(Modelo m) {
        modelo.add(m);
    }

    public void procurarModelo(String nome) {
        Modelo temp = null;
        for (int indice = 0; indice < modelo.size(); indice++) {
            if (compareWithInput(nome, indice)) {
                temp = getModelo(indice);
                System.out.println("Modelo: " + nomeDoModelo(indice));
                System.out.println("Motorização: " + motorizacaoDoModelo(indice));
                System.out.println("Tipo de combustivel: " + tipoDeCombustivelDoModelo(indice));
                System.out.println();
                break;
            }
        }
        if (temp == null) {
            System.out.println("Modelo não encontrado!");
        }
    }

    public void editarModelo(String nome) {
        for (int indice = 0; indice < modelo.size(); indice++) {
            if (compareWithInput(nome, indice)) {
                System.out.println(
                    "O que deseja alterar?" +
                        "\n1 - Nome do modelo" +
                        "\n2 - Motorização" +
                        "\n3 - Tipo de gasolina");
                int respostaAlterar = input.nextInt();
                switch (respostaAlterar) {
                    case 1 -> {
                        System.out.println("Digite um novo nome para o modelo: ");
                        String respostaNome = input.next();
                        getModelo(indice).setNome(respostaNome);
                    }
                    case 2 -> {
                        System.out.println("Digite uma nova motorização: ");
                        String respostaMotorizacao = input.next();
                        getModelo(indice).setMotorizacao(respostaMotorizacao);
                    }
                    case 3 -> {
                        System.out.println("Digite um novo tipo de combustivel: ");
                        String respostaTipoDeCombustivel = input.next();
                        getModelo(indice).setTipoDeCombustivel(respostaTipoDeCombustivel);
                    }
                    default -> System.out.println("Modelo não encontrado!");
                }
            }
        }
    }

    public void removerModelo(String nome) {
        for (int indice = 0; indice < modelo.size(); indice++)
            if (compareWithInput(nome, indice)) modelo.remove(getModelo(indice));
    }


    public void imprimirModelo() {
        for (int indice = 0; indice < modelo.size(); indice++)
            System.out.println("#" + (indice + 1) + " - " + nomeDoModelo(indice));

    }

    public boolean isEmpty() {return modelo.size() == 0;}
}
