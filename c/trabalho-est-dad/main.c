#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <dirent.h>

void clearTerminal(){
    printf("\033[2J\033[1;1H");
}

void getDimensions(char *filePath, int *width, int *height)
{
    FILE *file;
    file = fopen(filePath, "rt");

    fscanf(file, "%*s");
    fscanf(file, "%d %d", width, height);

    fclose(file);
}

int **readPgm(char *filePath, int *width, int *height)
{
    getDimensions(filePath, width, height);
    int **matrix;
    int i, j;
    char buffer[150];

    FILE *file;
    file = fopen(filePath, "rt");

    fgets(buffer, 150, file);
    fgets(buffer, 150, file);
    fgets(buffer, 150, file);

    matrix = (int **)malloc(*height * sizeof(int *));
    for (i = 0; i < *height; i++)
    {
        matrix[i] = (int *)malloc(*width * sizeof(int));
    }

    for (i = 0; i < *height; i++)
    {
        for (j = 0; j < *width; j++)
        {
            fscanf(file, "%d", &matrix[i][j]);
        }
    }

    fclose(file);
    return matrix;
}

void freeMatrix(int **matrix, int height)
{
    int i;
    for (i = 0; i < height; i++)
    {
        free(matrix[i]);
    }
    free(matrix);
}

void matrixToPgm(int **matrix, int width, int height, char *filePath)
{
    char str[100];
    sprintf(str, "images-output/%s", filePath);
    FILE *file = fopen(str, "w");

    fprintf(file, "P2\n");
    fprintf(file, "%d %d\n", width, height);
    fprintf(file, "255\n");

    int i, j;
    for (i = 0; i < height; i++)
    {
        for (j = 0; j < width; j++)
        {
            fprintf(file, "%d ", matrix[i][j]);
        }
        fprintf(file, "\n");
    }

    fclose(file);
}

void negativeFilter(int **matrix, int width, int height)
{
    int i, j;
    for (i = 0; i < height; i++)
    {
        for (j = 0; j < width; j++)
        {
            matrix[i][j] = 255 - matrix[i][j];
        }
    }
}

void flipFilter(int **matrix, int width, int height)
{
    int i, j;
    for (i = 0; i < height; i++)
    {
        for (j = 0; j < width / 2; j++)
        {
            int aux = matrix[i][j];
            matrix[i][j] = matrix[i][width - j - 1];
            matrix[i][width - j - 1] = aux;
        }
    }
}


int *getNeighbours(int **m, int i, int j, int *neighbours)
{
    neighbours[0] = m[i - 1][j - 1];
    neighbours[1] = m[i - 1][j];
    neighbours[2] = m[i - 1][j + 1];
    neighbours[3] = m[i][j - 1];
    neighbours[4] = m[i][j];
    neighbours[5] = m[i][j + 1];
    neighbours[6] = m[i + 1][j - 1];
    neighbours[7] = m[i + 1][j];
    neighbours[8] = m[i + 1][j + 1];
}

int getMax(int *neighbours)
{
    int max = 0;
    for (int i = 0; i < 9; i++)
    {
        if (neighbours[i] > max)
        {
            max = neighbours[i];
        }
    }
    return max;
}

void copyMatrix(int **m, int **newMatrix, int width, int height)
{
    int i, j;
    for (i = 0; i < height; i++)
    {
        for (j = 0; j < width; j++)
        {
            newMatrix[i][j] = m[i][j];
        }
    }
}

void blurFilter(int **m, int width, int height)
{
    int i, j;
    for (i = 0; i < height; i++)
    {
        for (j = 0; j < width; j++)
        {
            int sum = 0;
            int count = 0;
            
            for (int k = i - 1; k <= i + 1; k++)
            {
                for (int l = j - 1; l <= j + 1; l++)
                {
                    if (k >= 0 && k < height && l >= 0 && l < width)
                    {
                        sum += m[k][l];
                        count++;
                    }
                }
            }
            m[i][j] = sum / count;
        }
    }
}

void brightenFilter(int **m, int width, int height)
{
    int i, j;
    int ** newMatrix = (int **)malloc(height * sizeof(int *));

    for (i = 0; i < height; i++) {
        newMatrix[i] = (int *)malloc(width * sizeof(int));
    }
    
    copyMatrix(m, newMatrix, width, height);

    for (i = 0; i < height; i++) {
        for (j = 0; j < width; j++) {
            int maxNeighbor = 0;
            int k, l;
            for (k = i - 1; k <= i + 1; k++) {
                for (l = j - 1; l <= j + 1; l++) {
                    if (k >= 0 && k < height && l >= 0 && l < width) {
                        if (newMatrix[k][l] > maxNeighbor) {
                            maxNeighbor = newMatrix[k][l];
                        }
                    }
                }
            }
            int newPixelValue = maxNeighbor;
            if (newPixelValue > 255) {
                newPixelValue = 255;
            }
            m[i][j] = newPixelValue;
        }
    }

    freeMatrix(newMatrix, height);
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

void clearString(char *string){
    memset(string,'\0',sizeof(string));
}


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
        printf("Digite o nome da imagem: ");
        scanf("%s", &imgName);

        matrixToPgm(matrix, width, height, imgName);
        freeMatrix(matrix, height);

        loadOption = loadMenu();
    }

    return 0;
}