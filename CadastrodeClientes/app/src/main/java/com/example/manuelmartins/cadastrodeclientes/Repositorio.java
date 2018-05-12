package com.example.manuelmartins.cadastrodeclientes;

public class Repositorio {
    private Cliente[] clientes;
    private int indice;

    public Repositorio(int tamanho) {
        clientes = new Cliente[tamanho];
        indice = 0;
    }

    private int procurarIndice(String codigo) {
        int i = 0;
        boolean achou;
        for (achou = false; !achou && i < indice; ) {
            if (clientes[i].getCodigo().equals(codigo)) {
                achou = true;
            } else {
                i++;
            }
        }
        if (!achou)
            i = -1;
        return i;
    }

    public Cliente procurar(String codigo) {
        Cliente c = null;
        int i = procurarIndice(codigo);
        if (i == -1) {
            return null;
        } else {
            c = clientes[i];
            return c;
        }
    }

    public boolean inserir(Cliente cliente) {
        if (indice < clientes.length) {
            if (cliente != null) {
                if (procurar(cliente.getCodigo()) == null) {
                    clientes[indice] = cliente;
                    indice = indice + 1;
                    return true;
                } else
                    throw new IllegalArgumentException("Cliente já cadastrado");
            } else {
                throw new NullPointerException("Cliente inválido");
            }
        } else
            return false;
    }
    public boolean atualizar(Cliente cliente){
        int i = procurarIndice(cliente.getCodigo());
        if(i != -1){
            clientes[i] = cliente;
                return true;
        } else {
            return false;
        }
    }

    public boolean remover(String codigo){
        int i = procurarIndice(codigo);
        if(i != -1){
            indice = indice -1;
            clientes[i] = clientes[indice];
            clientes[indice] = null;
                return true;
        }else{
            return false;
        }
    }

    public boolean existe(String codigo){
        int i = procurarIndice(codigo);
        return i != -1;
    }

}



