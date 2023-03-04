# Dada tres tuplas representando pontos no plano cartesiano, verifique se os pontos estao alinhados.

def determinante(matriz):
    principal = int(0)
    secundaria = int(0)
    for linha in range(len(matriz[0])):
        for coluna in range(len(matriz[:2])):
            matriz[linha].append(matriz[linha][coluna])
    for i in range(len(matriz)):
        coluna = i
        diagonal = 1
        for linha in range(len(matriz)):
            diagonal *= matriz[linha][coluna]
            coluna += 1
        principal += diagonal
    for i in range(len(matriz[0])-1, 1, -1):
        coluna = i
        diagonal = 1
        for linha in range(len(matriz)):
            diagonal *= matriz[linha][coluna]
            coluna -= 1
        secundaria -= diagonal
    return principal + secundaria


def pontosAlinhados(pontoA, pontoB, pontoC):
    lista = [pontoA, pontoB, pontoC]
    matriz = []
    for ponto in lista:
        linha = []
        for elemento in ponto:
            linha.append(elemento)
        linha.append(1)
        matriz.append(linha)
    return determinante(matriz) == 0