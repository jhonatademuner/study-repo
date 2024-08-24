#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int randomNumber(minRange, maxRange){ return rand() % maxRange + minRange; }

int game1(void){
    
    srand(time(NULL));

    int chosenNumber = randomNumber(1, 1024);
    int userAttempts = 0;
    int userNumber = 0;

    printf("Insira a sua tentativa: ");
    scanf("%d", &userNumber);
    userAttempts++;

    while (userNumber != chosenNumber) {
        if(userNumber > chosenNumber){
            printf("\n-1");
        } else {
            printf("\n1");
        }
        
        userAttempts++;
        
        printf("\nInsira uma nova tentativa: ");
        scanf("%d", &userNumber);
    }

    printf("\n0");
    printf("\nVocê precisou de %d tentativas para acertar o número escolhido", userAttempts);
    

    return 0;
}

int game2(void) {

  int chosenNumber;
  int attemptsNumber = 0;
  int computerArray[1025];
  computerArray[0] = -1;
  // computerArray[1025] = 1500;

  for (int i = 1; i <= 1024; i++) {
    computerArray[i] = i;
  };

  int length = sizeof(computerArray) / sizeof(computerArray[0]);
  int startIndex = 0;
  int midIndex = (length - 1) / 2;
  int endIndex = length - 1;
  int attemptResult = 0;

  printf("Insira o número escolhido: ");
  scanf("%d", &chosenNumber);

  printf("\nO computador chutou %d.\n", computerArray[midIndex]);
  printf("Insira uma das opções a seguir:\n-1\t-> se o número pensado é menor;\n1\t-> se é maior;\n0\t-> se o computador acertou.\nInsira a opção: ");
  scanf("%d", &attemptResult);
  printf("\n");
  attemptsNumber++;

  // Implementação de busca binária(adaptada) para o algoritmo de "adivinhação"
  while (attemptResult != 0) {
        
    if(attemptResult == -1){
      endIndex = midIndex;
      midIndex /= 2;
    } else{
      startIndex = midIndex;
      midIndex += (endIndex - midIndex) / 2;
      if(midIndex == startIndex){
        midIndex += 1;
      }
    }


    
    printf("\nO computador chutou %d.\n", computerArray[midIndex]);
    printf("\nInsira uma das opções a seguir:\n-1\t-> se o número pensado é menor;\n1\t-> se é maior;\n0\t-> se o computador acertou.\nInsira a opção: ");
    scanf("%d", &attemptResult);
    printf("\n");
    attemptsNumber++;    
  }
  
  printf("\nO computador precisou de %d tentativas para acertar o número escolhido", attemptsNumber);

  return 0;
}