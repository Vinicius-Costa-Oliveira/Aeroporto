package SimuladorAeroporto;

public class Aeroporto {

	private int insereAt, insereDc, temp, mortos = 0;
        Pista pista1 = new Pista(true);
        Pista pista2 = new Pista(true);
        Pista pista3 = new Pista(false);
        
        public static void main(String[] args) {
        Aeroporto ae = new Aeroporto();
            for(int i = 0; i < 5 ; i++){
               ae.inserirAterrisagem();
               ae.inserirDecolagem();
               ae.pousarCriticos();
               ae.contabilizar();
               ae.decolarAvioes();
               ae.pousarAvioes();
               ae.combustivel();
               ae.tela(i+1);
               ae.tempo();
               ae.recomecar();
            }
    }
        
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
           
               switch (insereDc) {
                   case 1 -> pista1.decolagem.adiciona();
                   case 2 -> pista2.decolagem.adiciona();
                   default -> pista3.decolagem.adiciona();
               }
	}
       }
        
        void tela(int turno){
                System.out.println("-----------------------------------------");
                System.out.println("\t\tTurno " + turno);
                System.out.println("\tTotal de Avioes Perdidos: " + mortos);
                System.out.println("\nPista 1:\n");
		pista1.mostrarTodos();
                System.out.println("\n");
                System.out.println("~~~~~~~~~~");
                System.out.println("Pista 2:\n");
		pista2.mostrarTodos();
                System.out.println("\n");
                System.out.println("~~~~~~~~~~");
                System.out.println("Pista 3:\n");
		pista3.mostrarTodos();
                System.out.println("\n");
        }
        
        void combustivel(){
            pista1.removerCombustivelDeTodos();
            pista2.removerCombustivelDeTodos();
        }
        
        void tempo(){
            pista1.aumentarTempoEsperaDeTodos();
            pista2.aumentarTempoEsperaDeTodos();
            pista3.aumentarTempoEsperaDeTodos();
        }
        
        void pousarCriticos(){
            pista1.analisarCritico();
            if(pista1.getEmergencia()){
                pista1.aterrisagem2.removeCritico();
                pista3.setOcupado();
            }
            
            pista2.analisarCritico();
            if(pista2.getEmergencia() && !pista3.getOcupado()){
                pista1.aterrisagem2.removeCritico();
            }
        }
      
        void pousarAvioes(){
            pista1.removerNormal();
            pista2.removerNormal();
        }
        
        void decolarAvioes(){
            pista1.decolar();
            pista2.decolar();
            pista3.decolar();
        }
        
        void contabilizar(){
            mortos += pista1.contabilizarPerdidos();
            mortos += pista2.contabilizarPerdidos();
        }
        
        void recomecar(){
            pista1.reiniciar();
            pista2.reiniciar();
            pista3.reiniciar();
        }
}
        

