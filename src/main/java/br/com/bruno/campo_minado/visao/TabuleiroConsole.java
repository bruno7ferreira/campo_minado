package br.com.bruno.campo_minado.visao;

import br.com.bruno.campo_minado.excecao.ExplosaoException;
import br.com.bruno.campo_minado.excecao.SairException;
import br.com.bruno.campo_minado.modelo.Tabuleiro;

import java.util.Scanner;

public class TabuleiroConsole {

    //atributo
    private Tabuleiro tabuleiro;
    private Scanner entrada = new Scanner(System.in);

    //construtor
    public TabuleiroConsole(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;

        executarJogo();
    }

    private void executarJogo() {
        try {
            boolean continuar = true;

            while (continuar) {
                cicloDoJogo();
                System.out.println("Quer outra partida? (S/n)");
                String respota = entrada.nextLine();
                if ("n".equalsIgnoreCase(respota)) {
                    continuar = false;
                } else {
                    tabuleiro.reiniciar();
                }
            }
        } catch (SairException e) {
            System.out.println("Thau!");
        } finally {
            entrada.close();
        }
    }

    private void cicloDoJogo() {
        try {
            System.out.println("Você ganhou!");
        } catch (ExplosaoException e) {
            System.out.println("Você perdeu! ");
        }

    }


}
