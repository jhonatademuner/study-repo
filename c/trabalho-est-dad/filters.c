#include <stdio.h>
#include <stdlib.h>

#include "filters.h"


void freeMatrix(int **matrix, int height)
{
    int i;
    for (i = 0; i < height; i++)
    {
        free(matrix[i]);
    }
    free(matrix);
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