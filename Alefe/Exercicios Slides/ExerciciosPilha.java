class Celula{
   public Celula right;
   public int value;
   
   public Celula(){
   
   }
   
   public Celula(int value){
      this.value = value;
   }
}

class Pilha{
   private Celula topo;
   private int cont;
   
   public Pilha(){
      topo = null;
   }
   
   public void inserir(int elemento){
      Celula tmp = new Celula(elemento);
      tmp.right = topo;
      topo = tmp;
      tmp = null;
   }
   
   public int remover(){
      if(topo == null){
         System.out.println("erro");
      }
      Celula i = topo;
      int resp = topo.value;
      topo = topo.right;
      i.right = null;
      i = null;
      return resp;
      
   }
   //mostra na ordem que vai sair
   public void mostrar(){
      Celula i;
      for(i = topo;i != null ;i = i.right){
         System.out.print(i.value + " ");
      }   
   }
   
   //mostra na ordem que vai sair(recursivo)
   public void mostrarRec(){
      mostrarRec(topo);
   }
   
   public void mostrarRec(Celula i){
      if(i != null){
         System.out.print(i.value+ " ");
         mostrarRec(i.right);
      }
      
   }
   
   //mostra na ordem inversa(recursivo)
   public void mostrarRecInverso(){
      mostrarRecInverso(topo);
   }
   
   public void mostrarRecInverso(Celula i){
      if(i != null){
         mostrarRecInverso(i.right);
         System.out.print(i.value+ " ");
      }
      
   }
   
   //metodo iterativo para mostrar de forma inversa;
   public void mostrarInverso(){
      int tam = tamanhoPilha() - 1 , contador = 0, j = 0;
      Celula i = topo;
      while(k < tamanhoPilha()){
         for(j = 0; j < tam  ; j++ , i = i.right);
         System.out.print(i.value+ " ");
         tam--;
         contador++;
         i = topo;
      }
   }
   public int tamanhoPilha(){
      int tamanho = 0;
      for(Celula i = topo; i != null;i = i.right){
         tamanho++;
      }
      return tamanho;
   }
   //metodo iterativo que retorna o maior valor
   public int getMaior(){
      Celula i = topo;
      int maior = i.value;
      for(; i != null ; i = i.right){
         if(i.value > maior){
            maior = i.value;
         }
      }
      return maior;   
   }
   
   //metodo recursivo que retorna o maior valor
   public int getMaiorRec(){
      return getMaiorRec(topo,topo.value);
   }
   
   public int getMaiorRec(Celula i , int maior){
      if(i!=null){
         if(i.value > maior){
            maior = i.value;
         }
         maior = getMaiorRec(i.right , maior);
      
      }
      return maior;
   }

   
   //metodo iterativo que soma os elementos da pilha
   public void soma(){
      Celula i;
      int soma = 0;
      for(i = topo; i != null ; i = i.right){
         soma += i.value;
      }
      System.out.println("Soma = "+soma);
   }
   
   //metodo recursivo que soma os elementos da pilha
   public int somaRec(){
      return somaRec(topo);
   }
   
   public int somaRec(Celula i){
      int soma = 0;
      if(i != null){
         soma = somaRec(i.right);
         soma = soma + i.value;
      
      }
      return soma;
      
   }   
}

class ExerciciosPilha{
   public static void main(String[]args){
      Pilha P = new Pilha();
      P.inserir(10);
      for(int i = 7;i>1;i--){
         P.inserir(i);
      }
      P.remover();
      P.inserir(11);
      //pilha{4,3,2,1};
      P.mostrar();
      System.out.println("");
      P.mostrarRec();
      //mostrar na ordem inversa
      System.out.println("");
      P.mostrarRecInverso();
      System.out.println("");
      P.mostrarInverso();
      System.out.println("");
      P.soma();
      System.out.println("");
      int x = P.somaRec();
      System.out.print("Soma Rec = "+x);
      System.out.println("");
      int y = P.getMaior();
      System.out.print("getMaior = "+y); 
      System.out.println("");
      int z = P.getMaiorRec();
      System.out.print("getMaiorRec = "+z);
      System.out.println("");
      P.mostrarInverso();
   
   
   }
}