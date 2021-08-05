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
        associarVizinhos();
        sortearMinas();

    }


    //métodos
    private void gerarCampo() {
        for (int contadorLinha = 0; contadorLinha < linhas; contadorLinha++) {
            for (int contadorColuna = 0; contadorColuna < colunas; contadorColuna++) {
                campos.add(new Campo(contadorLinha, contadorColuna));
            }
        }
    }

    private void associarVizinhos() {
        for (Campo c1 : campos) {
            for (Campo c2 : campos) {
                c1.adicionarVizinho(c2);
            }
        }
    }

    private void sortearMinas() {

    }


}
