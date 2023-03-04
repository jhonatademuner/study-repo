# Dada uma matriz M, imprima esta matriz na tela.

def imprimirMatriz(m):
    for linha in m:
        for elemento in linha:
            print(elemento, end="\t")
        print()