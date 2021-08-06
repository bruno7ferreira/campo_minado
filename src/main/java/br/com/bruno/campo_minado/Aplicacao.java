package br.com.bruno.campo_minado;

import br.com.bruno.campo_minado.modelo.Tabuleiro;

public class Aplicacao {

    public static void main(String[] args) {

        Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);

        tabuleiro.abrir(3, 3);
        tabuleiro.alterarMarcacao(4, 5);

        System.out.println(tabuleiro);

    }

}
