#include <stdio.h>

int main(){

    int firstElem, lastElem, sum, num;

    printf("Enter the first element: ");
    scanf("%d", &firstElem);
    printf("Enter the last number: ");
    scanf("%d", &lastElem);
    printf("Enter the total: ");
    scanf("%d", &num);

    sum = ((firstElem + lastElem) * num) / 2;

    printf("The sum of the elements is: %d\n", sum);

    return 0;
}
