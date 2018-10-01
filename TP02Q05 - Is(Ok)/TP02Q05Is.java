class TP02Q05Is {
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

   public static boolean ehVogal(String s){//metodo que vai inicializar as variaveis e chamar o prox metodo
      return ehVogal(s,0);
   }

   public static boolean ehVogal(String s, int i){//metodo recursivo que verifica se a string so tem vogal
      boolean resp = false;
      if (i < s.length()) {
         if((s.charAt(i) != 'A' && s.charAt(i) != 'E' && s.charAt(i) != 'I' && s.charAt(i) != 'O' && s.charAt(i) != 'U' && s.charAt(i) != 'a' && s.charAt(i) != 'e' && s.charAt(i) != 'i' && s.charAt(i) != 'o' && s.charAt(i) != 'u') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')){
            resp = false;
         }
         else{
            resp = ehVogal(s,i+1);
         }            
      }
      else{
         resp = true;
      }
      return resp;
   }
   
   public static boolean ehConsoante(String s){//metodo que vai inicializar as variaveis e chamar o prox metodo
      return ehConsoante(s,0);
   } 

   public static boolean ehConsoante(String s, int i){//metodo recursivo que verifica se a string so tem consoante
      boolean resp;
      if (i<s.length()) {
         if((s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U' || s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')){
            resp = false;
         }
         else{
            resp = ehConsoante(s,i+1);
         }
      }
      else{
         resp = true;
       }
      return resp;
   }     
      
   public static boolean ehInteiro(String s){//metodo que vai inicializar as variaveis e chamar o prox metodo
      return ehInteiro(s,0);
   }
   public static boolean ehInteiro(String s,int i){//metodo recursivo que verifica se a string eh um inteiro
      boolean resp;
      if(i<s.length()){
         if((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')){
            resp = false;
         }
         else if((s.charAt(i) == '.' || s.charAt(i) == ',' )){
            resp = false;
         }
         else{
            resp = ehInteiro(s,i+1);
         }      
      }
      else{
         resp = true;
      }   
      return resp;
   }

   public static boolean ehReal(String s){//metodo que vai inicializar as variaveis e chamar o prox metodo
      return ehReal(s,0,0);
   }
   
   public static boolean ehReal(String s,int i,int cont){//metodo recursivo que verifica se a string eh um real
      boolean resp;
      if(i<s.length()){
         if((s.charAt(i) == '.' || s.charAt(i) == ',' )){
            cont++;
         }   
         if((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')){
            resp = false;
         }
         else{
            resp = ehReal(s,i+1,cont);
         }
                  
      }
      else{
         if(cont>=2){
            resp = false;
         }
         else{   
            resp = true;
         }
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
}
