# Dada uma lista de numeros, faca uma funcao que encontre e retorne  o indice do maior deles.

def posicaoMaximo(lista):
    maiorNum = lista[0]
    for i in range(len(lista)):
        if lista[i] > maiorNum:
            maiorNum = lista[i]
            indiceMaiorNum = i
    return indiceMaiorNum