package simuladoraeroporto;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testAeroporto {

    Aeroporto ae;

    @BeforeEach
    void inicializaFila() {
        ae = new Aeroporto();
    }

    @Test
    void testPista3Ocupada() {
    	ae.pista1.aterrisagem1.adiciona();
    	ae.pista1.aterrisagem2.adiciona();
    	ae.pista1.aterrisagem1.adiciona();
    	ae.pista3.decolagem.adiciona();

        while(ae.pista1.aterrisagem1.primeiroAviao.getCombustivel() > 1) {
        	ae.pista1.aterrisagem1.primeiroAviao.opala();
        }
        while(ae.pista1.aterrisagem2.primeiroAviao.getCombustivel() > 1) {
        	ae.pista1.aterrisagem2.primeiroAviao.opala();
        }
        while(ae.pista1.aterrisagem1.primeiroAviao.getProximo().getCombustivel() > 1) {
        	ae.pista1.aterrisagem1.primeiroAviao.getProximo().opala();
        }
        ae.pousarCriticos();
        assertEquals(1, ae.pista1.aterrisagem1.getTotalAvioes());
        assertEquals(0, ae.pista1.aterrisagem2.getTotalAvioes());
        assertEquals(1, ae.pista1.contabilizarPerdidos());
        assertTrue(ae.pista3.getOcupado());
        ae.pista3.decolar();
        assertEquals(1, ae.pista3.decolagem.getTotalAvioes());
        assertTrue(ae.pista1.getEmergencia());

    }

}
