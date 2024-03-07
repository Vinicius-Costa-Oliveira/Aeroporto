package simuladoraeroporto;

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
		/*if(ehVazia()) {
			throw new IllegalArgumentException("Fila Vazia.");
		}else 
                        PARTE QUE SERA REMOVIDA DO CODIGO, SO PERMANECE PARA 
                    SEU ENTENDIMENTO*/
                if(totalAvioes == 1) {
		if(!ehVazia()) {
			
		if(totalAvioes == 1) {
			totalAvioes = 0;
		}else {
			Aviao segundo = primeiroAviao.getProximo();


			primeiroAviao = segundo;
			totalAvioes--;
		}
        }
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
	
	public void adicionaTempoEspera() {
		Aviao atual = primeiroAviao;

        while (atual != null) {
            atual.adicionaTempoEspera(); 
            atual = atual.getProximo(); 
        }
	}
	
	public double tempoMedio() {
	double mediaEspera, soma = 0;
		
		
		Aviao aviaoAtual = primeiroAviao;

        while (aviaoAtual != null) {
            soma += aviaoAtual.getTempoEspera(); 
            aviaoAtual = aviaoAtual.getProximo(); 
        }
        mediaEspera = soma / totalAvioes;
	if(soma != 0 && totalAvioes > 0)	
		return mediaEspera;
	return 0;
        }

        
	public boolean verNivelCritico() {
            if(totalAvioes > 0){
	    Aviao atual = primeiroAviao;

	    while (atual != null) {
	        if (atual.getCombustivel() <= 1) {
	            return true; 
	        }
	        atual = atual.getProximo();
	    }
            }
	    return false; 
	}
	
	
	public void print() {
		Aviao atual = primeiroAviao;

		while (atual != null) {
			System.out.println("Aviao: " + atual.getId() + " || Combustivel: " + atual.getCombustivel());
			atual = atual.getProximo(); 
		}
	}

	public int verPrimeiroItem() {
	    if (ehVazia()) 
	        return 21;
	    
            else
	    return primeiroAviao.getCombustivel();
	}
}
