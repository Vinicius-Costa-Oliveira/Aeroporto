package SimuladorAeroporto;

public class Aterrisagem {
	private int chegada, saida;
	Aviao aviao;
	
	public int getChegada() {
		return chegada;
	}
	
	public void setChegada(int chegada) {
		this.chegada = chegada;
	}
	
	public int getSaida() {
		return saida;
	}
	
	public void setSaida(int saida) {
		this.saida = saida;
	}
	
	public int calcular() {
		return getSaida() - getChegada();
	}
}
