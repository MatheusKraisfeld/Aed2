import java.util.Random;
public class TP01Q03Alteracao{

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

   public static String trocaChar(String s,char a,char b){//metodo vai fazer os char gerados e vai retornar a string ja alterada

   	String copia = "";

   	int tamanhoString = s.length();
   	for(int i = 0;i<tamanhoString;i++){
   		if(s.charAt(i) != a){
   			copia += s.charAt(i);
   		}
   		else{
   			copia += b;
   		}   
   	}
   	return copia;      
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



