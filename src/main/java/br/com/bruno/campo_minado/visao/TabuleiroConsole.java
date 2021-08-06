package br.com.bruno.campo_minado.visao;

import br.com.bruno.campo_minado.excecao.ExplosaoException;
import br.com.bruno.campo_minado.excecao.SairException;
import br.com.bruno.campo_minado.modelo.Tabuleiro;

import java.util.Arrays;
import java.util.Iterator;
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

            while (!tabuleiro.objetivoAlcancado()) {
                System.out.println(tabuleiro.toString());

                String digitado = capturarValorDigitado("Digite (x, y)");

                Iterator<Integer> xy = Arrays.stream(digitado.split(","))
                        .map(e -> Integer.parseInt(e.trim())) // trim = remove os espaços em branco
                        .iterator();
                digitado = capturarValorDigitado("1 - para Abrir ou 2-(Des)Marcar: ");

                if ("1".equals(digitado)) {
                    tabuleiro.abrir(xy.next(), xy.next());
                } else if ("2".equals(digitado)) {
                    tabuleiro.abrir(xy.next(), xy.next());
                }

            }

            System.out.println("Você ganhou!");
        } catch (ExplosaoException e) {
            System.out.println("Você perdeu! ");
        }

    }

    private String capturarValorDigitado(String texto) {
        System.out.print(texto);
        String digitado = entrada.nextLine();

        if ("sair".equalsIgnoreCase(digitado)) {
            throw new SairException();
        }
        return digitado;
    }


}
