package com.company;

public abstract class AbstractPagamentos {
    double entrada;
    double parcela;

    public AbstractPagamentos() {

    }

    public double pagamentoAvista(double lance) {
        lance -= lance * 0.1;
        return lance;
    }

    public void pagamento12x(double lance) {
        entrada = lance * 0.3;
        parcela = (lance - entrada) / 12;
        System.out.println("Para realizar a compra deve-se dar uma entrada de R$ " + entrada
            + " e as parcelas ficarão em R$ " + parcela + " sem juros!");
    }

    public void pagamento24x(double lance) {
        entrada = lance * 0.2;
        parcela = (lance - entrada) / 24;
        System.out.println("Para realizar a compra deve-se dar uma entrada de R$ " + entrada
            + " e as parcelas ficarão em R$ " + parcela + " sem juros!");
    }
}
