#include <stdio.h>
#include <stdlib.h>

int tamString(char string[],int tam){//metodo recursivo que retorna o tamanho da string;
   int resp;
   if(string[tam] == '\0'){
      resp = 0;
   }
   else{
      resp = 1 + tamString(string,tam+1);
   }
   return resp;   
}

int ehPalindromo(char string[], int i, int tam){//metodo recursivo que verifica se a palavra eh um palindromo
   int resp = 0;
   if(i > tam){
      resp = 1;
   }
   
   else if(string[i] == string[tam]){
      resp = ehPalindromo(string,i+1,tam-1);
   }
   
   else if(string[i] != string[tam]){
      resp = 0;
   }
   return resp;
      
}

int ehPalindromo(char string[]){//metodo recursivo que vai inicialiar os valores para o prox metodo
   int tam;
   tam = tamString(string,0);
   return ehPalindromo(string,0,tam-1);
}

int ehFim(char entrada[]){//metodo que verifica se a palvra de entrada eh igual a "FIM"
   int fim = 0;
   if(entrada[0] == 'F' && entrada[1] == 'I' && entrada[2] == 'M'){
      fim = 1;
   }	
   return fim;
}

int main(){
	
   char entrada[1000][1000];
   int contEntrada = 0;
   int i = 0;
   int fim;

   do{
      scanf(" %[^\n]s", entrada[contEntrada]);
      fim = ehFim(entrada[contEntrada]);
      contEntrada = contEntrada + 1;
   }while(fim != 1);
   contEntrada--; //desconsiderar a entrada "FIM"

   for(i = 0; i < contEntrada; i++){
      if(ehPalindromo(entrada[i]) == 1){
         printf("SIM\n");
      }
      else{
         printf("NAO\n");
      }
   }	
   return 0;
}//fim main

