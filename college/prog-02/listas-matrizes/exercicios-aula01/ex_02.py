# Faca um procedimento que leia 10 numeros digitados pelo usuaruio armazene a metade de cada um deles numa lista, e depois imprima esta lista.

def metade():
    lista = []
    for i in range (10):
        num = float(input())
        lista.append(num / 2)

    print(lista)