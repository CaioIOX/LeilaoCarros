package com.company;

interface GlobalRepo {
    RepositorioVeiculos repositorioDeVeiculosGlobal = new RepositorioVeiculos();
    RepositorioMarca repositorioDeMarcasGlobal = new RepositorioMarca();
    RepositorioModelo repositorioDeModelosGlobal = new RepositorioModelo();
    Cadastros cadastro = new Cadastros();
    CompraDeVeiculos compraVeiculos = new CompraDeVeiculos();
    CatalogoDeVeiculos catalogoDeVeiculos = new CatalogoDeVeiculos();
}