package br.com.bruno.campo_minado;

import br.com.bruno.campo_minado.modelo.Tabuleiro;
import br.com.bruno.campo_minado.visao.TabuleiroConsole;

public class Aplicacao {

    public static void main(String[] args) {

        Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);

        new TabuleiroConsole(tabuleiro);


    }

}
