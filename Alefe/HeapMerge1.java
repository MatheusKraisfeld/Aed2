
import java.util.Arrays;


class HeapMerge1 {

    
   public static void main(String[] args) {
      int[] heap1 = {2, 40, 30, 35, 25};
      int[] heap2 = {1, 41, 31, 36, 26};
   
      System.out.println("\nFINAL "+ Arrays.toString(mergeHeap(heap1, heap2)));
   
   }

   
   private static int[] mergeHeap(int[] heap1, int[] heap2) {
      int[] merged = new int[heap1.length + heap2.length];
   
      int ponteiroMerged = 0;
      int pontHeap1 = 0;
      int pontHeap2 = 0;
        //controlar o tamanho dos arrays
      int tamHeap1 = heap1.length;
      int tamHeap2 = heap2.length;
   
      while (tamHeap1 >= 0 && tamHeap2 >= 0) {
         if (heap1[1] > heap2[1]) {
            merged[ponteiroMerged] = heap1[pontHeap1];
            tamHeap1--;
            pontHeap1++;
            ponteiroMerged++;       
                
         } 
         else {
            merged[ponteiroMerged] = heap2[pontHeap2];
            tamHeap2--;
            pontHeap2++;
            ponteiroMerged++;         
                
         }
      }
     
   
      for (int i = 0; i < tamHeap1; i++) {
         merged[ponteiroMerged] = heap1[pontHeap1];
         tamHeap1--;
         pontHeap1++;
         ponteiroMerged++;    
      }
        
      for (int i = 0; i < tamHeap2; i++) {        
         merged[ponteiroMerged] = heap2[pontHeap2];
         tamHeap2--;
         pontHeap2++; 
         ponteiroMerged++;
      }
   
      return merged;
   }
    
   private static int AcharMenorVal(int array[], int array1[], int tam , int tam1){
      int tmp , resp;
      int pontArray[] = 0;
      int pontArray1[] = 0;
      int menorArray = Array[0];
      int menorArray1 = Array1[0];
      
      for(int i = 0 ;i<tam;i++){
         if(menorArray > Array[i]){
            menorArray = i;
         }
      }
      
      for(int j = 0 ;j<tam1;j++){
         if(menorArray1 > Array1[j]){
            menorArray1 = j;
         }
      }
      
      if(menorArray > menorArray1){
         tmp = Array1[tam1.length-1];
         Array1[tam1.length-1] = Array1[j];
         Array1[j] = tmp;
         resp = Array1[j];
         tam1--;
      }
      else{
         tmp = Array[tam1.length-1];
         Array[tam1.length-1] = Array[i];
         Array[i] = tmp;
         resp = Array[i];
         tam--;
      }
      
      return resp;
      
   }


   private static void swap(int[] array, int i, int i0) {
      int tmp = array[i];
      array[i] = array[i0];
      array[i0] = tmp;
   }
}
