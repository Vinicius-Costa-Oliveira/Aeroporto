package simuladoraeroporto;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class testAterrisagem {

    Aterrisagem fila;

    @BeforeEach
    void inicializaFila() {
       fila = new Aterrisagem();
    }

    @Test
    void testEhVaziaComFilaVazia() {
        assertTrue(fila.ehVazia());
        assertEquals(0, fila.getTotalAvioes());
    }

    @Test
    void testAdiciona() {
        fila.adiciona();
        assertEquals(1, fila.getTotalAvioes());
        assertFalse(fila.ehVazia());

        fila.adiciona();
        assertEquals(2, fila.getTotalAvioes());
    }

    @Test
    void testRemoveComElementos() {
        fila.adiciona();
        fila.adiciona();
        fila.adiciona();

        fila.remove();

        assertEquals(2, fila.getTotalAvioes());
        assertFalse(fila.ehVazia());
    }

    @Test
    void testRemoveSemElementos() {
        fila.remove();
        assertEquals(0, fila.getTotalAvioes());
        assertTrue(fila.ehVazia());
    }

    @Test
    void testRemoveCriticoNoComeco() {
        Aviao aviaoCritico = new Aviao();
        fila.primeiroAviao = aviaoCritico;
        fila.totalAvioes = 1;

        while(aviaoCritico.getCombustivel() > 1) {
            aviaoCritico.opala();
        }
        fila.removeCritico();
        assertEquals(0, fila.getTotalAvioes());
    }

    @Test
    void testRemoveCriticoNoFinal() {
    	fila.adiciona();
    	fila.adiciona();
    	fila.adiciona();
    	fila.adiciona();

        while(fila.primeiroAviao.getCombustivel() > 1) {
            fila.primeiroAviao.opala();
        }
        fila.removeCritico();
        assertEquals(3, fila.getTotalAvioes());
    }

    @Test
    void testRemoveCriticoNoMeio() {
    	fila.adiciona();
    	fila.adiciona();
    	fila.adiciona();

        while(fila.primeiroAviao.getProximo().getCombustivel() > 1) {
        	fila.primeiroAviao.getProximo().opala();
        }
        fila.removeCritico();
        assertEquals(2, fila.getTotalAvioes());
    }
    
    @Test
    void testRemoveCombustivel() {
        Aviao aviao = new Aviao();
        fila.primeiroAviao = aviao;
        fila.totalAvioes = 1;
        
        int combustivel = aviao.getCombustivel();

        fila.removeCombustivel();

        assertEquals(combustivel - 1, aviao.getCombustivel());
    }

    @Test
    void testAdicionaTempoEspera() {
        Aviao aviao = new Aviao();
        fila.primeiroAviao = aviao;
        fila.totalAvioes = 1;

        fila.adicionaTempoEspera();

        assertEquals(1, aviao.getTempoEspera());
    }

    @Test
    void testTempoMedio() {
        Aviao aviao1 = new Aviao();
        aviao1.adicionaTempoEspera();
        aviao1.adicionaTempoEspera();
        aviao1.adicionaTempoEspera();
        aviao1.adicionaTempoEspera();
        aviao1.adicionaTempoEspera();
        Aviao aviao2 = new Aviao();
        aviao2.adicionaTempoEspera();
        aviao2.adicionaTempoEspera();
        aviao2.adicionaTempoEspera();
        aviao2.adicionaTempoEspera();
        fila.primeiroAviao = aviao1;
        aviao1.setProximo(aviao2);
        aviao2.setAnterior(aviao1);
        Aviao aviao3 = new Aviao();
        aviao3.adicionaTempoEspera();
        aviao3.adicionaTempoEspera();
        aviao3.adicionaTempoEspera();
        aviao3.adicionaTempoEspera();
        aviao3.adicionaTempoEspera();
        aviao3.adicionaTempoEspera();
        aviao3.adicionaTempoEspera();
        fila.ultimoAviao = aviao3;
        aviao3.setAnterior(aviao2);
        aviao2.setProximo(aviao3);
        fila.totalAvioes = 3;

        double tempoMedio = fila.tempoMedio();

        assertEquals(5.333333333333333, tempoMedio);
    }

    @Test
    void testVerNivelCritico() {
        Aviao aviaoCritico = new Aviao();
        fila.primeiroAviao = aviaoCritico;
        fila.totalAvioes = 1;
        
        while(aviaoCritico.getCombustivel() > 1) {
        	aviaoCritico.opala();
        }

        assertTrue(fila.verNivelCritico());
    }


    @Test
    void testVerPrimeiroItemComFilaVazia() {
        assertEquals(21, fila.verPrimeiroItem());
    }

    @Test
    void testVerPrimeiroItemComElementos() {
        Aviao aviao = new Aviao();
        fila.primeiroAviao = aviao;
        fila.totalAvioes = 1;

        assertEquals(aviao.getCombustivel(), fila.verPrimeiroItem());
    }
}
