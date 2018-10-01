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
    struct Series* elemento;        // Elemento inserido na celula.
    struct Celula* prox; // Aponta a celula prox.
} Celula;
 
Celula* novaCelula(Series* elemento) {
   Celula* nova = (Celula*) malloc(sizeof(Celula));
   nova->elemento = elemento;
   nova->prox = NULL;
   return nova;
}
 
//PILHA PROPRIAMENTE DITA =======================================================
Celula* topo; // Sem celula cabeca.
 
 
/**
 * Cria uma pilha sem elementos.
 */
void start () {
   topo = NULL;
}
 
 
/**
 * Insere elemento na pilha (politica FILO).
 * @param x int elemento a inserir.
 */
void inserir(Series* x) {
   Celula* tmp = novaCelula(x);
   tmp->prox = topo;
   topo = tmp;
   tmp = NULL;
}
 
/**
 * Remove elemento da pilha (politica FILO).
 * @return Elemento removido.
 */
Series* remover() {
   if (topo == NULL) {
      errx(1, "Erro ao remover!");
   }
 
   Series* resp = topo->elemento;
   Celula* tmp = topo;
   topo = topo->prox;
   tmp->prox = NULL;
   free(tmp);
   tmp = NULL;
   return resp;
}
 
 //imprime os atributos do objeto
void imprimir(Series* serie){
   printf("%s %s %s %s %s %s %s %d %d\n", serie->nome, serie->formato, serie->duracao, serie->paisOrigem, serie->idiomaOri, serie->emissoraTv, serie->transOri, serie->nTemp, serie->nEp);
}

/**
 * Mostra os elementos separados por espacos, comecando do topo.
 */
void mostrar() {
   Celula* i;
   
   for(i = topo; i != NULL; i = i->prox) {
      imprimir(i->elemento);
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
     inserir(s);
     flush_in();
   }

   //pegar o numero de casos
   scanf("%d", &casos);
   int k = casos;
   flush_in();
   //Leitura da segunda parte

   for(scanf("%[^\n]", line); k != 0 ; scanf("%[^\n]", line)){
       if(strstr(line , "I") != NULL){
         Series* s = (Series*) calloc(1, sizeof(Series));
         nome = limparSemPos(line);
         lerArquivos(s,nome);
         inserir(s);
      }
      
      else if(strstr(line , "R") != NULL){
         Series* a = remover(); 
         printf("(R) %s\n", a->nome);

      }
      
      k--;
      flush_in();
      
   }
   mostrar();
   return 0;
}//fim da main
