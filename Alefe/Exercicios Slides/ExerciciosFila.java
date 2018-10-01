class Celula{
   public Celula right;
   public int value;
   
   public Celula(){
   
   }
   public Celula(int value){
      this.value = value;
   }
}

class Fila{
   private Celula first;
   private Celula last;
   
    
   
   public Fila(){
      first = new Celula();
      last = first;
   }
   
   public void inserir(int value){
      last.right = new Celula(value);
      last = last.right;
   }
   
   public int remover(){
      int resp = first.value;
      Celula tmp = first;
      first = first.right;
      tmp.right = null;
      tmp = null;
      return resp;
   }
   
   public void mostrar(){
      Celula i = first;
      for(i = first;i != null;i = i.right){
         System.out.print(i.value+" ");
      }
   }
  //metodo iterativo para pegar o maior valor 
   public int getMaior(){
      Celula i = first;
      int maior = i.value;
      for(i = first; i != null;i = i.right){
         if(i.value > maior){
            maior = i.value;
         }
      }
      return maior;
   }
   
   //metodo recursivo para pegar maior valor
   public int getMaiorRec(){
      return getMaiorRec(first,first.value);
   }
   
   public int getMaiorRec(Celula i, int maior){
      if(i != null){
         if(i.value > maior){
            maior = i.value;
         }
         maior = getMaiorRec(i.right , maior);
      }
      return maior;   
   }
   
   public void inverterFila2(){
      Celula tmp = first;
      first = first.right;
      tmp.right = null;
      last.right = tmp;
      last = last.right;
      tmp = null;
      mostrar();
   }
   //metodo que inverte a fila;
   public void inverterFila(){
   		
   } 
      //System.out.println(tamanhoFila());
      mostrar();
   }
   //metodo que retorna o tamanho da fila;
   public int tamanhoFila(){
      int cont = 0;
      for(Celula i = first;i != null; i = i.right){
         cont++;
      }
      return cont;
   }
}

class ExerciciosFila{
   public static void main(String[]args){
      Fila P = new Fila();
      for(int i = 7;i>1;i--){
         P.inserir(i);
      }
      //P.remover(); //Primeira remocao = remove o no cabeca
      P.mostrar();
      System.out.println("");
      int x = P.getMaior();
      System.out.print("getMaior :"+x+"\n");
      int y = P.getMaiorRec();
      System.out.print("getMaiorRec :"+y+"\n");
      
      P.inverterFila2();
      System.out.println("");
      P.inverterFila2();
      System.out.println("");
      P.inverterFila2();
System.out.println("");
      P.inverterFila2();
System.out.println("");
      P.inverterFila2();
System.out.println("");
      P.inverterFila2();

      

     
   
   }
}
