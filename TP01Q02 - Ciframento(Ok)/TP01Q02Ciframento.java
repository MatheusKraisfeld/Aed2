class TP01Q02Ciframento{
   public static void main(String[]args){
     String[] array = new String[1000];
      int contEntrada = 0;
      //Leitura da entrada padrao
      do {
         array[contEntrada] = MyIO.readLine();
      } while (!(isFim(array[contEntrada++])));
      contEntrada--;//Desconsiderar ultima linha contendo a palavra FIM
      for(int i = 0; i < contEntrada; i++){
         MyIO.println(ciframento(array[i]));
      }
   }
   
   public static String ciframento(String s){//metodo que retorna a string ja cifrada
      String g = "";
      int a = 0;
      for(int i = 0;i<s.length();i++){
         a = (int)s.charAt(i) + 3;
         g += (char) a;  
      }
      return g;
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

}
