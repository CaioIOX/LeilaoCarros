package com.company;

// Repositorio para os veiculos cadastrados
public class RepositorioVeiculos {
    private final static int MAX = 100;
    private final Veiculos[] veiculos;
    private int indice;

    public RepositorioVeiculos() {
        indice = 0;
        veiculos = new Veiculos[MAX];
    }

    public void adicionar(Veiculos v) {
        veiculos[indice] = v;
        indice++;
    }

    // Metodo para listar todas as informações de um determinado veiculo
    public void procurarVeiculos(String numero) {
        Veiculos temp = null;
        for (int i = 0; i < indice; i++) {
            if (veiculos[i].getId().equals(numero)) {
                temp = veiculos[i];
                System.out.println("Veículo: " + i);
                System.out.println("Marca: " + veiculos[i].getMarca() + " Modelo: " + veiculos[i].getModelo());
                System.out.println("ID: " + veiculos[i].getId()
                    + " Cor: " + veiculos[i].getCor());
                System.out.println("Ano: " + veiculos[i].getAno()
                    + " Quilometragem: " + veiculos[i].getQuilometragem() + " Km rodados");
                System.out.println("Valor da divida: R$ " + veiculos[i].getValorDivida()
                    + " Lance Mínimo: R$ " + veiculos[i].getLanceMinimo() + "");
                System.out.println("Estado de conservação: " + veiculos[i].getDescricao());
                System.out.println();
                break;
            }
        }
        if (temp == null) {
            System.out.println("Veículo não encontrado!");
        }
    }

    // metodo para alterar as informações de um veiculos
    public void alterarVeiculo(String numero) {
        for (int i = 0; i < indice; i++) {
            if (veiculos[i].getId().equals(numero)) {
                veiculos[i] = veiculos[indice - 1];
                veiculos[indice - 1] = null;
                indice--;
            }
        }
    }

    // metodo para remover algum veiculo já cadastrado
    public void removerVeiculo(String numero) {
        for (int i = 0; i < indice; i++) {
            if (veiculos[i].getId().equals(numero)) {
                veiculos[i] = veiculos[indice - 1];
                veiculos[indice - 1] = null;
                indice--;
            }
        }
    }

    // metodo para listar todos os veiculos cadastrados
    public void imprimirVeiculos() {
        for (int i = 0; i < indice; i++) {
            System.out.println("##########");
            System.out.println("Veículo: " + (i + 1));
            System.out.println("Marca: " + veiculos[i].getMarca() + " Modelo: " + veiculos[i].getModelo());
            System.out.println("ID: " + veiculos[i].getId());
            System.out.println("Valor da divida: R$ " + veiculos[i].getValorDivida()
                + " Lance Mínimo: R$ " + veiculos[i].getLanceMinimo() + "\n");
        }
    }

}
