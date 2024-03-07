package SimuladorAeroporto;
public class Aviao {
	
	public static int ultimoId = 0;

	private int id, combustivel, tempoEspera = 0;
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
	
	public int getTempoEspera() {
		return tempoEspera;
	}
	
	public void setTempoEspera(int tempoEspera) {
		this.tempoEspera = tempoEspera;
	}
	
	public void adicionaTempoEspera() {
		tempoEspera++;
	}
	
	public int getUltimoId() {
		return ultimoId;
	}
}
 