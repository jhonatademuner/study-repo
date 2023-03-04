# Dadas as matrizes A e B de mesmo tamanho, retorne uma terceira matriz com o resultado de A + B.

def somarMatrizes(m,n):
    resultado = m.copy()
    for i in range(len(m)):
        for j in range(len(m[0])):
            resultado[i][j] = m[i][j] + n[i][j]
    return resultado