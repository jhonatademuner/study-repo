# Defina um procedimento que receba uma matriz quadrada M como parametro. A funcao deve transformar a matriz M na matriz transposta de M, em seguida transformar essa matriz transposta em uma matriz triangular inferior e, por fim, imprimir a matriz resultante.

import ex_18

def triangularInferior(matriz):
    transposta = []
    for i in range(len(matriz)):
        linha = []
        for j in range(len(matriz)):
            linha.append(matriz[j][i])
        transposta.append(linha)
        coluna = 1
    for i in range(1,len(transposta)):
        for j in range(coluna):
            transposta[i][j] = 0
        coluna += 1
    ex_18.imprimirMatriz(transposta)