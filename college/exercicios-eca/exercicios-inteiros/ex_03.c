// Dado um número inteiro positivo n, imprimir os n primeiros naturais ímpares

int main(){

    int num;
    int soma = -1;

    printf("Insira um numero inteiro: ");
    scanf("%d", &num);

    while (num > 0){
        soma += 2;
        num -= 1;
        printf("%d, ", soma);
    }

    return 0;
}