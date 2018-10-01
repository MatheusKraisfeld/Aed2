class Hash{
   int[] array;
   final int tamTab = 21;
   final int tamReserva = 9;
   int contReserva;
   public Hash(){
      int tamTotal = this.tamTab + this.tamReserva;
   	
      array = new int[tamTotal];		
   
      for(int i = 0;i < tamTotal;i++){
         array[i] = -1;
      }
   	
      contReserva = 0;
      
   }
   
 
	//retorna a posicao que vai inserir	
   public int funcaoHash(int x){
      int resp = (x % this.tamTab);
      return resp;
   }

	//retorna true se conseguir inserir	
   public boolean inserir(int x){
      boolean resp = false;
   	
      if(x != -1){
         int pos = funcaoHash(x);
         if(array[pos] == -1){
            array[pos] = x;
            
            resp = true;
         }
         else{
            if(contReserva < tamReserva){
               array[tamTab + contReserva] = x;
               contReserva++;
               resp = true;
            }
         	
         }
      }
      else{
         System.out.println("x = -1");
      }
      return resp;			
   }

   public boolean pesquisar(int x){
      boolean tof = false;
   
      int pos = funcaoHash(x);
   
      if(array[pos] == x){
         tof = true;
      }
      
      else{
         for(int i = 0; i <  contReserva; i++){
            if(array[tamTab + i] == x){
               tof = true;
               i = contReserva; //break
            }
         } 
      }
   
      return tof;
   }

   public void mostrar(){
      System.out.println("ENTROU:");
   
      for (int i = 0;i < tamTab ;i++ ) {
         if(array[i] != -1){
            System.out.println("Normal: "+array[i]);
         }
      }
      //olhar a area reserva;
      for(int j = 0; j < contReserva;j++){
         System.out.println("Reserva: "+array[tamTab + j]);		
      }
   }

	
   public void remover(int x){
      boolean tof = false;
   
      int pos = funcaoHash(x);
   	//verificar se o elemento e igual ao que esta no array[pos]
      if(array[pos] == x){
      	//verificar se tal elemento esta na area de reserva
         array[pos] = -1;
         for(int i = 0; i < contReserva;i++){
         	//verificar se o elemento da reserva tem mod = pos
            int mod = funcaoHash(array[tamTab + i]);
            if(mod == pos){
               array[pos] = array[tamTab + i];
               array[tamTab + i] = -1;
               contReserva--;
               i = contReserva;
            }
         }
      }
      else{
         System.out.println("NAO POSSUI O ELEMENTO PARA REMOVER");
      }
   
   }
}//fim class Hash

class Teste2{
   public static void main(String[]args){
      Hash hash = new Hash();
      hash.inserir(1);
      hash.mostrar();
      hash.remover(4);
      //hash.mostrar();
      hash.inserir(3);
      hash.mostrar();
   
   }
}