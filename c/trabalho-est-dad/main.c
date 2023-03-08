#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <math.h>
#include <time.h>
#include <stdbool.h>
#include <ctype.h>
#include <dirent.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>


int loadMenu(){
    char loadOptions[3][40] = {"1. Escolher imagem do seu PC\n", "2. Escolher imagens armazenadas\n", "3. Voltar\n"};
    int chosenOption;

    for (int i = 0; i < 3; i++){
        printf("%s", loadOptions[i]);
    }

    printf("Digite a opcao desejada: ");
    scanf("%d", &chosenOption);

    return chosenOption;
}


char* getImgPath(int chosenOption, char* imgPath) {

    struct dirent *entry;
    DIR *dir;
    
    int imgOption;
    char imgName[100];
    

    switch (chosenOption) {
        case 1:
            printf("Insira o caminho da imagem: ");
            scanf("%s", imgPath);
            return imgPath;

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
            imgPath = imgName;
            return imgPath;

        case 3:
            break;
        default:
            loadMenu();
            break;
    }
    return NULL;
}




const char* filterMenu(imagePath){
    char filterOptions[4][40] = {"1. Negativo\n", "2. Espelhamento\n", "3. Borramento\n", "4. Voltar\n"};
    int chosenOption;

    for(int i = 0; i < 4; i++){
        printf("%s", filterOptions[i]);
    }

    printf("Digite a opcao desejada: ");
    scanf("%d", &chosenOption);

    switch (chosenOption)
    {
    case 1:
        return negativeFilter(imagePath);

    case 2:
        return flippingFilter(imagePath);

    case 3:
        return blurFilter(imagePath);

    case 4:
        loadMenu();
        break;

    default:
        filterMenu();
        break;
    }
}

int negativeFilter(char* imagePath){
    
}

int flippingFilter(char* imagePath){
    
}

int blurFilter(char* imagePath){
    
}

int main(void){

    int chosenOption;

    chosenOption = loadMenu();
    char* imgPath = getImgPath(chosenOption, imgPath);

    filterMenu(imgPath);

    return 0;
}


