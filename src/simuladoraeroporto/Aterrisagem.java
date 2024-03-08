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
	    if (ehVazia()) {
	        totalAvioes = 0;
	    } else if (totalAvioes == 1) {
	        totalAvioes = 0;
	    } else {
	        Aviao segundo = primeiroAviao.getProximo();

	        if (segundo != null) {
	            primeiroAviao = segundo;
	            segundo.setAnterior(null);

	            totalAvioes--;
	        }
	    }
	}
	
	public void removeCritico() {
        Aviao atual = primeiroAviao;

        while (atual != null) {
            if(atual.getCombustivel() == 1) {
                if(atual == primeiroAviao) {
                    if(totalAvioes == 1) {
                        totalAvioes = 0;
                        return;
                    }else {
                        Aviao segundo = primeiroAviao.getProximo();
                        segundo.setAnterior(null);
                        primeiroAviao = segundo;
                        totalAvioes--;
                        return;
                    }
                }else if(atual == ultimoAviao) {
                    Aviao penultimo = ultimoAviao.getAnterior();
                    penultimo.setProximo(null);
                    ultimoAviao = penultimo;
                    totalAvioes--;
                    return;
                }else {
                    Aviao proximo, anterior;
                    proximo = atual.getProximo();
                    anterior = atual.getAnterior ();
                    proximo.setAnterior(anterior);
                    anterior.setProximo(proximo);
                    totalAvioes--;
                    return;
                }
            }
            atual = atual.getProximo();
        }

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
	if(soma <= 0 || totalAvioes <= 0)	
            return 0;
        return mediaEspera;
        }

        
	public boolean verNivelCritico() {
        Aviao atual = primeiroAviao;

        while (atual != null) {
            if (atual.getCombustivel() == 1) {
                return true;
            }
            atual = atual.getProximo();
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
	    if (ehVazia() || primeiroAviao == null) 
	        return 21;
	    else
	        return primeiroAviao.getCombustivel();
	}
}
