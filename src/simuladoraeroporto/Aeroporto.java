package SimuladorAeroporto;

public class Aeroporto {

	private int insereAt, insereDc, temp;
        Pista pista1 = new Pista(true);
        Pista pista2 = new Pista(true);
        Pista pista3 = new Pista(false);
        
        int aleatorio(int min, int max){
            return (int)Math.floor(Math.random() * (max - min + min) + min);
        }
        
        void inserirAterrisagem(){
           int qnt = aleatorio(0, 3);
           
           for(int x = 0; x < qnt; x++){
		
            insereAt = pista1.qualEhMenorAterrisagem();

            if(insereAt > pista2.qualEhMenorAterrisagem())
                    pista2.inserirAterrisagem();

            else
                    pista1.inserirAterrisagem();
            }
        }
        
        void inserirDecolagem(){ 
           int qnt = aleatorio(0, 3);
           
           for(int x = 0; x < qnt; x++){
           temp = pista1.decolagem.getTotalAvioes();
           insereDc = 1;
           if(temp > pista2.decolagem.getTotalAvioes()){
               temp = pista2.decolagem.getTotalAvioes();
               insereDc = 2;
           }
           if(temp > pista3.decolagem.getTotalAvioes()){
               temp = pista3.decolagem.getTotalAvioes();
               insereDc = 3;
           }
           
           if(insereDc == 1)
               pista1.decolagem.adiciona();
           else if(insereDc == 2)
                pista2.decolagem.adiciona();
           else
                pista3.decolagem.adiciona();
	}
       }
        
        void tela(){
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
        
	public Aeroporto() {
            for(int i = 0; i < 1 ; i++){
                inserirAterrisagem();
                inserirDecolagem();
            
                tela();
            }
        }
}
