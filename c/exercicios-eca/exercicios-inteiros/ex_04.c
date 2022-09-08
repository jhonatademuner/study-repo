// Dados um inteiro X e um inteiro não-negativo N, calcular X elevado a N.

#include <stdio.h>
#include<math.h>

int main(){

    int num1;
    int num2;

    scanf("%d %d", &num1, &num2);
    printf("%.0f", pow(num1, num2));

    return 0;
}