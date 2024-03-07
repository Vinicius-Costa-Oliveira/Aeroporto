package SimuladorAeroporto;

public class Pista {
        Aterrisagem aterrisagem1;
        Aterrisagem aterrisagem2;
	Decolagem decolagem;
	private int menorAt;
        private boolean id;
	
        public Pista(boolean id){
            this.id = id;
            if(id){
                aterrisagem1 = new Aterrisagem();
                aterrisagem2 = new Aterrisagem();
            }
        decolagem = new Decolagem();
        }

	void mostrarTodos(){
            if(id){
                System.out.println("Aterrisagem 1:");
		aterrisagem1.print();
                System.out.println("\n");
                System.out.println("Aterrisagem 2:");
		aterrisagem2.print();
                System.out.println("\n");
            }
                System.out.println("Decolagem:");
		decolagem.print();
                System.out.println("\n");
	}

	int qualEhMenorAterrisagem(){
		menorAt = aterrisagem1.getTotalAvioes();
		if(menorAt > aterrisagem2.getTotalAvioes())
			menorAt = aterrisagem2.getTotalAvioes();
			return menorAt;
	}

	void inserirAterrisagem(){
            if(menorAt == aterrisagem1.getTotalAvioes())
                aterrisagem1.adiciona();
            else
                aterrisagem2.adiciona();
	}
        
}
