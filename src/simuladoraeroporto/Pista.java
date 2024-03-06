package SimuladorAeroporto;

public class Pista {
	private Aterrisagem aterrisagem1;
        private Aterrisagem aterrisagem2;
	private Decolagem decolagem;
	private int menor;
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

	int qualEhMenor(){
		menor = aterrisagem1.getTotalAvioes();
		if(menor > aterrisagem2.getTotalAvioes())
			menor = aterrisagem2.getTotalAvioes();
			return menor;
	}

	void inserir(){
            if(menor == aterrisagem1.getTotalAvioes())
                aterrisagem1.adiciona();
            else
                aterrisagem2.adiciona();
	}
}
