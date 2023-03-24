#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <dirent.h>

#include "filters.h"
#include "menus.h"

void clearTerminal(){
    printf("\033[2J\033[1;1H");
}

void clearString(char *string){
    memset(string,'\0',sizeof(string));
}

int loadMenu(){
    clearTerminal();
    char loadOptions[3][40] = {"1 - Escolher imagem do seu PC\n", "2 - Escolher imagens armazenadas\n", "3 - Sair\n"};
    int chosenOption;

    for (int i = 0; i < 3; i++)
    {
        printf("%s", loadOptions[i]);
    }

    printf("\nDigite a opcao desejada: ");
    scanf("%d", &chosenOption);
    clearTerminal();

    if (chosenOption < 1 || chosenOption > 3)
    {
        printf("Opcao invalida!\n");
    }

    return chosenOption;
}

char *getFilePath(int chosenOption)
{

    struct dirent *entry;
    DIR *dir;

    int imgOption;
    char imgName[100];
    char *filePath;

    switch (chosenOption)
    {
    case 1:
        printf("Insira o caminho da imagem: ");
        scanf("%s", &imgName);
        filePath = imgName;
        clearTerminal();
        return filePath;

    case 2:
        dir = opendir("images-input");

        int i = 1;
        printf("\nImagens armazenadas:\n");
        while ((entry = readdir(dir)) != NULL)
        {
            if (entry->d_type == DT_REG)
            {
                printf("%d. %s\n", i++, entry->d_name);
            }
        }
        closedir(dir);

        printf("Digite o numero da imagem desejada: ");
        scanf("%d", &imgOption);

        dir = opendir("images-input");
        i = 1;
        while ((entry = readdir(dir)) != NULL)
        {
            if (entry->d_type == DT_REG)
            {
                if (i == imgOption)
                {
                    strcpy(imgName, entry->d_name);
                    char *tmp = strdup(imgName);
                    strcpy(imgName, "images-input/");
                    strcat(imgName, tmp);
                    free(tmp);
                    break;
                }
                i++;
            }
        }
        closedir(dir);
        filePath = imgName;
        clearTerminal();
        return filePath;

    case 3:
        exit(0);
        break;
    default:
        clearTerminal();
        loadMenu();
        break;
    }
    return NULL;
}

void displayFiterMenu()
{
    char filterOptions[6][50] = {"Escolha um filtro para aplicar a imagem:\n", "1 - Negativo\n", "2 - Espelhamento\n", "3 - Desfoque\n", "4 - Clareamento\n", "5 - Salvar e sair\n"};
    for (int i = 0; i < 6; i++)
    {
        printf("%s", filterOptions[i]);
    }
}

void filterMenu(int **matrix, int width, int height)
{
    clearTerminal();

    int filterOption;

    displayFiterMenu();
    printf("Digite a opcao desejada: ");
    scanf("%d", &filterOption);


    while(filterOption != 5){
        clearTerminal();
        switch (filterOption){
        case 1:
            negativeFilter(matrix, width, height);
            break;
        case 2:
            flipFilter(matrix, width, height);
            break;
        case 3:
            blurFilter(matrix, width, height);
            break;
        case 4:
            brightenFilter(matrix, width, height);
            break;
        default:
            printf("Opcao invalida!\n");
            break;
        }
        displayFiterMenu();
        printf("Digite a opcao desejada: ");
        scanf("%d", &filterOption);
    }
}