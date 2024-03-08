package simuladoraeroporto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testPista {

    Pista pistaAterrisagem;
    Pista pistaDecolagem;

    @BeforeEach
    void inicializaPistas() {
        pistaAterrisagem = new Pista(true);
        pistaDecolagem = new Pista(false);
    }

    @Test
    void testInserirAterrisagem() {
        pistaAterrisagem.inserirAterrisagem();
        assertEquals(1, pistaAterrisagem.aterrisagem1.getTotalAvioes());
    }

    @Test
    void testRemoverNormal() {
        pistaAterrisagem.aterrisagem1.adiciona();
        pistaAterrisagem.aterrisagem1.adiciona();
        pistaAterrisagem.removerNormal();
        assertEquals(1, pistaAterrisagem.aterrisagem1.getTotalAvioes());
    }

    @Test
    void testDecolarComPistaAterrisagem() {
        pistaAterrisagem.aterrisagem1.adiciona();
        pistaAterrisagem.decolar();
        assertTrue(pistaAterrisagem.getOcupado());
    }

    @Test
    void testDecolarComPistaDecolagem() {
    	pistaDecolagem.decolagem.adiciona();
        pistaDecolagem.decolar();
        assertTrue(pistaDecolagem.getOcupado());
    }

    @Test
    void testAnalisarCriticoComEmergencia() {

        pistaAterrisagem.aterrisagem1.adiciona(); 
        pistaAterrisagem.aterrisagem2.adiciona(); 

        while (pistaAterrisagem.aterrisagem1.primeiroAviao.getCombustivel() > 1) {
            pistaAterrisagem.aterrisagem1.primeiroAviao.opala();
        }
        
        while (pistaAterrisagem.aterrisagem2.primeiroAviao.getCombustivel() > 1) {
            pistaAterrisagem.aterrisagem2.primeiroAviao.opala();
        }
        
        pistaAterrisagem.analisarCritico();
        
        assertTrue(pistaAterrisagem.getEmergencia());
    }

    @Test
    void testContabilizarPerdidos() {
    	
        pistaAterrisagem.aterrisagem1.adiciona(); 

        while (pistaAterrisagem.aterrisagem1.primeiroAviao.getCombustivel() > 1) {
            pistaAterrisagem.aterrisagem1.primeiroAviao.opala();
        }

        assertEquals(1, pistaAterrisagem.contabilizarPerdidos());
        
    }

    
    
    @Test
    void testReiniciar() {
        pistaAterrisagem.setOcupado();
        pistaAterrisagem.reiniciar();
        assertFalse(pistaAterrisagem.getOcupado());
        assertFalse(pistaAterrisagem.getEmergencia());
    }
}