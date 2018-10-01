class TP01Q05Is {
   public static void main(String[]args){
      String[] array = new String[1000];
      int contEntrada = 0;
      //Leitura da entrada padrao;
      do {
         array[contEntrada] = MyIO.readLine();
      } while (!(isFim(array[contEntrada++])));
      
      contEntrada--;//Desconsiderar a ultima linha contendo a palavra FIM   

      for(int i = 0; i < contEntrada; i++){
         if(ehVogal(array[i])){
            System.out.print("SIM");
         }
         else{
            System.out.print("NAO");
         }
         
         if(ehConsoante(array[i])){
            System.out.print(" SIM");
         }
         else{
            System.out.print(" NAO");
         }

         if(ehInteiro(array[i])){
            System.out.print(" SIM");
         }
         else{
            System.out.print(" NAO");
         }

         if(ehReal(array[i])){
            System.out.print(" SIM\n");
         }
         else{
            System.out.print(" NAO\n");
         }
      }
   }



   public static boolean ehVogal(String s){//metodo que verifica se a string soh possui vogal;
      boolean tof = true;
      int tamanhoString = s.length();
      for(int i = 0; i<tamanhoString; i++){
         if(s.charAt(i) != 'A' && s.charAt(i) != 'E' && s.charAt(i) != 'I' && s.charAt(i) != 'O' && s.charAt(i) != 'U' && s.charAt(i) != 'a' && s.charAt(i) != 'e' && s.charAt(i) != 'i' && s.charAt(i) != 'o' && s.charAt(i) != 'u'){
            tof = false;
         }
         if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
           tof = false;
        }
     }
     return tof;
   }//fim metodo;
   
   public static boolean ehConsoante(String s){//metodo que verifica se a string soh possui consoante;
      boolean tof = true;
      int tamanhoString = s.length();
      for(int i = 0; i<tamanhoString; i++){
         if(s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U' || s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u'){
            tof = false;
         }
         if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
           tof = false;
        }
     }
     return tof;
   }//fim metodo;
   
  public static boolean ehInteiro(String s){//metodo que verifica se a String que chegou eh ou nao um numero inteiro;
   int cont = 0;
   boolean tof = true;
   int tamanhoString = s.length();
   for(int i = 0; i<tamanhoString; i++){
      if( (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')){
         tof = false;
      }
      if( (s.charAt(i) == '.' || s.charAt(i) == ',' )){
         cont++;
      }
      if(cont > 0){
         tof = false;
      }      
   }
   
   return tof;
   }//fim metodo;
   
   public static boolean ehReal(String s){//metodo que verifica se a String que chegou eh ou nao um numero real;
      boolean tof = true;
      int cont = 0;
      int tamanhoString = s.length();
      for(int i = 0; i<tamanhoString; i++){
         if( (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')){
            tof = false;
         }
         if( (s.charAt(i) == '.' || s.charAt(i) == ',' )){
            cont++;
         }
         if(cont > 1){
            tof = false;
         }      
      }
      return tof;
   }//fim metodo;

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
   }//fim metodo

}//fim class
