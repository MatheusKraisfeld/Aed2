#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){

   FILE *arq;
   double num;
   char tmp[100];
   int entrada; 
   int cont;

   arq = fopen("TP03Q02.txt", "wb+");//Arquivo aberto em modo de leitura

   scanf("%d", &entrada);

   for(cont = 0; cont < entrada; cont++){
      scanf("%lf", &num);
      fwrite(&num, sizeof(double), 1, arq);
   }

   cont = entrada - 1;
   fclose(arq);
   arq = fopen("TP03Q02.txt", "rb"); //Abre o arquivo em modo escrita

   for(; cont >= 0; cont--){
      int n = cont * sizeof(double); //Posicao do ponteiro 
      fseek(arq, n, SEEK_SET); 
      fread(&num, sizeof(double), 1, arq); //Le a linha onde ta o ponteiro
      printf("%g\n", num);
   }
		
   fclose(arq); 
   return 0;
}
