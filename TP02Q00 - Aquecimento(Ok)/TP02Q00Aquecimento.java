class TP02Q00Aquecimento {

 public static void main(String[] args) {
  String[] array = new String[1000];
  int contEntrada = 0;

  //Leitura da entrada padrao
  do {
   array[contEntrada] = MyIO.readLine();
  } while (!(isFim(array[contEntrada++])));
  contEntrada--; //Desconsiderar ultima linha contendo a palavra FIM

  //Para cada linha de entrada, gerando uma de saida contendo o numero de letras maiusculas da entrada
  for (int i = 0; i < contEntrada; i++) {
   MyIO.println(contarLetrasMaiusculas(array[i]));
  }
 }

 public static boolean ehMaiuscula(char c) { //Verifica se o caractere e maiusculo ou nao;
  return (c >= 'A' && c <= 'Z');
 }
 public static int contarLetrasMaiusculas(String s) { //chama o metodo recursivo e inicializa as variaveis;
  return contarLetrasMaiusculas(s, 0, 0);
 }
 public static int contarLetrasMaiusculas(String s, int i, int resp) { //metodo recursivo que retorna o numero de letras  maiusculas na string

  if (i < s.length()) {
   if (ehMaiuscula(s.charAt(i))) {
    resp = 1 + contarLetrasMaiusculas(s, i + 1, resp);
   } else {
    resp = 0 + contarLetrasMaiusculas(s, i + 1, resp);
   }
  }
  return resp;
 }

 public static boolean isFim(String s) { //chama o metodo recursivo e inicializa o contador
  return isFim(s, 0);
 }

 public static boolean isFim(String s, int i) { //metodo recursivo que verifica se a palvra eh de entrada eh igual a "FIM"
  boolean resp = false;
  String fim = "FIM";

  if (i == s.length()) {
   resp = true;
  } else if (s.charAt(i) == fim.charAt(i)) {
   resp = isFim(s, i + 1);
  }

  return resp;
 }

}
