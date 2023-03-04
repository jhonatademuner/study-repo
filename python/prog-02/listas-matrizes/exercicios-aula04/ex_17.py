# Dados M e N, crie e retorne uma matriz M x N nula.

def criarMatriz(m,n):
    matriz = []
    for i in range(m):
        linha=[]
        for i in range(n):
            linha.append(None)
        matriz.append(linha)
    return matriz