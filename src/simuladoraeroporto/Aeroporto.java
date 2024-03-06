package SimuladorAeroporto;

public class Aeroporto {

	private int insere;
        Pista pista1 = new Pista();
        Pista pista2 = new Pista();
        Pista pista3 = new Pista();
                
        void inserir(){
            pista1.inserir();
            pista2.inserir();
            /*insere = pista1.qualEhMenor();

            if(insere > pista2.qualEhMenor())
                    pista2.inserir();

            else
                    pista1.inserir();	*/
	}
        
	public Aeroporto() {
            for(int i = 0; i < 10 ; i++){
                int qnt = (int)Math.floor(Math.random() * (3 - 1 + 1) + 1);
                for(int x = 0; x < qnt; x++)
                        inserir();
		pista1.mostrarTodos();
		pista2.mostrarTodos();
		pista3.mostrarTodos();
		}
	
	}


}
