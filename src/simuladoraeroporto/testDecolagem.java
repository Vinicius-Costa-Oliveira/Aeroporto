package simuladoraeroporto;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testDecolagem {

    Decolagem fila;

    @BeforeEach
    void inicializaFila() {
        fila = new Decolagem();
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
    void testAdicionaTempoEspera() {
        // Criar avião
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
        Aviao aviao2 = new Aviao();
        aviao2.adicionaTempoEspera();
        fila.primeiroAviao = aviao1;
        aviao1.setProximo(aviao2);
        fila.totalAvioes = 2;

        double tempoMedio = fila.tempoMedio();

        assertEquals(1.0, tempoMedio);
    }

}