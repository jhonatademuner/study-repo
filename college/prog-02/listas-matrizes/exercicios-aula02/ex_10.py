# Dados dois numeros K e N como parametros, retorne uma lista com todos os K primeiros multiplos de N.

def multiplos(k,n):
    lista = []
    for i in range (1, k + 1):
        lista.append(n * i)
    return lista