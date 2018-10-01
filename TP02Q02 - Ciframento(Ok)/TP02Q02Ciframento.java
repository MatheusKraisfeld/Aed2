class TP02Q02Ciframento {
   public static void main(String[]args){
      String[] array = new String[1000];
      int contEntrada = 0;
      //Leitura da entrada padrao
      do {
         array[contEntrada] = MyIO.readLine();
      } while (!(isFim(array[contEntrada++])));
      contEntrada--; 
      //Desconsiderar ultima linha contendo a palavra FIM
      for(int i = 0; i < contEntrada; i++){
         MyIO.println(ciframento(array[i]));
      }

   }

   public static String ciframento(String s){//metodo que vai inicializar as variaveis e chamar o prox metodo
      return ciframento(s,0);
   }

   public static String ciframento(String s,int cont){//metodo recursivo que vai retornar a string cifrada
      int x;
      String g;
      if (cont<s.length()) {
         x = (int)s.charAt(cont) + 3;
         g = (char) x + ciframento(s,cont+1);  
      }
      else{
         g = "";
      }
      return g;
   }

   public static boolean isFim(String s){//metodo feito para inicializar as variaveis do recursivo d baixo
      return isFim(s,0);
   }

   public static boolean isFim(String s,  int i){//metodo recursivo que verifica se a palvra eh de entrada eh igual a "FIM"
   boolean resp = false;
   String fim = "FIM";
   
   if (i == s.length()) {
      resp = true;
   }
   else if(s.charAt(i) == fim.charAt(i)){
      resp = isFim(s,i+1);
   }
   
   return resp;
}
}//fim class   
