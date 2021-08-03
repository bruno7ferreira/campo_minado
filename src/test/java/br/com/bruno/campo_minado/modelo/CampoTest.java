package br.com.bruno.campo_minado.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CampoTest {

    private Campo campo; //instanciando o campo

    @BeforeEach
        // beforeEwach = para cada método chamará uma função
    void iniciarCampo() {
        campo = new Campo(3, 3); //atribuindo valor ao campo
    }


    // testando vizinhos da direcional
    @Test
    void testeVizinhoDistancia1Esquerda() {
        Campo vizinho = new Campo(3, 2); //instanciando o objeto campo
        boolean resultado = campo.adicionarVizinho(vizinho); //adicionando o vizinho

        assertTrue(resultado); //verifica se o resultado é true
    }

    @Test
    void testeVizinhoDistancia1Direita() {
        Campo vizinho = new Campo(3, 4); //instanciando o objeto campo
        boolean resultado = campo.adicionarVizinho(vizinho); //adicionando o vizinho

        assertTrue(resultado); //verifica se o resultado é true
    }

//    @Test
//    void testeVizinhoDistancia1Emcima() {
//        Campo vizinho = new Campo(2, 3);
//        boolean resultado = campo.adicionarVizinho(vizinho);
//        assertTrue(resultado);
//    }
//
//    @Test
//    void testeVizinhoDistancia1Embaixo() {
//        Campo vizinho = new Campo(4, 4);
//        boolean resultado = campo.adicionarVizinho(vizinho);
//
//        assertTrue(resultado);
//    }

    //testando vizinhos da diagonal
    @Test
    void testeVizinhoDistancia2() {
        Campo vizinho = new Campo(2, 2);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testeNaoVizinho() {
        Campo vizinho = new Campo(1, 2);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertFalse(resultado);
    }

}
