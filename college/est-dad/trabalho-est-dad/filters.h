#ifndef FILTERS_H
#define FILTERS_H

  void freeMatrix(int **matrix, int height);

  void negativeFilter(int **matrix, int width, int height);

  void flipFilter(int **matrix, int width, int height);

  int *getNeighbours(int **m, int i, int j, int *neighbours);

  int getMax(int *neighbours);

  void copyMatrix(int **m, int **newMatrix, int width, int height);

  void blurFilter(int **m, int width, int height);

  void brightenFilter(int **m, int width, int height);

#endif // FILTERS_H