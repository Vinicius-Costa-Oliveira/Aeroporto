package simuladoraeroporto;

public class Decolagem {
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
		if(!ehVazia()) {
			
		if(totalAvioes == 1) {
			totalAvioes = 0;
		}else {
			Aviao segundo = primeiroAviao.getProximo();
			segundo.setAnterior(null);
			primeiroAviao = segundo;
			totalAvioes--;
		}
        }
	}
	
	public double tempoMedio() {
		double mediaEspera = 0, soma = 0;
		
		
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
        
        public void adicionaTempoEspera() {
        Aviao atual = primeiroAviao;

        while (atual != null) {
            atual.adicionaTempoEspera(); 
            atual = atual.getProximo(); 
        }
	}
	
	public void print() {
		Aviao atual = primeiroAviao;
		while (atual != null) {
			System.out.println("Aviao: " + atual.getId());
			atual = atual.getProximo(); 
		}
	}
}
