import java.util.Random;
public class TP02Q03Alteracao{

   public static void main(String[]args){
      String[] array = new String[1000];
      Random gerador = new Random();
      gerador.setSeed(4);
      int contEntrada = 0;
      //Leitura da entrada padrao;
      do {
         array[contEntrada] = MyIO.readLine();
      } while (!(isFim(array[contEntrada++])));
      contEntrada--;//Desconsiderar a ultima linha contendo a palavra FIM
      for(int i = 0; i < contEntrada; i++){
         char a = geraChar1(gerador);      
         char b = geraChar1(gerador);
         MyIO.println(trocaChar(array[i],a,b));
      }
   }

   public static char geraChar1(Random gerador){//gera uma letra aleatoria;
      char a = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
      return a;
   }

   public static String trocaChar(String s,char a,char b){//metodo que vai inicializar o contador do recursivo;
      return trocaChar(s,a,b,0);
   }
   public static String trocaChar(String s,char a,char b, int i){//metodo que vai fazer a troca de char
      if(i<s.length()){
         if(s.charAt(i) != a){
            return s.charAt(i) + trocaChar(s,a,b,i+1);
         }
         else{
            return b + trocaChar(s,a,b,i+1);
         }
      }
      else{
         return "";
      }   
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
