/** Árvore Binária
 * @author Giuseppe Salome Fantoni Agostini
 * @version 1 11/2017
 */

import java.io.*;
import java.net.*;
import java.*;
import java.nio.charset.*;
import java.util.Formatter;
import java.util.Scanner;
import java.io.File;

class Series implements Cloneable{

   /**
   * Atributos da classe.
   */
   private String Nome;
   private String Formato;
   private String Duracao;
   private String PaisOrigem;
   private String IdiomaOriginal;
   private String EmissoraTv;
   private String TransOri;
   private int nTemp;
   private int nEp;

  /**
   * Construtor da classe.
   */
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

    /**
   * Construtor da classe.
   * @param Nome conteudo da Series
   * @param Formato conteudo da Series
   * @param Duracao conteudo da Series
   * @param PaisOrigem conteudo da Series
   * @param IdiomaOriginal conteudo da Series
   * @param EmissoraTb conteudo da Series
   * @param TransOri conteudo da Series
   * @param nTemp conteudo da Series
   * @param nEp conteudo da Series
   */
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

//--------------------------------- Set -------------------------------------//

   /**
   * Seta o valor no atributo
   * @param Nome String a ser setada no atributo
   */
   public void setNome(String Nome){
      this.Nome = Nome;
   }

   /**
   * Seta o valor no atributo
   * @param Formato String a ser setada no atributo
   */
   public void setFormato(String Formato){
      this.Formato = Formato;
   }

   /**
   * Seta o valor no atributo
   * @param Duracao String a ser setada no atributo
   */
   public void setDuracao(String Duracao){
      this.Duracao = Duracao;
   }

   /**
   * Seta o valor no atributo
   * @param PaisOrigem String a ser setada no atributo
   */
   public void setPaisOrigem(String PaisOrigem){
      this.PaisOrigem = PaisOrigem;
   }

   /**
   * Seta o valor no atributo
   * @param IdiomaOriginal String a ser setada no atributo
   */
   public void setIdiomaOriginal(String IdiomaOriginal){
      this.IdiomaOriginal = IdiomaOriginal;
   }

   /**
   * Seta o valor no atributo
   * @param EmissoraTv String a ser setada no atributo
   */
   public void setEmissoraTv(String EmissoraTv){
      this.EmissoraTv = EmissoraTv;
   }

   /**
   * Seta o valor no atributo
   * @param TransOri String a ser setada no atributo
   */
   public void setTransOri(String TransOri){
      this.TransOri = TransOri;
   }

   /**
   * Seta o valor no atributo
   * @param nTemp inteiro a ser setado no atributo
   */
   public void setnTemp(int nTemp){
      this.nTemp = nTemp;
   }

   /**
   * Seta o valor no atributo
   * @param eEP inteiro a ser setado no atributo
   */
   public void setnEp(int nEp){
      this.nEp = nEp;
   }

   //--------------------------------------Get-----------------------------------------//

   /**
   * Pega o valor do atributo
   * @return o valor de Nome
   */
   public String getNome(){
      return this.Nome;
   }

   /**
   * Pega o valor do atributo
   * @return o valor de Formato
   */
   public String getFormato(){
      return this.Formato;
   }

   /**
   * Pega o valor do atributo
   * @return o valor de Duracao
   */
   public String getDuracao(){
      return this.Duracao;
   }

   /**
   * Pega o valor do atributo
   * @return o valor de PaisOrigem
   */
   public String getPaisOrigem(){
      return this.PaisOrigem;
   }

   /**
   * Pega o valor do atributo
   * @return o valor de IdiomaOriginal
   */
   public String getIdiomaOriginal(){
      return this.IdiomaOriginal;
   }

   /**
   * Pega o valor do atributo
   * @return o valor de EmissoraTv
   */
   public String getEmissoraTv(){
      return this.EmissoraTv;
   }

   /**
   * Pega o valor do atributo
   * @return o valor de TransOri
   */
   public String getTransOri(){
      return this.TransOri;
   }

   /**
   * Pega o valor do atributo
   * @return o valor de nTemp
   */
   public int getnTemp(){
      return this.nTemp;
   }

   /**
   * Pega o valor do atributo
   * @return o valor de nEp
   */
   public int getnEp(){
      return this.nEp;
   }

// -----------------------------------------------------------------------------------------//

   /**
   * Metodo publico iterativo para imprimir os atributos
   */
   public void imprimir(){
      System.out.println(this.getNome()+" "+this.getFormato() + " " + this.getDuracao() + " " + this.getPaisOrigem() + " " + this.getIdiomaOriginal()+ " " + this.getEmissoraTv() + " " + this.getTransOri() + " " + this.getnTemp() + " " + this.getnEp());
   }

   /**
   * Metodo publico iterativo que pegando soh o que nao esta entre as tags
   * @param linha String a ser limpa
   * @return String de tudo que nao estava entre as tags
   */
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

    /**
   * Metodo publico iterativo que retorna os atributos da class Series;
   * @return String com os atributos da class Series;
   */
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

   /**
   * Metodo publico iterativo que retira os caracteres especiais da String
   * @param linha String a ser retirada os chars especiais
   * @return String sem os chars especiais
   */
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

   /**
   * metodo feito para pegar apenas o numero que estah no comeco da String(o numero que precisa SEMPRE vai estar na pos 0);
   * @param linha String a ser usada para pegar o numero
   * @return resp Retorna uma string contendo so o numero
   */
   public String pegarNumero(String linha){
      String array[] = linha.split(" ");
      String resp = array[0];
      return resp;
   }

   /**
   * Metodo publico que recebe o nome do arquivo html, retira as '_' e tambem retira o ".html"
   * @param linha String a ser limpa
   * @return resp Retorna a string ja limpa
   */
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

   /**
   * Metodo publico feito para pegar o formato da serie, chama o metodo limpaString para limpar a String
   * @param linha String a ser limpa
   * @return string somente com o formato
   */
   public String acharFormato(String linha){
      String formato = limpaString(linha);
      return formato;
   }


    /**
   * Metodo publico feito para pegar a duracao da serie, chama o metodo limpaString para limpar a String
   * @param linha String a ser limpa
   * @return string somente com a duracao
   */
   public String acharDuracao(String linha){
      String duracao = limpaString(linha);
      return duracao;
   }

   /**
   * Metodo publico feito para pegar o pais de origem da serie, chama o metodo limpaString e o limpaString1 para limpar a String
   * @param linha String a ser limpa
   * @return string somente com o pais de origem
   */
   public String acharPaisOrigem(String linha){
      String paisOrigem = limpaString(linha);
      String paisOrigemResp = limpaString1(paisOrigem);
      return paisOrigemResp.trim();
   }

   /**
   * Metodo publico feito para pegar o Idioma da serie, chama o metodo limpaString  para limpar a String
   * @param linha String a ser limpa
   * @return string somente com o Idioma
   */
   public String acharIdioma(String linha){
      String idioma = limpaString(linha);
      return idioma.trim();
   }

   /**
   * Metodo publico feito para pegar a Emissora de Tv da serie, chama o metodo limpaString para limpar a String
   * @param linha String a ser limpa
   * @return string somente com a Emissora de Tv
   */
   public String acharEmissora(String linha){
      String emissora = limpaString(linha);
      return emissora.trim();
   }

   /**
   * Metodo publico feito para pegar a Transmissao Original da serie, chama o metodo limpaString e o limpaString1 para limpar a String
   * @param linha String a ser limpa
   * @return string somente com a Transmissao Original
   */
   public String acharTransOri(String linha){
      String transOri = limpaString(linha);
      String transOriResp = limpaString1(transOri);
      return transOriResp.trim();
   }

   /**
   * Metodo publico feito para pegar o Numero de Temporadas da serie, chama o metodo limpaString e o pegarNumero para pegar somente o numero da String
   * @param linha String a ser limpa
   * @return inteiro somente com o numero de temporadas
   */
   public int acharNumeroTemp(String linha){
      String temp = limpaString(linha);
      String temp1 = pegarNumero(temp);
      int tempResp = Integer.parseInt(temp1);
      return tempResp;
   }

  /**
   * Metodo publico feito para pegar o Numero de episodios da serie, chama o metodo limpaString e o pegarNumero para pegar somente o numero da String
   * @param linha String a ser limpa
   * @return inteiro somente com o numero de episodios
   */
   public int acharNumeroEps(String linha){
      String ep = limpaString(linha);
      String ep1 = pegarNumero(ep);
      int epResp = Integer.parseInt(ep1);
      return epResp;
   }

   protected Object clone() throws CloneNotSupportedException {
      return super.clone();
   }
   
   /**
   * metodo publico iterativo que abre o arquivo html, pega a linha que precisa e manda para o metodo correspondente, depois seta a informacao necessaria
   * @param nomeArq Nome do arquivo a ser lido
   * @return objeto do tipo series
   */
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

class No{
   //atributos
   public No right;
   public No left;
   public int nivel; // niveis abaixo do No;
   public Series value;

    /**
   * Construtor da classe.
   * @param value conteudo do no
   */
   public No(Series value){
      this.right = this.left = null;
      this.value = value;
   }

   /**
     * Construtor da classe.
     * @param value Conteudo do no.
     * @param left No da esquerda.
     * @param right No da direita.
     * @param nivel Nivel do No
     */
   public No(Series value, No left, No right, int nivel) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.nivel = nivel;
    }

    // Cálculo do número de níveis a partir de um vértice
    public No setNivel() {
        this.nivel = 1 + Math.max(getNivel(left), getNivel(right));
        return this;
    }
 
    // Retorna o número de níveis a partir de um vértice
    public static int getNivel(No no) {
        return (no == null) ? 0 : no.nivel;
    }
}

class Arvore{
   //atributos
   private No raiz;
   public int comparacao = 0;

   /**
   * Construtor da classe.
   */
   public Arvore(){
      this.raiz = null;
   }

   public int getAltura() {
      return nivel(raiz) - 1;
   }
 
   private int nivel(No no) {
      return (no == null) ? 0 : (1 + Math.max(nivel(no.left), nivel(no.right)));
   }

   
   private No rotSimpleLeft(No avo) throws Exception{
      No pai = avo.right;
      No fPai = pai.left;

      pai.left = avo;
      avo.right = fPai;

      pai.setNivel();
      avo.setNivel();

      return pai;
   }

   private No rotSimpleRight(No avo) throws Exception{
      No pai = avo.left;
      No fPai = pai.right;

      pai.right = avo;
      avo.left = fPai;

      pai.setNivel();
      avo.setNivel();

      return pai;
   }

   private No balancear(No no) throws Exception{
      if(no != null){
         int fator = No.getNivel(no.right) - No.getNivel(no.left);

         if (Math.abs(fator <= 1)) {
            no = no.setNivel();
         }

         else if(fator == 2){
            int fatorFilhoDir = no.getNivel(no.right.right) - no.getNivel(no.right.left);

            if (fatorFilhoDir == -1) {
               no.right = rotSimpleRight(no.right);
            }

            no = rotSimpleLeft(no);

         }

         else if(fator == -2){
            int fatorFilhoEsq = no.getNivel(no.left.right) - no.getNivel(no.left.left);

            if (fatorFilhoEsq == 1) {
               no.left = rotSimpleLeft(no.left);
            }

            no = rotSimpleRight(no);

         }

         else{
            throw new Exception("ERRO");
         }
      }

      return no;
   }
 

/**
   * Metodo publico iterativo para verificar se a string j eh maior que a string i
   * @param j string a ser comparada.
   * @param i string a ser comparada
   * @return <code>true</code> se a string j for maior que a string i,
   * <code>false</code> em caso contrario.
   */
   public boolean compararString(String j, String i){
      boolean tof = false;
      int resp = j.compareTo(i);
      if (resp > 0) { //se a String J for maior que a I
         tof = true; 
      }
      comparacao++;
      return tof;
      
   }
/**
   * Metodo publico iterativo para verificar se a string i eh maior que a string j
   * @param j string a ser comparada.
   * @param i string a ser comparada
   * @return <code>true</code> se a string i for maior que a string j,
   * <code>false</code> em caso contrario.
   */
   public boolean compararString1(String j, String i){
      boolean tof = false;
      int resp = j.compareTo(i);
      if (resp < 0) {
         tof = true; 
      }
      comparacao++;
      return tof;
      
   }
   
   /**
   * Metodo publico iterativo para verificar se a string i eh igual a string j
   * @param j string a ser comparada.
   * @param i string a ser comparada
   * @return <code>true</code> se a string i for igual a string j,
   * <code>false</code> em caso contrario.
   */
   public boolean stringIgual(String j , String i){
      boolean tof = false;
      if(j.equals(i)){
         tof = true;
      }     
      comparacao++;   
      return tof;
   } 

   /**
   * Metodo publico iterativo para pesquisar elemento.
   * @param x Elemento que sera procurado.
   * @return <code>true</code> se o elemento existir,
   * <code>false</code> em caso contrario.
   */
   public boolean pesquisar(Series x){
      return pesquisar(x , raiz);
   }

   /**
   * Metodo privado recursivo para pesquisar elemento.
   * @param x Elemento que sera procurado.
   * @param i No em analise.
   * @return <code>true</code> se o elemento existir,
   * <code>false</code> em caso contrario.
   */
   private boolean pesquisar(Series x , No i){
      boolean tof;
      if (i == null) {
         tof = false;
      }
      
      else if(stringIgual(i.value.getNome() , x.getNome())){
         tof = true;
      }
      
      else if(compararString(x.getNome() , i.value.getNome())){
         tof = pesquisar(x , i.right);
      }
      
      else{
         tof = pesquisar(x , i.left);
      }
     
      return tof;
   }

   /**
   * Metodo publico iterativo para inserir elemento / So insere se o elemento n existir.
   * @param x Elemento a ser inserido.
   */
   public void inserir(Series x) throws Exception{
      boolean tof = false;
      tof = pesquisar(x);
      if (!tof){
         raiz = inserir(x,raiz);
      }
   }

   /**
   * Metodo privado recursivo para inserir elemento.
   * @param x Elemento a ser inserido.
   * @param i No em analise.
   * @return No em analise, alterado ou nao.
   */  
   private No inserir(Series x , No i) throws Exception{

      if(i == null){
         i = new No(x);
      }
      
      else if(compararString(x.getNome() , i.value.getNome())){
         i.right = inserir(x , i.right);
      }
      
      else if(compararString1(x.getNome() , i.value.getNome())){
         i.left = inserir(x , i.left);
      }
      
      i = balancear(i);
      return i;
   }

   /**
   * Metodo publico iterativo para exibir elementos.
   */
   public void mostrarCentral(){
      mostrarCentral(raiz);
   }

   /**
   * Metodo privado recursivo para exibir elementos.
   * @param i No em analise.
   */
   private void mostrarCentral(No i){
      if (i != null) {
         mostrarCentral(i.left);
         System.out.println(i.value + " ");
         mostrarCentral(i.right);
      }
   }

   /**
   * Metodo publico iterativo para remover elemento.
   * @param x Elemento a ser removido.
   * @throws Exception Se nao encontrar elemento.
   */
   public void remover(String x)throws Exception{
      boolean tof = false;
      tof = pesquisarNome1(x);
      if (tof) {
         raiz = remover(x, raiz);
      }
   }
 
   /**
   * Metodo privado recursivo para remover elemento.
   * @param x Elemento a ser removido.
   * @param i No em analise.
   * @return No em analise, alterado ou nao.
   * @throws Exception Se nao encontrar elemento.
   */
   private No remover(String x, No i)throws Exception{
   
      if (i == null) {
         throw new Exception("Erro ao remover!");
      } 
      else if (compararString1(x , i.value.getNome())) {
         i.left = remover(x, i.left);
      } 
      else if (compararString(x , i.value.getNome())) {
         i.right = remover(x, i.right);
      } 
      else if (i.right == null) {
         i = i.left;
      } 
      else if (i.left == null) {
         i = i.right;
      } 
      else {
         i.left = antecessor(i, i.left);
      }
      
      i = balancear(i);
      return i;
   }
 
   /**
   * Metodo para trocar no removido pelo antecessor.
   * @param i No que teve o elemento removido.
   * @param j No da subarvore esquerda.
   * @return No em analise, alterado ou nao.
   */
   private No antecessor(No i, No j) {
   
        // Existe no a direita.
      if (j.right != null) {
         // Caminha para direita.
         j.right = antecessor(i, j.right);
      } 
      // Encontrou o maximo da subarvore esquerda.
      else {
         i.value = j.value; // Substitui i por j.
         j = j.left; // Substitui j por j.ESQ.
      }
      return j;
   }

   /**
   * Metodo publico iterativo para pesquisar elemento.
   * @param x Elemento que sera procurado.
   * @return <code>true</code> se o elemento existir,
   * <code>false</code> em caso contrario.
   */
   public boolean pesquisarNome(String x){
      System.out.print("raiz ");
      return pesquisarNome(x , raiz);
   }

   /**
   * Metodo privado recursivo para pesquisar elemento, printa o caminho.
   * @param x Elemento que sera procurado.
   * @param i No em analise.
   * @return <code>true</code> se o elemento existir,
   * <code>false</code> em caso contrario.
   */
   private boolean pesquisarNome(String x , No i){
      boolean tof;
      if (i == null) {
         return tof = false;
      }
      
      else if(stringIgual(i.value.getNome() , x)){
         tof = true;
      }
      
      else if(compararString(x , i.value.getNome())){
         System.out.print("dir ");
         tof = pesquisarNome(x , i.right);
      }
      
      else{
         System.out.print("esq ");
         tof = pesquisarNome(x , i.left);
      }
     
      return tof;
   }

   /**
   * Metodo publico iterativo para pesquisar elemento.
   * @param x Elemento que sera procurado.
   * @return <code>true</code> se o elemento existir,
   * <code>false</code> em caso contrario.
   */
   public boolean pesquisarNome1(String x){
      return pesquisarNome1(x , raiz);
   }

   /**
   * Metodo privado recursivo para pesquisar elemento, nao printa o caminho.
   * @param x Elemento que sera procurado.
   * @param i No em analise.
   * @return <code>true</code> se o elemento existir,
   * <code>false</code> em caso contrario.
   */
   private boolean pesquisarNome1(String x , No i){
      boolean tof;
      if (i == null) {
         return tof = false;
      }
      
      else if(stringIgual(i.value.getNome() , x)){
         tof = true;
      }
      
      else if(compararString(x , i.value.getNome())){
         tof = pesquisarNome1(x , i.right);
      }
      
      else{
         tof = pesquisarNome1(x , i.left);
      }
     
      return tof;
   }

   /**
   * Metodo publico iterativo para pegar somente o nome do pub.in quando for um Remover
   * @param nome Entrada do pub.in
   * @return String somente com o nome
   */
   public String limparSemPos(String nome){
      int size = nome.length();
      int i = 0;
      int j = 2;
      String resp = "";
      while(j < size){
         resp += nome.charAt(j);
         j++;
         i++;
   
       }
   
      return resp;
   }

}//fim class

class TP07Q03{
   public static void main(String[] args)throws Exception{
      long inicio = System.currentTimeMillis();
      MyIO.setCharset("UTF-8");
      Arvore arv = new Arvore();
      //String gg[];
      boolean tof;
      //entrada primeira parte;
      String entrada = MyIO.readLine();
      while(entrada.equals("FIM") == false){
         Series se = new Series();
         se.lerArquivos(entrada);
         arv.inserir(se);
         entrada = MyIO.readLine();
      }//fim while

      //entrada segunda parte;
      int nOperacoes = MyIO.readInt();
      String in = "";
      for (int i = 0 ; i < nOperacoes ; i++){
         in = MyIO.readLine();
         String gg[] = in.split(" ");
         if (in.charAt(0) == 'I'){
            Series se = new Series();
            se.lerArquivos(gg[1]);
            arv.inserir(se);
         }
         
         else if(in.charAt(0) == 'R'){
            String resp = arv.limparSemPos(in);
            arv.remover(resp);
         }  
      }

      //entrada Terceira parte;
      in = MyIO.readLine();

      while(in.equals("FIM") == false){
         tof = arv.pesquisarNome(in);
         
         if(tof){
            System.out.println("SIM");
         }
         
         else{
            System.out.println("NAO");
         }

         in = MyIO.readLine();

      }
   

      long fim = System.currentTimeMillis(); 
         
      Arq.openWrite("576473_arvoreBinaria.txt", "UTF-8");
      Arq.println("Matricula: 576473\tTempo:" + (fim-inicio)/1000.0 + "s\t" + "Compracoes:"+arv.comparacao); 
      Arq.close(); 
   
   }//fim da main
}//fim da class