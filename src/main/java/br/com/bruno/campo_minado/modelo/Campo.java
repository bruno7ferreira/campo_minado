package br.com.bruno.campo_minado.modelo;

import java.util.ArrayList;
import java.util.List;

public class Campo {

    //atributos
    private final int linha;
    private final int coluna;

    private boolean minado;
    private boolean aberto;
    private boolean marcado;

    //campos vizinhos
    private List<Campo> vizinhos = new ArrayList<>();


    //construtor
    Campo(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    //métodos
    boolean adicionarVizinho(Campo vizinho) {
        boolean linhaDiferente = this.linha != vizinho.linha;
        boolean colunaDiferente = this.coluna != vizinho.coluna;
        boolean diagonal = linhaDiferente && colunaDiferente;
        return true;
    }


}
