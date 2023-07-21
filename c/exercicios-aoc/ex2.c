#include <stdio.h>

int main(){

    int k;
    float baseElem, ratio;

    printf("Enter the base element: ");
    scanf("%f", &baseElem);
    printf("Enter the threshold number: ");
    scanf("%d", &k);
    printf("Enter the ratio: ");
    scanf("%f", &ratio);

    float paElem = 0;
    int i = 1;
    while (paElem + ratio < k){
        paElem = baseElem + (i - 1) * ratio;
        printf("Element %d: %.2f\n", i, paElem);
        i++;
    }

    return 0;
}