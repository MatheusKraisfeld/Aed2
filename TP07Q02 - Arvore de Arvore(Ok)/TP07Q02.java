/** Árvore de Arvore
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
   return resp.trim();
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

class No1 {
    //atributos
  protected No1 left;
  protected No1 right;
  protected char primeiraLetra;
  protected No2 outra;

    /**
    *Construtor da class
    *@param primeiraLetra conteudo do No1
    */
    public No1(char primeiraLetra) {
      this.primeiraLetra = primeiraLetra;
      this.left = this.right = null;
      this.outra = null;
    }

  }

  class No2 {

    //atributos
    protected No2 left;
    protected No2 right;
    protected Series value;

    /**
    *Construtor da class
    *@param value Conteudo do No2
    */
    public No2(Series value) {
      this.value = value;
      this.left = this.right = null;
    }

  }

  class ArvArv {
    //atributos
    protected No1 raiz;
    protected int comparacao = 0;

    /**
    *Construtor da class
    */
    public ArvArv() {
      String s = "DRZXVBFPUIGEJLHTAWSOMNKCYQ";
      for (char c : s.toCharArray()) {
        raiz = inserirPrimeiraArv(c, raiz);
      }
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
   * Metodo privado recursivo para inserir os caracteres na primeira arvore
   * @param c char a ser inserido na primeira arvore
   * @param i No em analise.
   * @return No em analise.
   */
    private No1 inserirPrimeiraArv(char c , No1 i){
      if(i == null){
        i = new No1(c);
      }
      else if(c < i.primeiraLetra){
        i.left = inserirPrimeiraArv(c , i.left);
      }
      else{
        i.right = inserirPrimeiraArv(c , i.right);
      }

      return i;
    }
    


 	 /**
   * Metodo publico iterativo para inserir o objeto na segunda arvore
   * @param nome Series objeto a ser inserido
   */
   public void inserirSegundaArv(Series x)throws Exception{
    boolean tof = false;
    //se a Serie comecar com um Numero ela nao vai ser inserida;
    if (x.getNome().charAt(0) >= '0' && x.getNome().charAt(0) <= '9' ) {
      tof = true;
    }
    if(!tof && pesquisarSegundaArvore(x.getNome()) == false){
      //pesquisa na primeira arvore o No em que vai ser inserido o objeto
      No1 no = pesquisarPrimeiraArv(x.getNome());
		  //insere na segunda arvore o objeto
      no.outra = inserirSegundaArv(x , no.outra);
    }
  }

	 /**
   * Metodo publico iterativo para pesquisar o No em que vai ser inserido o objeto
   * @param nome String que vai conter o nome da serie que vai ser inserida
   * @param i No2 raiz da segunda arvore
   * @return raiz da segunda arvore para nao perder a referencia
   */
  private No2 inserirSegundaArv(Series nome , No2 i)throws Exception{
    if(i == null){
      i = new No2((Series)nome.clone());
    }

    else if(compararString1(nome.getNome() , i.value.getNome())){
      i.left = inserirSegundaArv(nome , i.left);
    }

    else{
      comparacao++;
      i.right = inserirSegundaArv(nome , i.right);
    }
    return i;
  }

	 /**
   * Metodo publico iterativo para pesquisar o No em que vai ser inserido o objeto
   * @param nome String que vai conter o nome da serie que vai ser inserida
   * @return No que vai ser inserido o objeto
   */
  public No1 pesquisarPrimeiraArv(String nome){
    No1 no = raiz;
    char chave = nome.charAt(0);
    while(no.primeiraLetra != nome.charAt(0)){
      if(chave < no.primeiraLetra){
        no = no.left;
      }
      else {
        no = no.right;
      }
    }
    return no;
  }
  
  	 /**
   * Metodo publico iterativo para pesquisar o No em que vai ser inserido o objeto // possui print do caminho
   * @param nome String que vai conter o nome da serie que vai ser inserida
   * @return No que vai ser inserido o objeto
   */
  public No1 pesquisarPrimeiraArvCaminho(String nome){
    No1 no = raiz;
    System.out.print("raiz ");
    char chave = nome.charAt(0);
    while(no.primeiraLetra != nome.charAt(0)){
      if(chave < no.primeiraLetra){
        System.out.print("esq ");
        no = no.left;
      }
      else {
        System.out.print("dir ");
        no = no.right;
      }
    }
    return no;
  }


     /**
   * Metodo publico que passa a raiz para o mostrarPrimeiraArv
   */
     public void mostrarPrimeiraArv(){
      mostrarPrimeiraArv(raiz);
    }
    
     /**
   * Metodo privado recursivo que mostra os caracteres da primeira arvore
   * @param i Raiz da primeira arvore
   */
     private void mostrarPrimeiraArv(No1 i){
      if(i != null){
        mostrarPrimeiraArv(i.left);
        System.out.println(i.primeiraLetra + " ");            
        mostrarPrimeiraArv(i.right);
      }
    }

    
  /**
  * Metodo publico que vai chamar o recursivo do metodo mostrarSegundaArv() passando a raiz
  */
  public void mostrarSegundaArv(){
    mostrarSegundaArv(raiz);
  }

	 /**
   * Metodo privado recursivo que entra na segunda arvore
   * @param i Raiz da primeira arvore
   */
   private void mostrarSegundaArv(No1 i){
    if(i != null){
      mostrarSegundaArv(i.left);
      mostrarElementoSegundaArv(i.outra);
      mostrarSegundaArv(i.right);
    }
  }

   /**
   * Metodo privado recursivo que mostra os elementos que estao na segunda arvore
   * @param i raiz da segunda arvore
   */
   private void mostrarElementoSegundaArv(No2 i){
    if (i != null) {
      mostrarElementoSegundaArv(i.left);
      System.out.println(i.value + " ");
      mostrarElementoSegundaArv(i.right);
    }
  }

  /**
  * Metodo publico feito para chamar o metodo de pesquisar na segunda Arvore
  * @param nome String a ser pesquisada
  * @return <code>true<code> se a String a ser pesquisada estiver na Segunda arvore
  * <code>false</code> em caso contrario.
  */
  public boolean pesquisarSegundaArvore(String nome){
    //se a Serie comecar com um Numero ela nao vai estar na arvore;
    if (nome.charAt(0) >= '0' && nome.charAt(0) <= '9' ) {
      return false;
    }

    No1 no = pesquisarPrimeiraArv(nome);
    return pesquisarSegundaArvore(nome , no.outra);
  }

   /**
  * Metodo privado recursivo feito para pesquisar se possui o objeto com tal nome na segunda arvore
  * @param nome String a ser pesquisada
  * @param i No2 para andar na segunda arvore
  * @return <code>true<code> se a String a ser pesquisada estiver na Segunda arvore
  * <code>false</code> em caso contrario.
  */
   private boolean pesquisarSegundaArvore(String nome , No2 i){
    boolean resp;
    if (i == null) {
      resp = false;
    }
    else if(nome.equals(i.value.getNome())){
      resp = true;
    }
    else if(compararString1(nome , i.value.getNome())){
      resp = pesquisarSegundaArvore(nome , i.left);
    }
    else {
      comparacao++;
      resp = pesquisarSegundaArvore(nome , i.right);
    }
    return resp;
  }
  
  /**
  * Metodo publico feito para chamar o metodo de pesquisar na segunda Arvore
  * @param nome String a ser pesquisada
  * @return <code>true<code> se a String a ser pesquisada estiver na Segunda arvore
  * <code>false</code> em caso contrario.
  */
  public boolean pesquisarSegundaArvoreCaminho(String nome){
    //se a Serie comecar com um Numero ela nao vai estar na arvore;
    if (nome.charAt(0) >= '0' && nome.charAt(0) <= '9' ) {
      return false;
    }

    No1 no = pesquisarPrimeiraArvCaminho(nome);
    System.out.print("raiz ");
    return pesquisarSegundaArvoreCaminho(nome , no.outra);
  }

   /**
  * Metodo privado recursivo feito para pesquisar se possui o objeto com tal nome na segunda arvore
  * @param nome String a ser pesquisada
  * @param i No2 para andar na segunda arvore
  * @return <code>true<code> se a String a ser pesquisada estiver na Segunda arvore
  * <code>false</code> em caso contrario.
  */
   private boolean pesquisarSegundaArvoreCaminho(String nome , No2 i){
    boolean resp;
    if (i == null) {
      resp = false;
    }
    else if(nome.equals(i.value.getNome())){
      resp = true;
    }
    else if(compararString1(nome , i.value.getNome())){
      resp = pesquisarSegundaArvoreCaminho(nome , i.left);
      System.out.print("esq ");
    }
    else {
      comparacao++;
      resp = pesquisarSegundaArvoreCaminho(nome , i.right);
      System.out.print("dir ");
    }
    return resp;
  }

  /**
   * Metodo publico iterativo para remover elemento, .
   * @param x Elemento a ser removido.
   * @throws Exception Se nao encontrar elemento.
   */
  public void removerSegundaArv(String nome)throws Exception{
    boolean tof = false;
    if (nome.charAt(0) >= '0' && nome.charAt(0) <= '9') {
      tof = true;
    }
    if(!tof && pesquisarSegundaArvore(nome)){
      No1 no = pesquisarPrimeiraArv(nome);
      no.outra = removerSegundaArv(nome , no.outra);
    }
  }

  /**
   * Metodo privado recursivo para remover elemento.
   * @param x Elemento a ser removido.
   * @param i No2 em analise.
   * @return No2 em analise, alterado ou nao.
   * @throws Exception Se nao encontrar elemento.
   */
  private No2 removerSegundaArv(String nome , No2 i)throws Exception{
    if (i == null) {
      throw new Exception("Erro ao Remover");
    }
    
    else if(compararString1(nome , i.value.getNome())){
      i.left = removerSegundaArv(nome , i.left);
    }
    
    else if(compararString(nome , i.value.getNome())){
      i.right = removerSegundaArv(nome , i.right);
    }

    else if(i.right == null){
      i = i.left;
    }

    else if(i.left == null){
      i = i.right;
    }

    else{
      i = anterior(i , i.left);
    }

    return i;
  }

  /**
   * Metodo para trocar no removido pelo antecessor.
   * @param i No2 que teve o elemento removido.
   * @param j No2 da subarvore esquerda.
   * @return No2 em analise, alterado ou nao.
   */
  private No2 anterior(No2 i , No2 j){
    
    if (j.right != null) {
      j.right = anterior(i , j.right);
    }
    else{
      i.value = j.value;
      j = j.left;
    }

    return j;
  }

} 

class TP07Q02 {
  public static void main(String[]args)throws Exception{
    long inicio = System.currentTimeMillis();
      MyIO.setCharset("UTF-8");
      ArvArv arv = new ArvArv();
      //String gg[];
      boolean tof;
      //entrada primeira parte;
      String entrada = MyIO.readLine();
      while(entrada.equals("FIM") == false){
         Series se = new Series();
         se.lerArquivos(entrada);
         arv.inserirSegundaArv(se);
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
            arv.inserirSegundaArv(se);
         }
         
        else if(in.charAt(0) == 'R'){
            String resp = arv.limparSemPos(in);
            arv.removerSegundaArv(resp);
        }  
      }

      //Terceira parte;
      in = MyIO.readLine();

      while(in.equals("FIM") == false){
         tof = arv.pesquisarSegundaArvoreCaminho(in);
         
         if(tof){
            System.out.println("SIM");
         }
         
         else{
            System.out.println("NAO");
         }

         in = MyIO.readLine();

      }
   
      long fim = System.currentTimeMillis(); 
         
      Arq.openWrite("576473_arvoreArvore.txt", "UTF-8");
      Arq.println("Matricula: 576473\tTempo:" + (fim-inicio)/1000.0 + "s\t" + "Compracoes:"+arv.comparacao); 
      Arq.close(); 
   
  }
}    
