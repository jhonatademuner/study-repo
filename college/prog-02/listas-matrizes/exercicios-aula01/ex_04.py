# Dada uma lista e um lemento, retorne  o numero de ocorrencias do elemento na lista.

def ocorrencias(lista, elemento):
    ocorrencia = 0
    for i in range (len(lista)):
        if lista[i] == elemento:
            ocorrencia += 1
    return ocorrencia