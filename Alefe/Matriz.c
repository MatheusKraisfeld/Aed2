#include <stdio.h>
#include <stdlib.h>

//--------------------------- CELULA -------------------------------//

typedef struct Celula{
   Celula* up;
   Celula* right;
   Celula* left;
   Celula* down;
   int value;
}Celula

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

//--------------------MATRIZ -----------------------------------------//

typedef struct Matriz{
   Celula* primeiro;
   int linha;
   int coluna;
}

Matriz* IniciarMatriz(int linha , int coluna){
   Matriz* m = (Matriz*)malloc(sizeof(Matriz));
   m->primeiro = criarLinhas(coluna);
   int i = 0;
   for (i = 1; i < linha; i++){
      m -> primeiro = juntarLinhas(criarLinhas(coluna), Matriz* m);
   }
   return m;
}

Celula* criarLinhas(int coluna){
   Celula* c = IniciarMatriz();
   int i = 1;
   for(i = 1; i < coluna ; i++){
      Celula* b = IniciarMatriz();
      c->right = b;
      c->righ->left = c;
      c = c->right;
   }

   return c;
}

Celula* juntarLinhas(Celula* i, Matriz* m){
   Celula* cabeça = i;
   Celula* y;
   for(y = m->primeiro ; y!=NULL ; y = y.right , i = i.right){
      y->up = i;
      i->down = y;
   }
   return cabeça;
}


void mostrar(Matriz* m){
   Celula* c = primeiro;
   int i = 0;
   int j = 0;
   for (i = 0; m -> linha; i++){
      Celula* d = c;
      for (int j = 0; j < m->coluna; j++){
         printf("%d",d->value);
         d = d->right;
      }
      c = c->down;
   }
} 

void mostrarDiagPri(Matriz* m){
   Celula* c = m -> primeiro;
   int i = 0;
   for (i = 0;i < m -> linha ; i++ ) {
      printf("%d", c -> value);
      if (c -> down != NULL) {
            c = c -> down;
            c = c -> right;
      }
   }
}

void mostrarDiagSec(Matriz* m){
   Celula* c = m -> primeiro;
   int i = 0;
   for (c = m -> primeiro; c -> right != NULL ; c = c->right );
   int j = 0;
   for (j = 0; j < m->linha ;j++ ) {
      printf("%d", c->value);
      if (c->down != NULL) {
         c = c->down;
         c = c->left;
      }
   }
}

void setElemento(Matriz* m , int linha, int coluna , int valor){
   Celula* c = m->primeiro;

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


int getElemento(Matriz* m , int linha , int coluna){
   Celula* c = m->primeiro;

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

Matriz* soma(Matriz* m1 , Matriz* m2){
   int contaLinha = 1;
   int contaColuna = 1;
   Celula* c  = m1->primeiro;

   while(c->down != NULL){
      c = c->down;
      contaLinha++;
   }
   while(c->right != NULL){
      c = c->right;
      contaColuna++;
   }

   Matriz* m3 = IniciarMatriz(contaLinha,contaColuna);

   c = m1->primeiro;

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

Matriz* multiplicacao(Matriz* m1 , Matriz*m2){
   //pegar o numero de linhas da primeira matriz;
   Celula* c = m1->primeiro;
   int contarLinhas = 1;

   while(c->down != NULL){
      c = c->down;
      contarLinhas++;
   }
   //pegar o numero de colunas da segunda matriz;
   c = m2->primeiro;
   int contarColunas = 1;

   while(c->right != NULL){
      c = c->right;
      contarColunas++;
   }

   //Multiplica a matriz;
   
   Matriz* m3 = IniciarMatriz(contarLinhas, contarColunas);

   int i = 0;
   int j = 0;
   int k = 0;
   int produto;
   int resp = 0;

   for (i = 0; i < contarLinhas; i++){
      for(j = 0, j< contarColunas ; j++){
         produto = 0;
         for (k = 0, k < contarLinhas; k++){
            produto = getElemento(m1 , i , k) * getElemento(m2 , k , j);
            resp = resp + produto;
         }
         setElemento(m3 , i , j ,resp);
      }   
   
   }

   return m3;

}

//----------------------------------------- MAIN -------------------------------//

int main(){

}
