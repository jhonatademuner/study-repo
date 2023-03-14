#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>

float ** ti_cria (int n){
  float ** matrix;
  matrix = calloc(n, sizeof(float *));
  int i;
  for(i = 0; i < n; i++){
    matrix[i] = calloc(n, sizeof(float));
  }
  return matrix;
};

void ti_atribui(int i, int j, float x, float ** matrix){
  matrix[i][j] = x;
}

float ti_acessa(int i, int j, float ** matrix){
  switch(i > j){
    case true:
      return 0;
    case false:
      return matrix[i][j];
  }
}

void ti_libera(float ** matrix, int n){
  for( int i = 0; i < n; i++){
    free(matrix[i]);
  }
  free(matrix);
}

void display(float ** matrix, int n){
  for(int i = 0; i < n; i++){
    for(int j = 0; j < n; j++){
      printf("%f\t", matrix[i][j]);
    }
    printf("\n");
  }
  printf("\n");
}

int main(){

  float ** matrix;
  int n, x, y, element;

  printf("Digite um tamanho para a matriz:\n");
  scanf("%d", &n);

  printf("Matrix 1:\n");
  matrix = ti_cria(n);
  display(matrix, n);

  printf("Insira a posicao do elemento a ser atribuido: ");
  scanf("%d %d", &x, &y);

  printf("Insira o valor do elemento a ser atribuido: ");
  scanf("%d", &element);

  ti_atribui(x, y, element, matrix);
  display(matrix, n);

  printf("Insira a posicao do elemento a ser acessado: ");
  scanf("%d %d", &x, &y);
  printf("Elemento acessado: %f\n", ti_acessa(x, y, matrix));

  printf("Agora a memoria sera liberada");
  ti_libera(matrix, n);
  
  return 0;
}