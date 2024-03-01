package SimuladorAeroporto;
public class Aviao {
	private static int ultimoId = 0;

	private int id, combustivel, chegada, saida;
	Aviao anterior, proximo;
	
	
	public Aviao(){
		id = ultimoId; 
		combustivel = (int)Math.floor(Math.random() * (20 - 1 + 1) + 1);
		System.out.println(combustivel);
		ultimoId++;
	}
	
	public int getId() {
		return id;
	}
	
	public int getCombustivel() {
		return combustivel;
	}
	
	public void opala() {
		combustivel--;
	}
	
	public Aviao getAnterior() {
		return anterior;
	}
	
	public void setAnterior(Aviao anterior) {
		this.anterior = anterior;
	}
	
	public Aviao getProximo() {
		return proximo;
	}
	
	public void setProximo(Aviao proximo) {
		this.proximo = proximo;
	}
	
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
}
 