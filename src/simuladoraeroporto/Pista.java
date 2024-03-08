package SimuladorAeroporto;

public class Pista {
        Aterrisagem aterrisagem1;
        Aterrisagem aterrisagem2;
	Decolagem decolagem;
	private int menorAt;
        private boolean id;
        private boolean ocupado;
        private boolean emergencia;
	
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
                System.out.println("Aterrisagem 1 (TmpMed: " + aterrisagem1.tempoMedio() + "):");
                aterrisagem1.print();
                System.out.println("\n");
                System.out.println("Aterrisagem 2 (TmpMed: " + aterrisagem2.tempoMedio() + "):");
                aterrisagem2.print();
                System.out.println("\n");
            }
            System.out.println("Decolagem (TmpMed: " + decolagem.tempoMedio() + "):");
            decolagem.print();
	}
	
	void removerCombustivelDeTodos() {
		aterrisagem1.removeCombustivel();
		aterrisagem2.removeCombustivel();
        }
        
	void aumentarTempoEsperaDeTodos() {
            if(id){
		aterrisagem1.adicionaTempoEspera();
		aterrisagem2.adicionaTempoEspera();
            }
		decolagem.adicionaTempoEspera();
		
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
        
        void analisarCritico(){
   
            if(aterrisagem1.verNivelCritico()){
                aterrisagem1.removeCritico();
                ocupado = true;
            }
            if(aterrisagem2.verNivelCritico() && !ocupado){
                aterrisagem2.removeCritico();
                ocupado = true;
            }
            else if(aterrisagem2.verNivelCritico() && ocupado)
                emergencia = true;
            
        }
        
        void removerNormal(){

            if(!getOcupado()){
                if(aterrisagem1.verPrimeiroItem() <= aterrisagem2.verPrimeiroItem())
                    aterrisagem1.remove();
                else
                    aterrisagem2.remove();
            }
            
        }
        
        void decolar(){
            if(id){
                if(!getOcupado() && aterrisagem1.verPrimeiroItem() > 10 && aterrisagem2.verPrimeiroItem() > 10 ){
                    decolagem.remove();
                    ocupado = true;
                }
            }
            else{
                if(!getOcupado()){
                    decolagem.remove();
                    ocupado = true;
                }
            }
        }
        
        
        public int contabilizarPerdidos(){
        	int perdidos = 0;
            
            while(aterrisagem1.verNivelCritico())
                perdidos++;
            while(aterrisagem2.verNivelCritico())
                perdidos++;
            
            return perdidos; 
        }
        
        void reiniciar(){
            ocupado = false;
            emergencia = false;
        }
        
        void setOcupado(){
            ocupado = true;
        }
        
        boolean getOcupado(){
            return ocupado;
        }
        
        boolean getEmergencia(){
            return emergencia;
        }
}
