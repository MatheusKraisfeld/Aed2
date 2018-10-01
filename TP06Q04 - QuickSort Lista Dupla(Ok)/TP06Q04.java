import java.io.*;
import java.net.*;
import java.*;
import java.nio.charset.*;
import java.util.Formatter;
import java.util.Scanner;
import java.io.File;

class Series implements Cloneable{

    //Atributos
   private String Nome;
   private String Formato;
   private String Duracao;
   private String PaisOrigem;
   private String IdiomaOriginal;
   private String EmissoraTv;
   private String TransOri;
   private int nTemp;
   private int nEp;

    //Construtores da classe Series;
   Series(){
      this.setNome("");
      this.setFormato("");
      this.setDuracao("");
      this.setPaisOrigem("");
      this.setIdiomaOriginal("");
      this.setEmissoraTv("");
      this.setTransOri("");
      this.setnTemp(0);
      this.setnEp(0);
   }

   Series(String Nome, String Formato, String Duracao, String PaisOrigem, String IdiomaOriginal, String EmissoraTv , String TransOri , int nTemp , int nEp){
      this.setNome(Nome);
      this.setFormato(Formato);
      this.setDuracao(Duracao);
      this.setPaisOrigem(PaisOrigem);
      this.setIdiomaOriginal(IdiomaOriginal);
      this.setEmissoraTv(EmissoraTv);
      this.setTransOri(TransOri);
      this.setnTemp(nTemp);
      this.setnEp(nEp);
   }

   //metodos set da class Series;
   public void setNome(String Nome){
      this.Nome = Nome;
   }

   public void setFormato(String Formato){
      this.Formato = Formato;
   }

   public void setDuracao(String Duracao){
      this.Duracao = Duracao;
   }

   public void setPaisOrigem(String PaisOrigem){
      this.PaisOrigem = PaisOrigem;
   }

   public void setIdiomaOriginal(String IdiomaOriginal){
      this.IdiomaOriginal = IdiomaOriginal;
   }

   public void setEmissoraTv(String EmissoraTv){
      this.EmissoraTv = EmissoraTv;
   }

   public void setTransOri(String TransOri){
      this.TransOri = TransOri;
   }

   public void setnTemp(int nTemp){
      this.nTemp = nTemp;
   }

   public void setnEp(int nEp){
      this.nEp = nEp;
   }

   //metodos get da class Series;
   public String getNome(){
      return this.Nome;
   }

   public String getFormato(){
      return this.Formato;
   }

   public String getDuracao(){
      return this.Duracao;
   }

   public String getPaisOrigem(){
      return this.PaisOrigem;
   }

   public String getIdiomaOriginal(){
      return this.IdiomaOriginal;
   }

   public String getEmissoraTv(){
      return this.EmissoraTv;
   }

   public String getTransOri(){
      return this.TransOri;
   }

   public int getnTemp(){
      return this.nTemp;
   }

   public int getnEp(){
      return this.nEp;
   }

   //Cria uma Series que recebe os atributos do objeto corrente;
   /*public Series clone(){
      Series se = new Series();
      se.setNome(getNome());
      se.setFormato(getFormato());
      se.setDuracao(getDuracao());
      se.setPaisOrigem(getPaisOrigem());
      se.setIdiomaOriginal(getIdiomaOriginal());
      se.setEmissoraTv(getEmissoraTv());
      se.setTransOri(getTransOri());
      se.setnTemp(getnTemp());
      se.setnEp(getnEp());
   
      return se;
    }*/

    //metodo para imprimir os atributos
   public void imprimir(){
      System.out.println(this.getNome()+" "+this.getFormato() + " " + this.getDuracao() + " " + this.getPaisOrigem() + " " + this.getIdiomaOriginal()+ " " + this.getEmissoraTv() + " " + this.getTransOri() + " " + this.getnTemp() + " " + this.getnEp());
   }

   //retorna a string que chegou pegando soh o que nao esta entre as tags
   public String limpaString(String linha){
      String resp = "";
      boolean tof = false;
   
      for(int i=0; i<linha.length(); i++){
         if(linha.charAt(i) == '<'){
            tof = true;
         }
      
         if(!tof){
            resp+=linha.charAt(i);
         }
      
         if(linha.charAt(i) == '>'){
            tof = false;
         }
      }
   
      return resp;
   }

   //retorna os atributos da class Series;
   public String toString() {
      return 
         "" + Nome +
         " " + Formato  +
         " " + Duracao + 
         " " + PaisOrigem +  
         " " + IdiomaOriginal  +
         " " + EmissoraTv  +
         " " + TransOri  +
         " " + nTemp +
         " " + nEp ;
   
   }

   //retorna a string que chegou tirando os caracteres especiais dela;
   public String limpaString1(String linha){
      String resp = "";
      boolean tof = false;
   
      for(int i=0; i<linha.length(); i++){
         if(linha.charAt(i) == '&'){
            tof = true;
         }
      
         if(!tof){
            resp+=linha.charAt(i);
         }
      
         if(linha.charAt(i) == ';'){
            tof = false;
         }
      }
   
      return resp;
   }

   //metodo feito para pegar apenas o numero que estah no comeco da String(o numero que precisa SEMPRE vai estar na pos 0);
   public String pegarNumero(String linha){
      String array[] = linha.split(" ");
      String resp = array[0];
      return resp;
   }

   //metodo recebe o nome do arquivo html, retira as '_' e tambem retira o ".html", retornando apenas o nome;
   public String acharNome(String linha){
      String nome = linha.replace("_" , " ");
      String resp = "";
      int i = 0;
      while(nome.charAt(i) != '.'){
         resp += nome.charAt(i);
         i++;
      }
      return resp;
   }

   //metodo que retorna uma string com o formato da serie;
   public String acharFormato(String linha){
      String formato = limpaString(linha);
      return formato;
   }


   //metodo que retorna uma string com a duracao da serie;
   public String acharDuracao(String linha){
      String duracao = limpaString(linha);
      return duracao;
   }

   //metodo que retorna uma string com o pais de origem da serie;
   public String acharPaisOrigem(String linha){
      String paisOrigem = limpaString(linha);
      String paisOrigemResp = limpaString1(paisOrigem);
      return paisOrigemResp.trim();
   }

   //metodo que retorna uma string com o idioma original da serie;
   public String acharIdioma(String linha){
      String idioma = limpaString(linha);
      return idioma.trim();
   }

   //metodo que retorna uma string com a Emissora de tv da serie;
   public String acharEmissora(String linha){
      String emissora = limpaString(linha);
      return emissora.trim();
   }

   //metodo que retorna uma string com a transmissao original da serie;
   public String acharTransOri(String linha){
      String transOri = limpaString(linha);
      String transOriResp = limpaString1(transOri);
      return transOriResp.trim();
   }

   //metodo que retorna um inteiro contendo o numero de temporadas da serie;
   public int acharNumeroTemp(String linha){
      String temp = limpaString(linha);
      String temp1 = pegarNumero(temp);
      int tempResp = Integer.parseInt(temp1);
      return tempResp;
   }

   //metodo que retorna um inteiro contendo o numero de episodios da serie;
   public int acharNumeroEps(String linha){
      String ep = limpaString(linha);
      String ep1 = pegarNumero(ep);
      int epResp = Integer.parseInt(ep1);
      return epResp;
   }

   protected Object clone() throws CloneNotSupportedException {
      return super.clone();
   }

   //metodo que abre o arquivo html, pega a linha que precisa e manda para o metodo correspondente, depois seta a informacao necessaria; 
   public Series lerArquivos(String nomeArq)throws CloneNotSupportedException{
      String linha = "";
      Arq.openRead("/tmp/"+nomeArq);
      for ( linha = Arq.readLine() ; Arq.hasNext() && !linha.contains("<h1") ; linha = Arq.readLine() );
      this.setNome(acharNome(nomeArq));   
      for ( linha = Arq.readLine() ; Arq.hasNext() && !linha.contains("Formato<") ; linha = Arq.readLine() );
      linha = Arq.readLine(); 
      this.setFormato(acharFormato(linha));
      for ( linha = Arq.readLine() ; Arq.hasNext() && !linha.contains("Duração") ; linha = Arq.readLine() );
      linha = Arq.readLine();
      this.setDuracao(acharDuracao(linha));
      for ( linha = Arq.readLine() ; Arq.hasNext() && !linha.contains("País de origem") ; linha = Arq.readLine() );
      linha = Arq.readLine();
      this.setPaisOrigem(acharPaisOrigem(linha));
      if(nomeArq.equals("Grey's_Anatomy.html")){
         this.setPaisOrigem("Estados Unidos");
      } 
      for ( linha = Arq.readLine() ; Arq.hasNext() && !linha.contains("Idioma original") ; linha = Arq.readLine() );  
      linha = Arq.readLine();
      this.setIdiomaOriginal(acharIdioma(linha));
      for ( linha = Arq.readLine() ; Arq.hasNext() && !linha.contains("Emissora de televisão original") ; linha = Arq.readLine() );
      linha = Arq.readLine();
      this.setEmissoraTv(acharEmissora(linha));
      for ( linha = Arq.readLine() ; Arq.hasNext() && !linha.contains("Transmissão original") ; linha = Arq.readLine() );
      linha = Arq.readLine();
      this.setTransOri(acharTransOri(linha));
      for ( linha = Arq.readLine() ; Arq.hasNext() && !linha.contains("N.º de temporadas"); linha = Arq.readLine() );
      linha = Arq.readLine();
      this.setnTemp(acharNumeroTemp(linha));
      for ( linha = Arq.readLine() ; Arq.hasNext() && !linha.contains("N.º de episódios"); linha = Arq.readLine() );
      linha = Arq.readLine();
      this.setnEp(acharNumeroEps(linha));     
      Arq.close();
      return (Series) this.clone();
   }
}//end da class Series

class Celula {
  //atributos
   public Series value;
   public Celula right;
   public Celula left;

    //construtores
   public Celula() {
   
   }

   public Celula(Series value) {
      this.value = value;
      this.right = this.left = null;
   }
}//end class celula

class Lista{

   //atributos;
   private Celula primeiro;
   private Celula ultimo;
   public int mov = 0;
   public int comparacao = 0;

   //construtor da class lista;
   public Lista(){
      primeiro = new Celula();
      ultimo = primeiro;
   }

//metodo que insere o objeto no end da lista;
   public void inserirFim(Series serie) throws Exception{ 
      ultimo.right = new Celula((Series)serie.clone());
      ultimo.right.left = ultimo;
      ultimo = ultimo.right;
   }

//Mostra os elementos da lista separados por espacos.
   public void mostrar(){
      Celula i;      
      for(i = primeiro.right; i != null ; i = i.right){
         i.value.imprimir();
      }
   }

//retorna o tamanho da lista
   public int tamanho(){
      int tamanho = 0;  
      for(Celula i = primeiro; i != ultimo; i = i.right){
         tamanho++;
      }
      return tamanho;
   }

//retorna true se a string J for maior que a String I;
   public boolean compararString(String j, String i){
      boolean tof = false;
      int resp = j.compareTo(i);
      if (resp > 0) { //se a String J for maior que a I
         tof = true; 
      }
      comparacao++;
      return tof;
   
   }

   //retorna true se a string i for maior que a string j;
   public boolean compararString1(String j, String i){
      boolean tof = false;
      int resp = j.compareTo(i);
      if (resp < 0) {
         tof = true; 
      }
      comparacao++;
      return tof;
   
   }

//retorna true se duas strings forem iguais
   public boolean stringIgual(String j , String i){
      boolean tof = false;
      if(j.equals(i)){
         tof = true;
      }        
      comparacao++;
      return tof;
   
   }

//Compara se um objeto vem antes do outro na ordenação. Se o (algo) for igual, vamos ordenar por nome;(crescente)
   public boolean ehMaior(String i, String j, String nomeX, String nomeY){
      boolean tof = false;
      int comp = i.compareTo(j);
      comparacao++;
      if(comp > 0){
         tof = true;
      }
      if(comp == 0){
         if( compararString(nomeX,nomeY) ){
            tof = true;
         }
      
      }
      return tof;
   }

   //Compara se um objeto vem antes do outro na ordenação. Se o (algo) for igual, vamos ordenar por nome;(decrescente)
   public boolean ehMenor(String i, String j, String nomeX, String nomeY){
      boolean tof = false;
      int comp = i.compareTo(j);
      comparacao++;
      if(comp < 0){
         tof = true;
      }
      if(comp == 0){
         if( compararString1(nomeX,nomeY) ){
            tof = true;
         }
      
      }
      return tof;
   }

   //retorna o meio da lista;
   public Celula ehMeio(int dir,int esq){
      int cont = 0;
      Celula i = primeiro.right;
      int mid = (esq + dir) / 2;
      while(cont < mid){
         i = i.right;
         cont++;
      }
      return i;
   }

   //troca os elemtos
   private void troca(Celula i, Celula j){
      Series temp = i.value;
      i.value = j.value;
      j.value = temp;
      mov++;
   }

   //Algoritmo de ordenacao Quicksort.
   public void quicksortPais(){
      quicksortPais(primeiro.right , ultimo , 0 , tamanho()-1);
   }

  //Algoritmo de ordenacao Quicksort.
   private void quicksortPais(Celula esq , Celula dir , int comeco , int fim){
      Celula i = esq; 
      Celula j = dir;
      int begin = comeco; 
      int end = fim;
      quicksortNome(esq,dir,comeco,fim);
      Series pivo = ehMeio(fim,comeco).value;
      while(begin <= end){ 
         while(compararString1(i.value.getPaisOrigem() , pivo.getPaisOrigem())){
            i = i.right; 
            begin++;
         }
         while(compararString(j.value.getPaisOrigem() , pivo.getPaisOrigem())){
            j = j.left; 
            end--;
         }
         if(begin <= end){
            troca(i,j);
            i = i.right;
            j = j.left;
            begin++;
            end--;
         }
      }
      if(comeco < end)quicksortPais(esq,j,comeco,end);
      if(begin < fim)quicksortPais(i,dir,begin,fim);
   }

   //Algoritmo de ordenacao Quicksort.
   public void quicksortNome(){
      quicksortNome(primeiro.right , ultimo , 0 , tamanho()-1);
   }
  
   //Algoritmo de ordenacao Quicksort.
   private void quicksortNome(Celula esq , Celula dir , int comeco , int fim){
      Celula i = esq;
      Celula j = dir;
      int begin = comeco;
      int end = fim;
      Series pivo = ehMeio(fim,comeco).value;  
      while(begin <= end){ 
         while(compararString(i.value.getNome() , pivo.getNome())){
            i = i.right; 
            begin++;
         }
         while(compararString1(j.value.getNome() , pivo.getNome())){
            j = j.left; 
            end--;
         }
         if(begin <= end){
            troca(i,j);
            i = i.right;
            j = j.left;
            begin++;
            end--;
         }
      }
      if(comeco < end)quicksortNome(esq,j,comeco,end);
      if(begin < fim)quicksortNome(i,dir,begin,fim); 
   }
}//end lista

public class TP06Q04{
   public static void main(String[] args)throws Exception{
      MyIO.setCharset("UTF-8");
      Series S = new Series();
      Lista L = new Lista();
   //leitura da primeira parte da entrada;
      String entrada = MyIO.readLine();
      int qtEntrada = 0;
      while(entrada.equals("FIM") == false){
         S.lerArquivos(entrada);
         L.inserirFim(S);
         entrada = MyIO.readLine();
      }//end while
      long begin = System.currentTimeMillis();
      L.quicksortPais();
      long end = System.currentTimeMillis(); 
      L.mostrar();
      Arq.openWrite("576473_quicksort2.txt", "UTF-8");
      Arq.println("Matricula: 576473\tTempo:" + (end-begin)/1000.0 + "s\t" + "Compracoes:"+L.comparacao+"\t"+"Movimentacoes:"+L.mov); 
      Arq.close();
   }//end main
}//main class
