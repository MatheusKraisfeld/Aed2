class TP02Q01Palindromo {
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
         if(ehPalindromo(array[i])){
            MyIO.println("SIM");
         }
         else{
            MyIO.println("NAO"); 
         }
      }     
   
   }
   public static boolean ehPalindromo(String s){//metodo feito para inicializar as variaveis do recursivo d baixo
      return ehPalindromo(s,0,s.length()-1);
   }

	
   public static boolean ehPalindromo(String s, int i, int f){//metodo recursivo que verifica se a palavra eh um palindormo
      boolean resp = false;
   	
      if(i > f){
         resp = true;
      }
      else if(s.charAt(i) == s.charAt(f)){
         resp = ehPalindromo(s,i+1,f-1);
      }
      else if(s.charAt(i) != s.charAt(f)){
         resp = false;
      }
      return resp;
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
