package com.example.manuelmartins.cadastrodeclientes;

public class Repositorio {
    private Cliente[] crientes;
    private int indice;

    public Repositorio(int tamanho) {
        crientes = new Cliente[tamanho];
        indice = 0;
    }
}
