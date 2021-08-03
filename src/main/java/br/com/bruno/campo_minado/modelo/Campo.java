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

        int deltaLinha = Math.abs(this.linha - vizinho.linha); // retorna o número absoluto
        int deltaColuna = Math.abs(this.coluna - vizinho.coluna); // retorna o número absoluto
        int deltaGeral = deltaColuna + deltaLinha;

        if (deltaColuna == 1 && !diagonal) {
            vizinhos.add(vizinho);
            return true;
        } else if (deltaGeral == 2 & diagonal) {
            vizinhos.add(vizinho);
            return true;
        } else {
            return false;
        }
    }

    void alterarMarcacao() {
        if (!aberto) {
            this.marcado = !marcado;
        }
    }


}
