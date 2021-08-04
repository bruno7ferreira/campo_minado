package br.com.bruno.campo_minado.modelo;

import br.com.bruno.campo_minado.excecao.ExplosaoException;

import java.security.PublicKey;
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

    boolean abrir() {
        if (!aberto && !marcado) { // abrindo um campo do jogo
            this.aberto = true;

            if (minado) { //abrir um campo minado, fim de jogo
                throw new ExplosaoException();
            }

            if (vizinhancaSegura()) {
                vizinhos.forEach(v -> abrir()); // abre o campo, caso a vizinhaça esteja segura
            }
            return true;
        } else {
            return false;
        }
    }

    boolean vizinhancaSegura() {
        return vizinhos.stream()
                .noneMatch(v -> v.minado); // verifica se algum vizinho está minado
    }

    void minar() {
        if (!minado) {
            this.minado = true; //deixa o campo minado
        }
    }


    //get and set
    public boolean isMarcado() {
        return marcado;
    }

    public boolean isAberto() {
        return aberto;
    }

    public boolean isMinado() {
        return minado;
    }

    public boolean isFechado() {
        return !isMinado();
    }
}
