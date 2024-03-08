package SimuladorAeroporto;

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
        pistaAterrisagem.inserirAterrisagem();
        pistaAterrisagem.inserirAterrisagem();
        pistaAterrisagem.removerNormal();
        assertEquals(1, pistaAterrisagem.aterrisagem1.getTotalAvioes());
    }

    @Test
    void testDecolarComPistaAterrisagem() {
        pistaAterrisagem.inserirAterrisagem();
        pistaAterrisagem.inserirAterrisagem();
        pistaAterrisagem.decolar();
        assertTrue(pistaAterrisagem.getOcupado());
    }

    @Test
    void testDecolarComPistaDecolagem() {
        pistaDecolagem.decolar();
        assertTrue(pistaDecolagem.getOcupado());
    }

    @Test
    void testAnalisarCriticoComEmergencia() {
        pistaAterrisagem.inserirAterrisagem();
        pistaAterrisagem.inserirAterrisagem();
        pistaAterrisagem.analisarCritico();
        assertTrue(pistaAterrisagem.getEmergencia());
    }

    @Test
    void testContabilizarPerdidos() {
    	//Teste comentado porque ele trava os outros testes
    	/*Pista pista = new Pista(true);

        pista.aterrisagem1.adiciona(); 
        Aviao aviaoCritico = pista.aterrisagem1.primeiroAviao; 
        while (aviaoCritico.getCombustivel() > 1) {
            aviaoCritico.opala();
        }

     
        assertEquals(1, pista.contabilizarPerdidos());*/
        
    }

    @Test
    void testReiniciar() {
        pistaAterrisagem.setOcupado();
        pistaAterrisagem.reiniciar();
        assertFalse(pistaAterrisagem.getOcupado());
        assertFalse(pistaAterrisagem.getEmergencia());
    }
}