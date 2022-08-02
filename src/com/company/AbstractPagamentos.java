package com.company;

public abstract class AbstractPagamentos {
    double entrada;
    double parcela;

    public abstract double pagamentoAvista(double lance);

    public abstract void pagamento12x(double lance);

    public abstract void pagamento24x(double lance);
}
