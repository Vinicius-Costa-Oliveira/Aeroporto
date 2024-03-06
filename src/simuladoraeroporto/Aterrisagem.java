package SimuladorAeroporto;

public class Aterrisagem {
	Aviao primeiroAviao, ultimoAviao;
	int totalAvioes = 0;
	
	public int getTotalAvioes() {
		return totalAvioes;
	}

	public boolean ehVazia() {
		if(totalAvioes == 0) {
			return true;
		}else return false;
	}
	
	public void adiciona() {
		Aviao novo = new Aviao();
	    if (ehVazia()) {
	        primeiroAviao = novo;
	        ultimoAviao = novo;
	    } else {
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
	
	public void removeCritico() {
	    Aviao atual = primeiroAviao;

	    while (atual != null) {
	        if (atual.getCombustivel() <= 1) {
	            Aviao proximo = atual.getProximo();
	            Aviao anterior = atual.getAnterior();

	            if (anterior == null) {
	                primeiroAviao = proximo;
	            } else {
	                anterior.setProximo(proximo);
	            }

	            if (proximo != null) {
	                proximo.setAnterior(anterior);
	            }

	            return; 
	        }

	        atual = atual.getProximo();
	    }
	    totalAvioes--;
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
	
	public boolean verNivelCritico() {
	    Aviao atual = primeiroAviao;

	    while (atual != null) {
	        if (atual.getCombustivel() <= 1) {
	            return true; 
	        }
	        atual = atual.getProximo();
	    }

	    return false; 
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
	    if (ehVazia()) {
	        throw new IllegalStateException("Fila vazia.");
	    }
	    return primeiroAviao.getCombustivel();
	}
}
