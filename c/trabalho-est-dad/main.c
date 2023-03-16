#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <dirent.h>


void getDimensions(char* filePath, int* width, int* height){
    FILE *file;
    file = fopen(filePath, "rt");

    fscanf(file, "%*s");
    fscanf(file, "%d %d", width, height);

    fclose(file);
}

int **readPgm(char* filePath, int* width, int* height) {
    getDimensions(filePath, width, height);
    int **matrix;
    int i, j;
    char buffer[150];

    FILE *file;
    file = fopen(filePath, "rt");

    fscanf(file, "%*s", buffer);
    fscanf(file, "%*d %*d", buffer, buffer);
    fscanf(file, "%*d", buffer);


    matrix = (int **)malloc(*height * sizeof(int *));
    for (i = 0; i < *height; i++) {
        matrix[i] = (int *)malloc(*width * sizeof(int));
    }

    for (i = 0; i < *height; i++) {
        for (j = 0; j < *width; j++) {
            fscanf(file, "%d", &matrix[i][j]);
        }
    }

    fclose(file);
    return matrix;
}

void freeMemory(int **matrix, int height) {
    int i;
    for (i = 0; i < height; i++) {
        free(matrix[i]);
    }
    free(matrix);
}

void matrixToPgm(int **matrix, int width, int height, char *filePath) {
    FILE *file = fopen(filePath, "w");

    fprintf(file, "P2\n");
    fprintf(file, "%d %d\n", width, height);
    fprintf(file, "255\n");

    int i, j;
    for (i = 0; i < height; i++) {
        for (j = 0; j < width; j++) {
            fprintf(file, "%d ", matrix[i][j]);
        }
        fprintf(file, "\n");
    }

    fclose(file);
}

void negativeFilter(int **matrix, int width, int height) {
    int i, j;
    for (i = 0; i < height; i++) {
        for (j = 0; j < width; j++) {
            matrix[i][j] = 255 - matrix[i][j];
        }
    }
}

void flipFilter(int **matrix, int width, int height) {
    int i, j;
    for (i = 0; i < height; i++) {
        for (j = 0; j < width / 2; j++) {
            int aux = matrix[i][j];
            matrix[i][j] = matrix[i][width - j - 1];
            matrix[i][width - j - 1] = aux;
        }
    }
}

void blurFilter(int **m, int width, int height) {
    int i, j;
    for (i = 1; i < height - 1; i++) {
        for (j = 1; j < width - 1; j++) {
            int sum = 0;
            sum += m[i-1][j-1] + m[i-1][j] + m[i-1][j+1];
            sum += m[i][j-1] + m[i][j] + m[i][j+1];
            sum += m[i+1][j-1] + m[i+1][j] + m[i+1][j+1];
            m[i][j] = sum / 9;
        }
    }
}

int * getNeighbours(int **m, int i, int j, int *neighbours ) {
    neighbours[0] = m[i-1][j-1];
    neighbours[1] = m[i-1][j];
    neighbours[2] = m[i-1][j+1];
    neighbours[3] = m[i][j-1];
    neighbours[4] = m[i][j];
    neighbours[5] = m[i][j+1];
    neighbours[6] = m[i+1][j-1];
    neighbours[7] = m[i+1][j];
    neighbours[8] = m[i+1][j+1];
}

int getMax(int *neighbours) {
    int max = 0;
    for (int i = 0; i < 9; i++) {
        if (neighbours[i] > max) {
            max = neighbours[i];
        }
    }
    return max;
}

void copyMatrix(int **m, int **newMatrix, int width, int height) {
    int i, j;
    for (i = 0; i < height; i++) {
        for (j = 0; j < width; j++) {
            newMatrix[i][j] = m[i][j];
        }
    }
}

void brightenFilter(int **m, int width, int height) {
    int i, j;
    int *neighbours = (int *)malloc(9 * sizeof(int));
    int ** newMatrix = (int **)malloc(height * sizeof(int *));

    for (i = 0; i < height; i++) {
        newMatrix[i] = (int *)malloc(width * sizeof(int));
    }
    
    copyMatrix(m, newMatrix, width, height);

    for (i = 1; i < height - 1; i++) {
        for (j = 1; j < width - 1; j++) {
            getNeighbours(newMatrix, i, j, neighbours);
            m[i][j] = getMax(neighbours);
        }
    }
}

int loadMenu(){
    char loadOptions[3][40] = {"1. Escolher imagem do seu PC\n", "2. Escolher imagens armazenadas\n", "3. Sair\n"};
    int chosenOption;

    for (int i = 0; i < 3; i++){
        printf("%s", loadOptions[i]);
    }

    printf("\nDigite a opcao desejada: ");
    scanf("%d", &chosenOption);
    system("cls");

    return chosenOption;
}


char* getFilePath(int chosenOption) {

    struct dirent *entry;
    DIR *dir;
    
    int imgOption;
    char imgName[100];
    char *filePath;
    

    switch (chosenOption) {
        case 1:
            printf("Insira o caminho da imagem: ");
            scanf("%s", &imgName);
            filePath = imgName;
            system("cls");
            return filePath;

        case 2:
            dir = opendir("images-output");

            int i = 1;
            while ((entry = readdir(dir)) != NULL) {
                if (entry->d_type == DT_REG) {
                    printf("%d. %s\n", i++, entry->d_name);
                }
            }
            closedir(dir);

            printf("Digite o numero da imagem desejada: ");
            scanf("%d", &imgOption);

            dir = opendir("images-output");
            i = 1;
            while ((entry = readdir(dir)) != NULL) {
                if (entry->d_type == DT_REG) {
                    if (i == imgOption) {
                        strcpy(imgName, entry->d_name);
                        char *tmp = strdup(imgName);
                        strcpy(imgName, "images-output/");
                        strcat(imgName, tmp);
                        free(tmp);
                        break;
                    }
                    i++;
                }
            }
            closedir(dir);
            filePath = imgName;
            system("cls");
            return filePath;

        case 3:
            exit(0);
            break;
        default:
            system("cls");
            loadMenu();
            break;
    }
    return NULL;
}

void filterMenu(int **matrix, int width, int height){
    char filterOptions[5][40] = {"1. Negativo\n", "2. Espelhamento\n", "3. Desfoque\n", "4. Clareamento\n", "5. Salvar e sair\n"};
    int chosenOption;

    for(int i = 0; i < 5; i++){
        printf("%s", filterOptions[i]);
    }

    printf("Digite a opcao desejada: ");
    scanf("%d", &chosenOption);
    system("cls");

    switch (chosenOption)
    {
    case 1:
        negativeFilter(matrix, width, height);
        filterMenu(matrix, width, height);
    case 2:
        flipFilter(matrix, width, height);
        filterMenu(matrix, width, height);
    case 3:
        blurFilter(matrix, width, height);
        filterMenu(matrix, width, height);
    case 4:
        brightenFilter(matrix, width, height);
        filterMenu(matrix, width, height);
    case 5:
        matrixToPgm(matrix, width, height, "output.pgm");
        exit(0);
    default:
        filterMenu(matrix, width, height);
        break;
    }
}

int main() {

    int **matrix;
    int width, height;
    int i, j;

    int chosenOption = loadMenu();
    char *filePath = getFilePath(chosenOption);

    matrix = readPgm(filePath, &width, &height);

    filterMenu(matrix, width, height);

    return 0;
}