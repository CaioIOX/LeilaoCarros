package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class RepositorioMarca {

    private final ArrayList<Marca> marca;
    private final int indice;
    private final Scanner input;

    public RepositorioMarca() {
        indice =0;
        marca = new ArrayList<>();
        input = new Scanner(System.in);
    }

    public void adicionar(Marca m) {
        marca.add(m);
    }
    public void procurarMarcas(String nome) {
        Marca temp = null;
        while (indice<marca.size()) {
            if (marca.get(indice).getNome().equals(nome.toLowerCase())) {
                temp = marca.get(indice);
                System.out.println("Marca: " + marca.get(indice).getNome());
                System.out.println("Pais de origem: " + marca.get(indice).getPaisDeOrigem());
                System.out.println("Pais de produção: " + marca.get(indice).getPaisDeProducao());
                System.out.println();
                break;
            }
        }
        if (temp == null) {
            System.out.println("Marca não encontrada!");
        }
    }
    public void editarMarca(String nome) {
        while (indice<marca.size()) {
            if (marca.get(indice).getNome().equals(nome.toLowerCase())) {
                System.out.println("O que deseja alterar?" +
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
        }
    }
    public void removerMarca(String nome) {
        while (indice<marca.size()) {
            if (marca.get(indice).getNome().equals(nome.toLowerCase())) {
                marca.remove(indice);
            }
        }
    }
    public void imprimirMarcas() {
        while (indice<marca.size()) {
            System.out.println("# - " + marca.get(indice).getNome());
        }
    }
}
