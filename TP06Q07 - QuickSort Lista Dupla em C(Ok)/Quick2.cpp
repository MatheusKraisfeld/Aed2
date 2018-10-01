#include <stdio.h>
#include <stdlib.h>
#include <err.h>
#include <string.h>
#define TAMANHO 1000
#define MAXTAM    100
#define LINETAM 5000
#define bool      short
#define true      1
#define false     0

//TIPO Series =========================================================
typedef struct Series{
   char* nome;
   char* formato;
   char* duracao;
   char* paisOrigem;
   char* idiomaOri;
   char* emissoraTv;
   char* transOri;
   int nTemp;
   int nEp;
} Series;


//TIPO CELULA ===================================================================
typedef struct Celula {
   struct Series* value; // Elemento inserido na celula.
   struct Celula* right; // Aponta a celula right.
   struct Celula* left;  // Aponta a celula anterior.
} Celula;

Celula* newCelula(Series* value) {
   Celula* nova = (Celula*) malloc(sizeof(Celula));
   nova->value = value;
   nova->left = nova->right = NULL;
   return nova;
}

//LISTA PROPRIAMENTE DITA =======================================================
Celula* primeiro;
Celula* ultimo;
int mov = 0;
int comparacao = 0;


/**
 * Cria uma lista dupla sem elementos (somente no cabeca).
 */
void start () {
   primeiro = newCelula(NULL);
   ultimo = primeiro;
}

/**
 * Insere um value na ultima posicao da lista.
 * @param x int value a ser inserido.
 */
void inserirFim(Series* x) {
   ultimo->right = newCelula(x);
   ultimo->right->left = ultimo;
   ultimo = ultimo->right;
}

/**
 *  Calcula e retorna o tamanho, em numero de elementos, da lista.
 *  @return resp int tamanho
 */
int tamanho() {
   int tamanho = 0; 
   Celula* i;
   for(i = primeiro; i != ultimo; i = i->right, tamanho++);
   return tamanho;
}

//imprime os atributos do objeto
void imprimir(Series* serie){
   printf("%s %s %s %s %s %s %s %d %d\n", serie->nome, serie->formato, serie->duracao, serie->paisOrigem, serie->idiomaOri, serie->emissoraTv, serie->transOri, serie->nTemp, serie->nEp);
}

/**
 * Mostra os elementos da lista separados por espacos.
 */
void mostrar() {
   Celula* i;
   for (i = primeiro->right; i != NULL; i = i->right) {
      imprimir(i->value);
	}
}


//le a entrada e pega somente a posicao pra remover ou inserir
int aquelaPraDeusVer(char* nome){
   int i = 0;
   int j = 3;
   int retorno = 0;
   char resp[3];

   while(nome[i] != ' '){
      resp[i] = nome[j];
      i++;
      j++;
   }

   resp[i] = '\0';
   retorno = atoi(resp);
}

//le a entrada e pega somente o nome
char* limparSemPos(char* nome){
   int size = strlen(nome);
   int i = 0;
   int j = 2;
   char resp[50];
   while(j < size){
      resp[i] = nome[j];
      j++;
      i++;
   
   }

   resp[i] = '\0';
   return strdup(resp);
}

//le a entrada e pega somente o nome
char* limparComPos(char* nome){
   int size = strlen(nome);
   int j = 0;
   int i = 0;
   char resp[50];
   if(nome[4] == ' '){
      j = 5;
      while(j<size){
         resp[i] = nome[j];
         j++;
         i++;
      }
      resp[i] = '\0';
      return strdup(resp);
   }
   
   else if(nome[5] == ' '){
      j = 6;
      while(j<size){
         resp[i] = nome[j];
         j++;
         i++;
      }
      resp[i] = '\0';
      return strdup(resp);
   }
}



//Verifica se possui underline na palavra
bool possuiUnderLine(char* nome){
   bool tof = false;
   int j = 0;
   j = strlen(nome);
   int i = 0;
   for (i = 0; i < j; i++){
      if(nome[i] == '_'){
         return tof = true;
      }     
   }
   return tof;
}

//retira os espacos da frase
void retiraEspaco(char* resp){
   int i = 0;
   if (resp[strlen(resp)-1] == ' '){
      resp[strlen(resp)-1] = '\0';
   }
   
   if (resp[0] == ' ') {
      for (i = 0; i < strlen(resp); ++i){
         resp[i] = resp[i+1];
      }
   }
}



//metodo que pega o que esta fora das tags na string
char* limpaString(char* nome){

   bool tof = false;
   int i = 0;
   int j = 0;
   char resp[100];


   for(i = 0; i < strlen(nome); i++){
      if(nome[i] == '<'){
         tof = true;
      }
   
      if(!tof){
         resp[j] = nome[i];
         j++;
      }
   
      if(nome[i] == '>'){
         tof = false;
      }
   }
   resp[j] = '\0';
   return strdup(resp);
}

//metodo que retira os caracteres especiais da string
char* limpaString1(char* nome){

   bool tof = false;
   int i = 0;
   int j = 0;
   char resp[100];


   for(i = 0; i < strlen(nome); i++){
      if(nome[i] == '&'){
         tof = true;
      }
   
      if(!tof){
         resp[j] = nome[i];
         j++;
      }
   
      if(nome[i] == ';'){
         tof = false;
      }
   }
   resp[j] = '\0';
   return strdup(resp);
}

//metodo que da um replace
char* replace(char* str, char find, char replace){
   char *current_pos = strchr(str,find);
   while (current_pos){
      *current_pos = replace;
      current_pos = strchr(current_pos,find);
   }
   return strdup(str);
}

 //metodo recebe o nome do arquivo html, retira as '_' e tambem retira o ".html", retornando apenas o nome;
char* replaceNome(char* nome){
   char* resp;
   int i = 0;
   char resp2[100];
   resp = replace(nome,'_',' ');

   while(resp[i] != '.'){
      resp2[i] = resp[i];
      i++;
   }

   resp2[i] = '\0';

   return strdup(resp2);
}

//metodo que retorna uma string com o formato da serie;
char* acharFormato(char* linha){
   char* formato;
   formato = limpaString(linha);
   return strdup(formato);
}

//metodo que retorna uma string com a duracao da serie;
char* acharDuracao(char* linha){
   char* duracao = limpaString(linha);
   return strdup(duracao);
}

   //metodo que retorna uma string com o pais de origem da serie;
char* acharPaisOrigem(char* linha){
   char* paisOrigem = limpaString(linha);
   char* paisOrigemResp = limpaString1(paisOrigem);
   return strdup(paisOrigemResp);
}

   //metodo que retorna uma string com o idioma original da serie;
char* acharIdioma(char* linha){
   char* idioma = limpaString(linha);
   return strdup(idioma);
}

   //metodo que retorna uma string com a Emissora de tv da serie;
char* acharEmissora(char* linha){
   char* emissora = limpaString(linha);
   return strdup(emissora);
}

   //metodo que retorna uma string com a transmissao original da serie;
char* acharTransOri(char* linha){
   char* transOri = limpaString(linha);
   char* transOriResp = limpaString1(transOri);
   return strdup(transOriResp);
}

   //metodo que retorna um inteiro contendo o numero de temporadas da serie;
int acharNumeroTemp(char* linha){
   char* tmp = limpaString(linha);
   int tempResp = atoi(tmp);
   return tempResp;
}

   //metodo que retorna um inteiro contendo o numero de episodios da serie;
int acharNumeroEps(char* linha){
   char* tmp = limpaString(linha);
   int tempResp = atoi(tmp);
   return tempResp;
}

//Meetodo que vai ler os arquivos
void lerArquivos(Series* serie , char* nome){
   char str[5000];
   char* result;
   char lucxs[] = "/tmp/";

   strcat(lucxs, nome);

   char* resp;
   int i = 0;
   int j = 0;
   FILE *ponteiro = fopen(lucxs, "r");

   bool tof = true;

   resp = replaceNome(nome);
   serie->nome = resp;

   while(tof){
      result = fgets(str , 5000 , ponteiro);
   
      if(strstr(result , "Formato<") != NULL) { 
         result = fgets(str , 5000 , ponteiro);
         result[strlen(result) - 1] = '\0';
         resp = acharFormato(result);
         serie->formato = resp;
      }
      else if(strstr(result , "Duração") != NULL) {
         result = fgets(str , 5000 , ponteiro);
         result[strlen(result) - 1] = '\0';
         resp = acharDuracao(result);
         serie->duracao = resp;
      }
      else if(strstr(result , "País de origem") != NULL) {
         result = fgets(str , 5000 , ponteiro);
         result[strlen(result) - 1] = '\0';
         resp = acharPaisOrigem(result);
         retiraEspaco(resp);
         serie->paisOrigem = resp;
      }
      else if(strstr(result , "Idioma original") != NULL) {
         result = fgets(str , 5000 , ponteiro);
         result[strlen(result) - 1] = '\0';
         resp = acharIdioma(result);
         serie->idiomaOri = resp;
      }
      else if(strstr(result , "Emissora de televisão original") != NULL) {
         result = fgets(str , 5000 , ponteiro);
         result[strlen(result) - 1] = '\0';
         resp = acharEmissora(result);
         serie->emissoraTv = resp;
      }
      else if(strstr(result , "Transmissão original") != NULL) {
         result = fgets(str , 5000 , ponteiro);
         result[strlen(result) - 1] = '\0';
         resp = acharTransOri(result);
         serie->transOri = resp;
      }
      else if(strstr(result , "N.º de temporadas") != NULL) {
         result = fgets(str , 5000 , ponteiro);
         j = acharNumeroTemp(result);
         serie->nTemp = j;
      }
      else if(strstr(result , "N.º de episódios") != NULL) {
         result = fgets(str , 5000 , ponteiro);
         j = acharNumeroEps(result);
         serie->nEp = j;
         tof = false;
      }
   
   }

   fclose(ponteiro);
}

//Verifica se a palavra que chegou eh FIM
bool equals(char* entrada){
   bool tof = false;
   if (entrada[0] == 'F' && entrada[1] == 'I' && entrada[2] == 'M'){
      tof = true;
   }
   return tof;
}

//Limpa o buffer;
void flush_in(){ 
   int ch;
   while( (ch = fgetc(stdin)) != EOF && ch != '\n' ){} 
}

//retorna true se a string J for maior que a String I;
bool compararString(char* j, char* i){
   bool tof = false;
   int resp = strcmp(j,i);
   if (resp > 0) { //se a String J for maior que a I
      tof = true; 
   }
   comparacao++;
   return tof;
}

//retorna true se a string i for maior que a string j;
bool compararString1(char* j, char* i){
   bool tof = false;
   int resp = strcmp(j,i);
   if (resp < 0) {
      tof = true; 
   }
   comparacao++;
   return tof;
}

//retorna o meio da lista;
Celula* ehMeio(int dir,int esq){
   int cont = 0;
   Celula* i = primeiro->right;
   int mid = (esq + dir) / 2;
   while(cont < mid){
      i = i->right;
      cont++;
   }
   return i;
}

//troca os elemtos
void troca(Celula* i, Celula* j){
   Series* temp = i->value;
   i->value = j->value;
   j->value = temp;
   mov++;
}


   //Algoritmo de ordenacao Quicksort.
void quicksortNome(Celula* esq , Celula* dir , int comeco , int fim){
   Celula* i = esq;
   Celula* j = dir;
   int begin = comeco;
   int end = fim;
   Series* pivo = ehMeio(fim,comeco)->value;  
   while(begin <= end){ 
      while(compararString(i->value->nome , pivo->nome)){
         i = i->right; 
         begin++;
      }
      while(compararString1(j->value->nome , pivo->nome)){
         j = j->left; 
         end--;
      }
      if(begin <= end){
         troca(i,j);
         i = i->right;
         j = j->left;
         begin++;
         end--;
      }
   }
   if(comeco < end)quicksortNome(esq,j,comeco,end);
   if(begin < fim)quicksortNome(i,dir,begin,fim); 
}


//Algoritmo de ordenacao Quicksort.
void quicksort1(Celula* esq , Celula* dir , int comeco , int fim){
   Celula* i = esq; 
   Celula* j = dir;
   int begin = comeco; 
   int end = fim;
   quicksortNome(esq,dir,comeco,fim);
   Series* pivo = ehMeio(fim,comeco)->value;
   while(begin <= end){ 
      while(compararString1(i->value->paisOrigem , pivo->paisOrigem)){
         i = i->right; 
         begin++;
      }
      while(compararString(j->value->paisOrigem , pivo->paisOrigem)){
         j = j->left; 
         end--;
      }
      if(begin <= end){
         troca(i,j);
         i = i->right;
         j = j->left;
         begin++;
         end--;
      }
   }
   if(comeco < end)quicksort1(esq,j,comeco,end);
   if(begin < fim)quicksort1(i,dir,begin,fim);
}

//Algoritmo de ordenacao Quicksort.
void quicksortPais(){
   quicksort1(primeiro->right , ultimo , 0 , (tamanho()-1 ) );
}

int main(){
   const int tamanho = 100;
   char line[tamanho];
   char **gg;
   char* nome;
   int casos = 0;
   int i = 0;
   int j = 0;
   int size = 0;
   start();

 //inserir a primeira parte;
   for(scanf ("%[^\n]", line); !equals(line) ; scanf ("%[^\n]", line)){
      Series* s = (Series*) calloc(1, sizeof(Series));
      lerArquivos(s,line);
      inserirFim(s);
      flush_in();
   }
   //chama o quicksort e mostra a lista
   quicksortPais();
   mostrar();
   return 0;
}