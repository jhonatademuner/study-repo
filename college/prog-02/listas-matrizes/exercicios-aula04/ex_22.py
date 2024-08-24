# Dada um matriz M 3x3, calcule o determinante de M:

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
    print(f'Determinate da matiz = {principal + secundaria}')
