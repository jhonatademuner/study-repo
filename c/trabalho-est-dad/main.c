#include <stdio.h>

#include "menus.h"
#include "filters.h"
#include "matrix.h"

int main()
{

    int **matrix;
    int width, height;
    char *filePath;
    char imgName[100];
    int loadOption;

    loadOption = loadMenu();

    while(loadOption != 3){
        filePath = getFilePath(loadOption);

        matrix = readPgm(filePath, &width, &height);

        filterMenu(matrix, width, height);

        clearString(imgName);
        clearTerminal();
        printf("Digite o nome da imagem (nao se esqueca de colocar a extensao *.pgm): ");
        scanf("%s", &imgName);

        matrixToPgm(matrix, width, height, imgName);
        freeMatrix(matrix, height);

        loadOption = loadMenu();
    }

    return 0;
}