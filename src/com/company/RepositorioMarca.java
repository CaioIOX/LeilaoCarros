package com.company;

public class RepositorioMarca extends Marca implements GlobalRepo {

    public void adicionar(Marca m) {
        marca.add(m);
    }

    public void procurarMarcas(String nome) {
        Marca temp = null;
        for (int indice = 0; indice < marca.size(); indice++) {
            if (compareWithInput(nome, indice)) {
                temp = marca.get(indice);
                System.out.println("Marca: " + nomeDaMarca(indice));
                System.out.println("Pais de origem: " + paisDeOrigemDaMarca(indice));
                System.out.println("Pais de produção: " + paisDeProducaoDaMarca(indice));
                System.out.println();
                break;
            }
        }
        if (temp == null) {
            System.out.println("Marca não encontrada!");
        }
    }

    public void editarMarca(String nome) {
        for (int indice = 0; indice < marca.size(); indice++) {
            try {
                if (compareWithInput(nome, indice)) {
                    System.out.println(
                        "O que deseja alterar?" +
                            "\n1 - Nome da Marca" +
                            "\n2 - País de Origem" +
                            "\n3 - País de produção");
                    int respostaAlterar = input.nextInt();
                    switch (respostaAlterar) {
                        case 1 -> {
                            System.out.println("Digite um novo nome para a Marca: ");
                            String respostaNome = input.next();
                            marca.get(indice).setNome(respostaNome);
                        }
                        case 2 -> {
                            System.out.println("Digite um novo país de origem: ");
                            String respostaPaisDeOrigem = input.next();
                            marca.get(indice).setPaisDeOrigem(respostaPaisDeOrigem);
                        }
                        case 3 -> {
                            System.out.println("Digite um novo país de produção: ");
                            String respostaPaisDeproducao = input.next();
                            marca.get(indice).setPaisDeProducao(respostaPaisDeproducao);
                        }
                        default -> System.out.println("Marca não encontrada!");
                    }
                }
            } catch (Exception e) {
                System.out.println("Erro: dados invalidos");
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
            System.out.println("#" + (indice + 1) + " - " + nomeDaMarca(indice));
        }
    }

    public boolean isEmpty() {

        return marca.isEmpty();
    }
}
