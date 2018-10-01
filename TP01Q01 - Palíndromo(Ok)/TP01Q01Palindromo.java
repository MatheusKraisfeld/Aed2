class TP01Q01Palindromo {
   public static void main(String[]args){
      String[] array = new String[1000];
      int numEntrada = 0;
      //Leitura da entrada padrao
      do {
         array[numEntrada] = MyIO.readLine();
      } while (!(isFim(array[numEntrada++])));
      numEntrada--;   
      //Desconsiderar ultima linha contendo a palavra FIM
      for(int i = 0; i < numEntrada; i++){
         if(ehPalindromo(array[i])){
            MyIO.println("SIM");
         }
         else{
            MyIO.println("NAO"); 
         }
      }     

   }

   public static boolean isFim(String s){//verifica se a string que recebeu eh 'FIM'
      String fim = "FIM";
      boolean resp = false;
      
      if(s.length() == fim.length()){
          resp = true;
         
         for (int i = 0;i<fim.length();i++) {
            if (s.charAt(i) != fim.charAt(i)) {
               resp = false;
            }
         }

      }
      return resp;
   }

   public static boolean ehPalindromo(String s){//metodo iterativo para verificar se a String e um palindromo
      boolean tof = true;
      int cont1 = 0;
      int cont2 = s.length() - 1;
      
      char A;
      char B;
      
      for(cont1=0;cont1<cont2;cont1++){
         A = s.charAt(cont1);
         B = s.charAt(cont2);

         if(A != B){
            tof = false;
         }
         cont2--;
      }
      return tof;
   }
}         
