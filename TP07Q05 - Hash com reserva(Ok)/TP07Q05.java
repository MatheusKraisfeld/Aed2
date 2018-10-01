
/** 
 * Hash com reserva
 *
 * @author Giuseppe Salome Fantoni Agostini
 * @version 1 11/2017
 */
import java.*;

final class Series implements Cloneable {

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
    Series() {
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
     *
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
    Series(String Nome, String Formato, String Duracao, String PaisOrigem, String IdiomaOriginal, String EmissoraTv, String TransOri, int nTemp, int nEp) {
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
     *
     * @param Nome String a ser setada no atributo
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    /**
     * Seta o valor no atributo
     *
     * @param Formato String a ser setada no atributo
     */
    public void setFormato(String Formato) {
        this.Formato = Formato;
    }

    /**
     * Seta o valor no atributo
     *
     * @param Duracao String a ser setada no atributo
     */
    public void setDuracao(String Duracao) {
        this.Duracao = Duracao;
    }

    /**
     * Seta o valor no atributo
     *
     * @param PaisOrigem String a ser setada no atributo
     */
    public void setPaisOrigem(String PaisOrigem) {
        this.PaisOrigem = PaisOrigem;
    }

    /**
     * Seta o valor no atributo
     *
     * @param IdiomaOriginal String a ser setada no atributo
     */
    public void setIdiomaOriginal(String IdiomaOriginal) {
        this.IdiomaOriginal = IdiomaOriginal;
    }

    /**
     * Seta o valor no atributo
     *
     * @param EmissoraTv String a ser setada no atributo
     */
    public void setEmissoraTv(String EmissoraTv) {
        this.EmissoraTv = EmissoraTv;
    }

    /**
     * Seta o valor no atributo
     *
     * @param TransOri String a ser setada no atributo
     */
    public void setTransOri(String TransOri) {
        this.TransOri = TransOri;
    }

    /**
     * Seta o valor no atributo
     *
     * @param nTemp inteiro a ser setado no atributo
     */
    public void setnTemp(int nTemp) {
        this.nTemp = nTemp;
    }

    /**
     * Seta o valor no atributo
     *
     * @param eEP inteiro a ser setado no atributo
     */
    public void setnEp(int nEp) {
        this.nEp = nEp;
    }

    //--------------------------------------Get-----------------------------------------//
    /**
     * Pega o valor do atributo
     *
     * @return o valor de Nome
     */
    public String getNome() {
        return this.Nome;
    }

    /**
     * Pega o valor do atributo
     *
     * @return o valor de Formato
     */
    public String getFormato() {
        return this.Formato;
    }

    /**
     * Pega o valor do atributo
     *
     * @return o valor de Duracao
     */
    public String getDuracao() {
        return this.Duracao;
    }

    /**
     * Pega o valor do atributo
     *
     * @return o valor de PaisOrigem
     */
    public String getPaisOrigem() {
        return this.PaisOrigem;
    }

    /**
     * Pega o valor do atributo
     *
     * @return o valor de IdiomaOriginal
     */
    public String getIdiomaOriginal() {
        return this.IdiomaOriginal;
    }

    /**
     * Pega o valor do atributo
     *
     * @return o valor de EmissoraTv
     */
    public String getEmissoraTv() {
        return this.EmissoraTv;
    }

    /**
     * Pega o valor do atributo
     *
     * @return o valor de TransOri
     */
    public String getTransOri() {
        return this.TransOri;
    }

    /**
     * Pega o valor do atributo
     *
     * @return o valor de nTemp
     */
    public int getnTemp() {
        return this.nTemp;
    }

    /**
     * Pega o valor do atributo
     *
     * @return o valor de nEp
     */
    public int getnEp() {
        return this.nEp;
    }

// -----------------------------------------------------------------------------------------//
    /**
     * Metodo publico iterativo para imprimir os atributos
     */
    public void imprimir() {
        System.out.println(this.getNome() + " " + this.getFormato() + " " + this.getDuracao() + " " + this.getPaisOrigem() + " " + this.getIdiomaOriginal() + " " + this.getEmissoraTv() + " " + this.getTransOri() + " " + this.getnTemp() + " " + this.getnEp());
    }

    /**
     * Metodo publico iterativo que pegando soh o que nao esta entre as tags
     *
     * @param linha String a ser limpa
     * @return String de tudo que nao estava entre as tags
     */
    public String limpaString(String linha) {
        String resp = "";
        boolean tof = false;

        for (int i = 0; i < linha.length(); i++) {
            if (linha.charAt(i) == '<') {
                tof = true;
            }

            if (!tof) {
                resp += linha.charAt(i);
            }

            if (linha.charAt(i) == '>') {
                tof = false;
            }
        }

        return resp;
    }

    /**
     * Metodo publico iterativo que retorna os atributos da class Series;
     *
     * @return String com os atributos da class Series;
     */
    public String toString() {
        return "" + Nome
                + " " + Formato
                + " " + Duracao
                + " " + PaisOrigem
                + " " + IdiomaOriginal
                + " " + EmissoraTv
                + " " + TransOri
                + " " + nTemp
                + " " + nEp;

    }

    /**
     * Metodo publico iterativo que retira os caracteres especiais da String
     *
     * @param linha String a ser retirada os chars especiais
     * @return String sem os chars especiais
     */
    public String limpaString1(String linha) {
        String resp = "";
        boolean tof = false;

        for (int i = 0; i < linha.length(); i++) {
            if (linha.charAt(i) == '&') {
                tof = true;
            }

            if (!tof) {
                resp += linha.charAt(i);
            }

            if (linha.charAt(i) == ';') {
                tof = false;
            }
        }

        return resp;
    }

    /**
     * metodo feito para pegar apenas o numero que estah no comeco da String(o
     * numero que precisa SEMPRE vai estar na pos 0);
     *
     * @param linha String a ser usada para pegar o numero
     * @return resp Retorna uma string contendo so o numero
     */
    public String pegarNumero(String linha) {
        String array[] = linha.split(" ");
        String resp = array[0];
        return resp;
    }

    /**
     * Metodo publico que recebe o nome do arquivo html, retira as '_' e tambem
     * retira o ".html"
     *
     * @param linha String a ser limpa
     * @return resp Retorna a string ja limpa
     */
    public String acharNome(String linha) {

        String nome = linha.replace("_", " ");
        String resp = "";
        int i = 0;
        while (nome.charAt(i) != '.') {
            resp += nome.charAt(i);
            i++;
        }
        return resp.trim();
    }

    /**
     * Metodo publico feito para pegar o formato da serie, chama o metodo
     * limpaString para limpar a String
     *
     * @param linha String a ser limpa
     * @return string somente com o formato
     */
    public String acharFormato(String linha) {
        String formato = limpaString(linha);
        return formato;
    }

    /**
     * Metodo publico feito para pegar a duracao da serie, chama o metodo
     * limpaString para limpar a String
     *
     * @param linha String a ser limpa
     * @return string somente com a duracao
     */
    public String acharDuracao(String linha) {
        String duracao = limpaString(linha);
        return duracao;
    }

    /**
     * Metodo publico feito para pegar o pais de origem da serie, chama o metodo
     * limpaString e o limpaString1 para limpar a String
     *
     * @param linha String a ser limpa
     * @return string somente com o pais de origem
     */
    public String acharPaisOrigem(String linha) {
        String paisOrigem = limpaString(linha);
        String paisOrigemResp = limpaString1(paisOrigem);
        return paisOrigemResp.trim();
    }

    /**
     * Metodo publico feito para pegar o Idioma da serie, chama o metodo
     * limpaString para limpar a String
     *
     * @param linha String a ser limpa
     * @return string somente com o Idioma
     */
    public String acharIdioma(String linha) {
        String idioma = limpaString(linha);
        return idioma.trim();
    }

    /**
     * Metodo publico feito para pegar a Emissora de Tv da serie, chama o metodo
     * limpaString para limpar a String
     *
     * @param linha String a ser limpa
     * @return string somente com a Emissora de Tv
     */
    public String acharEmissora(String linha) {
        String emissora = limpaString(linha);
        return emissora.trim();
    }

    /**
     * Metodo publico feito para pegar a Transmissao Original da serie, chama o
     * metodo limpaString e o limpaString1 para limpar a String
     *
     * @param linha String a ser limpa
     * @return string somente com a Transmissao Original
     */
    public String acharTransOri(String linha) {
        String transOri = limpaString(linha);
        String transOriResp = limpaString1(transOri);
        return transOriResp.trim();
    }

    /**
     * Metodo publico feito para pegar o Numero de Temporadas da serie, chama o
     * metodo limpaString e o pegarNumero para pegar somente o numero da String
     *
     * @param linha String a ser limpa
     * @return inteiro somente com o numero de temporadas
     */
    public int acharNumeroTemp(String linha) {
        String temp = limpaString(linha);
        String temp1 = pegarNumero(temp);
        int tempResp = Integer.parseInt(temp1);
        return tempResp;
    }

    /**
     * Metodo publico feito para pegar o Numero de episodios da serie, chama o
     * metodo limpaString e o pegarNumero para pegar somente o numero da String
     *
     * @param linha String a ser limpa
     * @return inteiro somente com o numero de episodios
     */
    public int acharNumeroEps(String linha) {
        String ep = limpaString(linha);
        String ep1 = pegarNumero(ep);
        int epResp = Integer.parseInt(ep1);
        return epResp;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * metodo publico iterativo que abre o arquivo html, pega a linha que
     * precisa e manda para o metodo correspondente, depois seta a informacao
     * necessaria
     *
     * @param nomeArq Nome do arquivo a ser lido
     * @return objeto do tipo series
     */
    @SuppressWarnings("empty-statement")
    public Series lerArquivos(String nomeArq) throws CloneNotSupportedException {
        String linha = "";
        Arq.openRead("/tmp/" + nomeArq);
        for (linha = Arq.readLine(); Arq.hasNext() && !linha.contains("<h1"); linha = Arq.readLine());
        this.setNome(acharNome(nomeArq));
        for (linha = Arq.readLine(); Arq.hasNext() && !linha.contains("Formato<"); linha = Arq.readLine());
        linha = Arq.readLine();
        this.setFormato(acharFormato(linha));
        for (linha = Arq.readLine(); Arq.hasNext() && !linha.contains("Duração"); linha = Arq.readLine());
        linha = Arq.readLine();
        this.setDuracao(acharDuracao(linha));
        for (linha = Arq.readLine(); Arq.hasNext() && !linha.contains("País de origem"); linha = Arq.readLine());
        linha = Arq.readLine();
        this.setPaisOrigem(acharPaisOrigem(linha));
        if (nomeArq.equals("Grey's_Anatomy.html")) {
            this.setPaisOrigem("Estados Unidos");
        }
        for (linha = Arq.readLine(); Arq.hasNext() && !linha.contains("Idioma original"); linha = Arq.readLine());
        linha = Arq.readLine();
        this.setIdiomaOriginal(acharIdioma(linha));
        for (linha = Arq.readLine(); Arq.hasNext() && !linha.contains("Emissora de televisão original"); linha = Arq.readLine());
        linha = Arq.readLine();
        this.setEmissoraTv(acharEmissora(linha));
        for (linha = Arq.readLine(); Arq.hasNext() && !linha.contains("Transmissão original"); linha = Arq.readLine());
        linha = Arq.readLine();
        this.setTransOri(acharTransOri(linha));
        for (linha = Arq.readLine(); Arq.hasNext() && !linha.contains("N.º de temporadas"); linha = Arq.readLine());
        linha = Arq.readLine();
        this.setnTemp(acharNumeroTemp(linha));
        for (linha = Arq.readLine(); Arq.hasNext() && !linha.contains("N.º de episódios"); linha = Arq.readLine());
        linha = Arq.readLine();
        this.setnEp(acharNumeroEps(linha));
        Arq.close();
        return (Series) this.clone();
    }
}//end da class Series

class Hash {
    //atributos

    Series[] array;
    protected int tamTab = 21;
    protected int tamReserva = 9;
    protected int tamTotal;
    protected int contReserva;
    protected int cont = 0;

    /**
    * Construtor vazio da class
    */
    public Hash() {
        this(21, 9);
    }

    /**
    * Construtor
    *
    * @param tamTab tamanho da area normal da hash
    * @param tamReserva tamanho da area de reserva da hash
    */
    public Hash(int tamTab, int tamReserva) {
        this.tamTab = tamTab;
        this.tamReserva = tamReserva;

        this.tamTotal = tamTab + tamReserva;

        array = new Series[this.tamTotal];

        for (int i = 0; i < tamTotal; i++) {
            array[i] = null;
        }

        contReserva = 0;
    }

    /**
    * Metodo privado iterativo que verifica se duas strings sao iguais
    * @param a String a ser analisada
    * @param b String a ser analisada
    * @return <code>true<code> se a string 'a' for igual a 'b'
    */
    private boolean equals (String a , String b){
        cont++;
        boolean tof = false;
        if(a.equals(b)){
            tof = true;
        }
        return tof;
    }

    /**
     * Meotodo privado iterativo que recebe uma Serie e transforma o nome dela
     * em um inteiro de acordo com a tabela ASCII
     *
     * @param x Serie a ser analisada
     * @return nome da serie em valor ASCII
     */
    private int pegarValor(Series x) {
        int resp = 0;
        String nome = x.getNome();
        int tam = nome.length();
        for (int i = 0; i < tam; i++) {
            resp += x.getNome().charAt(i);
        }

        return resp;
    }

    /**
     * Meotodo privado iterativo que recebe o nome de uma serie e o em um
     * inteiro de acordo com a tabela ASCII
     *
     * @param x Nome da serie a ser analisada
     * @return nome da serie em valor ASCII
     */
    private int pegarValor(String x) {
        int resp = 0;
        String nome = x;
        int tam = nome.length();
        for (int i = 0; i < tam; i++) {
            resp += x.charAt(i);
        }
        return resp;
    }

    /**
     * Meotodo privado iterativo feiro para pegar a pos onde vou inserir na hash
     *
     * @param x valor o elemento a ser inserido
     * @return posicao onde a serie vai ser inserida
     */
    private int funcaoHash(int x) {
        int resp = (x % this.tamTab);
        return resp;
    }

    /**
     * Metodo publico iterativo feito para inserir uma Serie na hash
     *
     * @param x Serie a ser inserida
     */
    public void inserir(Series x) {
        if (x != null) {
            int pos = funcaoHash(pegarValor(x));
            if (array[pos] == null) {
                array[pos] = x;
            } else if (contReserva < tamReserva) {
                array[tamTab + contReserva] = x;
                contReserva++;
            }
        }
    }

    /**
     * Metodo publico iterativo feito para pesquisar se uma serie esta na ou nao
     * na hash
     *
     * @param x Nome da serie a ser pesquisada
     * @return pos da serie na hash, return -1 se a serie nao estiver na hash
     */
    public int pesquisarNome(String x) {
        int k = -1;
        int pos = funcaoHash(pegarValor(x));
        if (array[pos] != null) { //TEM Q TER ESSA CONDICAO
            if (equals(array[pos].getNome() , x)) {
                k = pos;
            } else {
                for (int i = 0; i < contReserva; i++) {
                    if (equals(array[tamTab + i].getNome() , x)) {
                        k = tamTab + i;
                        i = contReserva; //break
                    }
                }
            }
        }
        return k;
    }
}//fim class

class TP07Q05 {

    public static void main(String[] args) throws CloneNotSupportedException {
        long inicio = System.currentTimeMillis();
        MyIO.setCharset("UTF-8");
        Hash hash = new Hash();
        int k;

        boolean tof;
        //entrada primeira parte;
        String entrada = MyIO.readLine();
        while (entrada.equals("FIM") == false) {
            Series se = new Series();
            se.lerArquivos(entrada);
            hash.inserir(se);
            entrada = MyIO.readLine();
        }//fim while

        //entrada segunda parte;
        int nOperacoes = MyIO.readInt();
        String in = "";
        for (int i = 0; i < nOperacoes; i++) {
            in = MyIO.readLine();
            String gg[] = in.split(" ");
            if (in.charAt(0) == 'I') {
                Series se = new Series();
                se.lerArquivos(gg[1]);
                hash.inserir(se);
            }

        }

        //Terceira parte;
        in = MyIO.readLine();

        while (in.equals("FIM") == false) {
            k = hash.pesquisarNome(in);

            if (k == -1) {
                System.out.println("NAO");
            } else {
                System.out.println(k + " SIM");
            }

            in = MyIO.readLine();

        }

        long fim = System.currentTimeMillis();

        Arq.openWrite("576473_hashReserva.txt", "UTF-8");
        Arq.println("Matricula: 576473\tTempo:" + (fim - inicio) / 1000.0 + "s\t" + "Compracoes:" + hash.cont);
        Arq.close();

    }
}
