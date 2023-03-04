# Dado um numeno N, faca uma funcao que leia N numeros inteiros, e retorne uma lista com esses numeros.

def leitura(n):
    lista = []
    for i in range(n):
        lista.append(int(input()))
    print(lista)