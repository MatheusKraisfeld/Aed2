#include <stdio.h>
#include <stdlib.h>

//------------------------------------CELULA----------------------------------//

typedef struct Celula{
   Celula* up;
   Celula* right;
   Celula* left;
   Celula* down;
   int value;
} Celula;

Celula* IniciarCel(){
   Celula* c = (Celula*)malloc(sizeof(Celula));
   c->up = c->down = c->left = c->right = NULL;
   c->value = 0;
   return c;
}

Celula* IniciarCel(int value){
   Celula* c = (Celula*)malloc(sizeof(Celula));
   c->up = c->down = c->left = c->right = NULL;
   c->value = value;
   return c;
}

//---------------------------------------------MATRIZ-----------------------------------//

typedef struct Matriz{
      Celula *primeiro;
      int linha, coluna;
} Matriz;

Celula* criaLinha(int tamLinha) {
   Celula* tmp = IniciarCel(); //primeiro celula
   Celula* cabeca = tmp;
   int i = 1;
   for (i = 1; i < tamLinha; i++) { //restante das celulas
      tmp->right = IniciarCel(); //criei celula a direita
      tmp->right->left = tmp; //linkei pra trás
      tmp = tmp->right; //incremento
    }
    return cabeca;
}

//toda vez que esse metodo eh chamado, ele chama o 'criaLinha'(que cria uma nova linha e junta ela com a matriz ja criada
void juntaLinha(Celula* linhaNova, Matriz* matriz) {
    Celula* i = linhaNova; //ponteiro pra percorrer a linha que criei
    Celula* j = matriz->primeiro; //ponteiro pra percorrer a primeiro linha da matriz criada

    for (int k = 0; k < matriz->coluna; k++) { //to linkando cima/baixo
        i->down = j;
        j->up = i;
        //incremento
        i = i->right;
        j = j->right;
    }

    matriz->primeiro = linhaNova;//depois de linkar a linha criada em cima da linha que ja tinha, subimos com o ponteiro primeiro
}

Matriz* newMatriz(int linha, int coluna) {
    Matriz* matriz = (Matriz*) calloc(1, sizeof (Matriz)); 
    matriz->linha = linha;
    matriz->coluna = coluna;
    //Cria a primeira linha da matriz, retorna ponteiro da primeiro celula da linha
    matriz->primeiro = criaLinha(coluna); 

    for (int i = 1; i < linha; i++) {//cria as demais linhas da matriz
        juntaLinha(criaLinha(coluna), matriz);
    }
    return matriz;
}

//------------------------------------METODO DA MATRIZ--------------------------------------------//

//mostra todos os elementos da matriz
void mostrar(Matriz* m){
   Celula* c = m->primeiro;
   Celula* d = c;
   int i = 0;
   int j = 0;
   for (i = 0; i < m->linha; i++){
      d = c;
      for (j = 0; j < m->coluna; j++){
         printf("%d ",d->value);
         d = d->right;
      }
      printf("\n");
      c = c->down;
   }
} 

//mostra a diagonal principal da matriz
void mostrarDiagPri(Matriz* m){
   Celula* c = m -> primeiro;
   int i = 0;
   for (i = 0;i < m -> linha ; i++ ) {
      printf("%d ", c -> value);
      if (c -> down != NULL) {
         c = c -> down;
         c = c -> right;
      }
   }
}

//mostra a diagonal secundaria da matriz
void mostrarDiagSec(Matriz* m){
   Celula* c = m -> primeiro;
   int i = 0;
   for (c = m -> primeiro; c -> right != NULL ; c = c->right );
   int j = 0;
   for (j = 0; j < m->linha ;j++ ) {
      printf("%d ", c->value);
      if (c->down != NULL) {
         c = c->down;
         c = c->left;
      }
   }
}

//insere um elemento na matriz na posicao que foi passada
void setElemento(Matriz* m , int linha, int coluna , int valor){
   Celula* c = m -> primeiro;

   int i = 0;
   int j = 0;

   for (i = 0; i < linha; i++){
      c = c->down;
   }

   for (j = 0; j < coluna; j++){
      c = c->right;
   }

   c->value = valor;
}

//retorna o valor do elemento da posicao que foi passada
int getElemento(Matriz* m , int linha , int coluna){
   Celula* c = m->primeiro;
   int resp = 0;
   int i = 0;
   int j = 0;

   for (i = 0; i < linha; i++){
      c = c->down;
   }

   for (j = 0; j < coluna; j++){
      c = c->right;
   }

   return resp = c->value;
}

//metodo que soma duas matrizes
Matriz* soma(Matriz* m1 , Matriz* m2){
   
   int contaLinha = 1;
   int contaColuna = 1;
   Celula* c  = m1->primeiro;

   //pega o numero de linha e de coluna da primeiro matriz
   while(c->down != NULL){
      c = c->down;
      contaLinha++;
   }
   while(c->right != NULL){
      c = c->right;
      contaColuna++;
   }

   //cria a matriz que vai ser a resposta
   Matriz* m3 = newMatriz(contaLinha,contaColuna);

   c = m1->primeiro;

   //soma de matriz
   int i = 0;
   int j = 0;
   int resp = 0;

   for (i = 0; i < contaLinha; i++){
      for (j = 0; j < contaColuna; j++){
         resp = getElemento(m1 , i , j) + getElemento(m2 , i , j);
         setElemento(m3 , i , j , resp);
      }
   
   }
   return m3;
}

//metodo que multiplica duas matrizes
Matriz* multiplicacao(Matriz* m1 , Matriz*m2){
   //pegar o numero de linha da primeiro matriz;
   Celula* c = m1->primeiro;
   int contarLinhas = 1;

   while(c->down != NULL){
      c = c->down;
      contarLinhas++;
   }
   //pegar o numero de coluna da segunda matriz;
   c = m2->primeiro;
   int contarColunas = 1;

   while(c->right != NULL){
      c = c->right;
      contarColunas++;
   }
  
   //cria a matriz resp;
   
   Matriz* m3 = newMatriz(contarLinhas, contarColunas);

   //multiplicacao de matriz
   
   int i = 0;
   int j = 0;
   int k = 0;
   int produto;
   
   for (i = 0; i < contarLinhas; i++){
      for(j = 0; j< contarColunas ; j++){
         produto = 0;
         for (k = 0; k < contarLinhas; k++){
            produto = produto + (getElemento(m1 , i , k) * getElemento(m2 , k , j));
         }
         setElemento(m3 , i , j ,produto);
      }   
   
   }

   return m3;

}

int main(){
   int casos; 
   scanf("%d", &casos);//leitura dos numeros de casos
   int i = 0;
   int j = 0;
   int valor;
   while(casos--){
      int linha;
      int coluna;
      scanf("%d %d", &linha , &coluna); //leitura da linha e coluna da primeiro matriz
    
      Matriz* m1 = newMatriz(linha,coluna); //cria a matriz 1
      
      for(i = 0;i<linha;i++){
         for(j = 0;j<coluna;j++){
            //le o valor e insere na matriz 1
            scanf("%d",&valor); 
            setElemento(m1,i,j,valor); 
         }
      }
      
      scanf("%d %d", &linha , &coluna);//leitura da linha e coluna da segunda matriz
    
      Matriz* m2 = newMatriz(linha,coluna);//cria a matriz 2
      
      for(i = 0;i<linha;i++){
         for(j = 0;j<coluna;j++){
            //le o valor e insere na matriz 2
            scanf("%d",&valor);
            setElemento(m2,i,j,valor); 
         }
      }
      
      //saida
      mostrarDiagPri(m1);
      printf("\n");
      mostrarDiagSec(m1);
      printf("\n");

      Matriz* soma1 = soma(m1,m2);
      mostrar(soma1);
      Matriz* mult = multiplicacao(m1,m2);
      mostrar(mult);
      
   }
  
   return 0;
}//fim da main