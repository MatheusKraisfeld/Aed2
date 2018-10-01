
class Celula {

   //atributos
   Celula left, right, up, down;
   int value;

   //construtores
   public Celula(int value) {
      this.value = value;
   }

   public Celula() {
   
   }
}

public class Matriz {
   //atributos
   private Celula primeiro;
   private int linhas, colunas;
   
   //construtor;
   public Matriz(int linhas, int colunas){
   
      this.linhas = linhas;
      this.colunas = colunas;
      //cria a primeira linha da matriz;
      primeiro = criaLinha(colunas);
      
      for (int i = 1; i < linhas; i++) {
         primeiro = juntarLinha(criaLinha(colunas));//
      }
   }
   
   //gets da class matriz
   int getLinha(){
      return linhas;   
   }
   
   int getColuna(){
      return colunas;
   }
   
   private static Celula criaLinha(int tamLinha){//retorna sempre a primeira celula da matriz
      Celula c = new Celula();
      Celula cabeca = c;
      for (int i = 1; i < tamLinha; i++) {//liga horizontalmente as celulas   
         c.right = new Celula();
         c.right.left = c;
         c = c.right;
      }
      return cabeca;
   }

   //toda vez que esse metodo eh chamado, ele chama o 'criaLinha'(que cria uma nova linha e junta ela com a matriz ja criada
   private Celula juntarLinha(Celula x) {//recebe a primeira celula da matriz q acabou de ser criada pelo metodo de cima
      Celula cabeca = x; //cabeca aponta para a primeira celula da matriz que acabou de ser criada
      for (Celula y = primeiro; y != null; y = y.right, x = x.right) { //y aponta para a cabeca da matriz que ja existia antes
         y.up = x;
         x.down = y;
      }
      return cabeca;
      //como "primeiro = juntarLinha(..)" e o "juntarLinha(..)" retorna a cabeca, primeiro vai receber cabeca;
      //ou seja, apos juntar a linha nova com a matriz, o ponteiro primeiro vai subir
   }
   
   //printa a matriz
   public void mostrar(){
      Celula c = primeiro;
      
      for (int i = 0; i < linhas; i++) {
         Celula d = c;
         for (int j = 0; j < colunas; j++) {
            System.out.print(d.value + " ");
            d = d.right;
         }
         System.out.println("");
         c = c.down;
      }
   }
   
   //insere elementos na matriz
   public void inserir(int valor, int linha, int coluna){
      Celula c = primeiro;
      
      for (int i = 0; i < linha; i++) {
         c = c.down;
      }
      
      for (int i = 0; i < coluna; i++) {
         c = c.right;
      }
      
      c.value = valor;
   }
   
   //retorna o valor do elemento que esta na posicao que foi passada
   public int remv(int linha, int coluna){
      Celula c = primeiro;
      
      for (int i = 0; i < linha; i++) {
         c = c.down;
      }
      
      for (int i = 0; i < coluna; i++) {
         c = c.right;
      }
      
      return c.value;
   }

   
   //printa os numeros que estao na diagonal primaria;
   public void mostrarDiagPri(){
      Celula c = primeiro;
      for(int i = 0 ;i < getLinha() ; i++){
         System.out.print(c.value + " ");
         if(c.down != null){
            c = c.down.right;
         }
      }
   }
   
   //printa os numeros que estao na diagonal secundaria
   public void mostrarDiagSec(){
      Celula c = primeiro;
      for( ; c.right != null; c = c.right);
      for(int i = 0 ;i < getLinha() ; i++){
         System.out.print(c.value + " ");
         if(c.down != null){
            c = c.down.left;
         }
      }
   
   }

   //metodo que soma 2 matrizes
   public static Matriz soma(Matriz m1, Matriz m2){
      int linha = m1.getLinha();
      int coluna = m2.getColuna();
   
      Matriz m3 = new Matriz(linha, coluna);
   
      int resp;   
      for(int i = 0;i < linha;i++){
         for(int j = 0; j < coluna; j++){
            resp = m1.remv(i,j) + m2.remv(i,j);
            m3.inserir(resp,i,j); 
         }
      }
      return m3;
   }

   //metodo que multiplica 2 matrizes
   public static Matriz multiplicacao(Matriz m1, Matriz m2){
      int linha = m1.getLinha();
      int coluna = m2.getColuna();
   
      Matriz m3 = new Matriz(linha, coluna);
   
      int resp;
      int produto;
      for (int i = 0; i < linha; i++)
         for (int j = 0; j < coluna; j++) {
            resp = 0;
            for (int k = 0; k < coluna; k++) {
               produto = m1.remv(i,k) * m2.remv(k,j);
               resp += produto;
            }
            m3.inserir(resp,i,j);
         }
      return m3;
   
   }

   public static void main(String[] args) {
      int casos = MyIO.readInt();
      int linha , coluna;
      Matriz m , m4;
   
      for (int k = 0 ; k < casos ; k++ ) {
            
         linha = MyIO.readInt();
         coluna = MyIO.readInt();
         m = new Matriz(linha,coluna);
         m4 = new Matriz(linha,coluna);
      
         for (int i  = 0; i < linha ; i++ ) {
            for(int j = 0; j < coluna; j ++){
            
               int valor = MyIO.readInt();
               m.inserir(valor,i,j);
            }
         }
      
         linha = MyIO.readInt();
         coluna = MyIO.readInt();
         for (int i  = 0; i < linha ; i++ ) {
            for(int j = 0; j < coluna; j ++){
            
               int valor = MyIO.readInt();
               m4.inserir(valor,i,j);
            }
         }
      
         m.mostrarDiagPri();
         System.out.println("");
         m.mostrarDiagSec();
         System.out.println("");
         soma(m,m4).mostrar();
         multiplicacao(m,m4).mostrar();
      
      }
     
   
   }

}
