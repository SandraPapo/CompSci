/*
Sandra Papo
104213584_Race.c
Answer to Q2
*/


#include<stdio.h>
#include<stdlib.h>
#include<time.h>
 
#define FINISH 80
 
void moveTortoise(int* tortoisePtr);
void moveHare(int* harePtr) ;
void printPosition(const int* const tortoisePtr, const int* const harePtr);
  
int main(void) {
   int tortoise = 1, hare = 1, timer = 0;
    
   srand(time(0));
    
   printf("BANG !!!!!\nAND THEY'RE OFF !!!!\n\n");
    
   while(tortoise != FINISH && hare != FINISH) {
      moveTortoise(&tortoise);
      moveHare(&hare);
      printPosition(&tortoise, &hare); 
      timer++;      
   }

   if(tortoise > hare){
      printf("TORTOISE WINS!!! YAY!!!\n");         
   }else if(tortoise < hare){
      printf("Hare wins. Yuch.\n");      
   }
    
   printf("TIME ELAPSED = %d seconds\n", timer);
    
    
   system("pause");
   return 0;
}
 


void moveTortoise(int* tortoisePtr) {
   int i;
    
   i = rand() % 10;
    
   if(i >= 0 && i < 6){ 
      *tortoisePtr += 4;  
   }else if(i >= 6 && i < 8){
      *tortoisePtr -= 6; 
   }else{     
      *tortoisePtr += 1; 
   }
    
   if(*tortoisePtr < 1)
      *tortoisePtr = 1;
   else if(*tortoisePtr > FINISH)
      *tortoisePtr = FINISH;
}
 
void moveHare(int* harePtr) {
   int i;
    
   i = rand() % 10;
    
   if(i >= 0 && i < 2){  
      *harePtr = *harePtr;  
   }else if(i >= 2 && i < 5){  
      *harePtr += 8;   
   }else if(i >= 5 && i < 7){
      *harePtr -= 9;
   }else if(i >= 7 && i < 9){
      *harePtr += 1;
   }else{
      *harePtr -= 2;      
   }
    
   if(*harePtr < 1)
      *harePtr = 1;
   else if(*harePtr > FINISH)
      *harePtr = FINISH;
}
 
void printPosition( const int* const tortoisePtr, const int* const harePtr) {
   int i;
    
   if(*tortoisePtr == *harePtr){
      for(i = 1; i < *tortoisePtr; i++){
         printf("%s", " " );
      }
      printf("OUCH!!!");                
   }else if(*tortoisePtr < *harePtr){
      for(i = 1; i < *tortoisePtr; i++ ){
         printf("%s", " " );
      }   
      printf("T");
       
      for(i = 1; i < (*harePtr - *tortoisePtr); i++){
         printf("%s", " " );
      }
      printf("H");
   }else{
      for(i = 1; i < *harePtr; i++){
         printf("%s", " ");      
      }     
      printf("H");
       
      for( i = 0; i < (*tortoisePtr - *harePtr); i++){
         printf("%s", " " );     
      }
      printf("T");
   }
    
   printf("\n");
}