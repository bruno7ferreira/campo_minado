package br.com.bruno.campo_minado.modelo;

import br.com.bruno.campo_minado.excecao.ExplosaoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void TesteValorPadraoAtributoMarcado() {
        assertFalse(campo.isMarcado());
    }

    @Test
    void testeAlternarMarcacao() {
        campo.alterarMarcacao();
        assertTrue(campo.isMarcado());
    }

//    @Test
//    void testeAlternarMarcacaoDuasVezes() {
//        campo.alterarMarcacao();
//        campo.alterarMarcacao();
//        assertTrue(campo.isMarcado());
//    }

    @Test
    void testeAbrirNaoMinadoNaoMarcado() {
        assertTrue(campo.abrir());
    }

    @Test
    void testeAbrirNaoMinadoMarcado() {
        campo.alterarMarcacao();
        assertFalse(campo.abrir());
    }

    @Test
    void testeAbrirMinadoMarcado() {
        campo.alterarMarcacao();
        campo.minar();
        assertFalse(campo.abrir());
    }

    @Test
    void testeAbrirMinadoNaoMarcado() {
        campo.minar();
        assertThrows(ExplosaoException.class, () -> { //testando se o tipo de exceção foi correto
            campo.abrir();
        });
    }

    @Test
    void testeAbrirComVizinhos() {
        Campo campo11 = new Campo(1, 1);
        Campo campo22 = new Campo(2, 2);

        campo22.adicionarVizinho(campo11);
        campo11.adicionarVizinho(campo22);
        campo11.abrir();
        campo22.abrir();

        assertTrue(campo22.isAberto() && campo11.isAberto());
    }

//    @Test
//    void testeAbrircomVizinho2() {
//        Campo campo11 = new Campo(1, 1);
//        Campo campo12 = new Campo(1, 1);
//        campo12.minar();
//
//        Campo campo22 = new Campo(2, 2);
//        campo22.adicionarVizinho(campo11);
//        campo22.adicionarVizinho(campo12);
//
//        campo.adicionarVizinho(campo22);
//        campo.abrir();
//
//        assertTrue(campo22.isAberto() && campo11.isFechado());
//    }


}
