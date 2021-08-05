package br.com.bruno.campo_minado.modelo;

import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {

    //atributos 
    private int linhas;
    private int colunas;
    private int minas;

    private final List<Campo> campos = new ArrayList<>();

    //Construtor
    public Tabuleiro(int linhas, int colunas, int minas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.minas = minas;

        gerarCampo();
        associarOsVizinhos();
        sortearMinas();

    }


    //métodos
    private void gerarCampo() {
    }

    private void associarOsVizinhos() {

    }

    private void sortearMinas() {

    }


}
