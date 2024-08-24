# Dada uma lista de numeros, faca uma funcao que encontre e retorne  o maior deles.

def maximo(lista):
    maiorNum = lista[0]
    for i in range(len(lista)):
        if lista[i] > maiorNum:
            maiorNum = lista[i]
    return maiorNum