package SimuladorAeroporto;

public class Aeroporto {

	private int insere;
        Pista pista1 = new Pista(true);
        Pista pista2 = new Pista(true);
        Pista pista3 = new Pista(false);
                
        void inserir(){
           insere = pista1.qualEhMenor();

            if(insere > pista2.qualEhMenor())
                    pista2.inserir();

            else
                    pista1.inserir();
	}
        
	public Aeroporto() {
            for(int i = 0; i < 1 ; i++){
                int qnt = (int)Math.floor(Math.random() * (3));
                for(int x = 0; x < qnt; x++)
                        inserir();
                System.out.println("Pista 1:");
		pista1.mostrarTodos();
                System.out.println("\n");
                System.out.println("Pista 2:");
		pista2.mostrarTodos();
                System.out.println("\n");
                System.out.println("Pista 3:");
		pista3.mostrarTodos();
                System.out.println("\n");
		}
	
	}


}
