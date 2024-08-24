#ifndef MENUS_H
#define MENUS_H

void clearTerminal();

void clearString(char *string);

int loadMenu();

char *getFilePath(int chosenOption);

void displayFiterMenu();

void filterMenu(int **matrix, int width, int height);

#endif // MENUS_H