package SimuladorAeroporto;

public class Aterrisagem {
	Aviao primeiroAviao, ultimoAviao;
	int totalAvioes = 0;
	
	public boolean ehVazia() {
		if(totalAvioes == 0) {
			return true;
		}else return false;
	}
	
	public void adiciona(Aviao novoAviao) {
		Aviao novo = new Aviao();
		if(ehVazia()) {
			primeiroAviao = novo;
			ultimoAviao = novo;
		}else {
			novo.setProximo(null);
			novo.setAnterior(ultimoAviao);
			ultimoAviao.setProximo(novo);
			ultimoAviao = novo;
		}
		totalAvioes++;
	}
	
	public void remove() {
		if(ehVazia()) {
			throw new IllegalArgumentException("Fila Vazia.");
		}else if(totalAvioes == 1) {
			totalAvioes = 0;
		}else {
			Aviao segundo = primeiroAviao.getProximo();
			segundo.setAnterior(null);
			primeiroAviao = segundo;
			totalAvioes--;
		}
	}
	
	public void removeCritico(Aviao aviao) {
		if (totalAvioes == 1) {
	        totalAvioes = 0;
	        primeiroAviao = null; 
	    } else {
	        Aviao atual = primeiroAviao;
	        while (atual != aviao) {
	            atual = atual.getProximo();
	        }
	        Aviao anterior = atual.getAnterior();
	        Aviao proximo = atual.getProximo();
	        if (atual == primeiroAviao) {
	            primeiroAviao = proximo;
	        }
	        anterior.setProximo(proximo);
	        if (proximo != null) {
	            proximo.setAnterior(anterior);
	        }
	        totalAvioes--;
	    }
	}
	
	public void removeCombustivel() {
		Aviao atual = primeiroAviao;

        while (atual != null) {
            atual.opala(); 
            atual = atual.getProximo(); 
        }
	}
	
	public double tempoMedio() {
		double mediaEspera = 0, aux = 0, soma = 0;
		
		
		Aviao aviaoAtual = primeiroAviao;

        while (aviaoAtual != null) {
            soma = soma + aviaoAtual.getTempoEspera(); 
            aviaoAtual = aviaoAtual.getProximo(); 
            aux++;
        }
        
        mediaEspera = soma/aux;
		
		return mediaEspera;
	}
	
	public Aviao verNivelCritico() {
		 Aviao atual = primeiroAviao;

	        while (atual != null) {
	            if (atual.getCombustivel() == 1) {
	                return atual; 
	            }
	            atual = atual.getProximo();
	        }

	        return null;
	}
	
	public void print() {
		Aviao atual = primeiroAviao;
		
	System.out.println("Aterrisagem:");
		
		while (atual != null) {
			System.out.println("Aviao: " + atual.getId() + " || Combustivel: " + atual.getCombustivel());
			atual = atual.getProximo(); 
		}
	}

	public int verPrimeiroItem() {
		return primeiroAviao.getCombustivel();
	}
}
