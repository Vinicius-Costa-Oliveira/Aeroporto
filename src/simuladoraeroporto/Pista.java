package SimuladorAeroporto;

public class Pista {
	private Aterrisagem aterrisagem1, aterrisagem2;
	private Decolagem decolagem;
	private int menor;
	

	void mostrarTodos(){
		aterrisagem1.print();
		aterrisagem2.print();
		decolagem.print();
	}

	int qualEhMenor(){
		menor = aterrisagem1.getTotalAvioes();
		if(menor > aterrisagem2.getTotalAvioes())
			menor = aterrisagem2.getTotalAvioes();
			return menor;
	}

	void inserir(){
            aterrisagem1.adiciona();
            aterrisagem2.adiciona();
            decolagem.adiciona();
		/*if(menor == aterrisagem1.getTotalAvioes())
			aterrisagem1.adiciona();
		else
			aterrisagem2.adiciona();*/
	}
}
