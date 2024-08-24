# Dada uma lista, faca um procedimento que inverta a ordem de seus elementos.

def inverter(lista):
    listaInvertida = []
    for i in range (len(lista) - 1, -1, -1):
        listaInvertida.append(lista[i])
    print(listaInvertida)