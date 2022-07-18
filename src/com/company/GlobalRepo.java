package com.company;

import com.company.Cadastros;
import com.company.RepositorioMarca;
import com.company.RepositorioModelo;
import com.company.RepositorioVeiculos;

import java.util.Scanner;

interface GlobalRepo {
    Scanner input = new Scanner(System.in);
    RepositorioVeiculos veiculosMain = new RepositorioVeiculos();
    RepositorioMarca marcaMain = new RepositorioMarca();
    RepositorioModelo modeloMain = new RepositorioModelo();
    Cadastros cadastro = new Cadastros(veiculosMain, marcaMain, modeloMain);
}