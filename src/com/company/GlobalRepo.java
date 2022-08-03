package com.company;

import java.util.Scanner;

interface GlobalRepo {
    Scanner input = new Scanner(System.in);
    RepositorioVeiculos repositorioDeVeiculosGlobal = new RepositorioVeiculos();
    RepositorioMarca repositorioDeMarcasGlobal = new RepositorioMarca();
    RepositorioModelo repositorioDeModelosGlobal = new RepositorioModelo();
    Cadastros cadastro = new Cadastros();
    CompraDeVeiculos compraVeiculos = new CompraDeVeiculos();
}