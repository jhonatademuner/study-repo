# Faca uma funcao que crie e retorne uma lista com todos os numeros pares de 1 a 100, porem na ordem regressiva.

def regressiva():
    lista = []
    for i in range (100, 1, -2):
        lista.append(i)
    print(lista)
