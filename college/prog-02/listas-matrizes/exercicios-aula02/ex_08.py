# Dado um numero N, retorne uma lista com os N primeiros elementos da sequencia de Fibonacci.

def fibonacci(n):
    lista = []
    for i in range (n):
        if i < 2:
            lista.append(1)
        else:
            lista.append(lista[i-2] + lista[i-1])

    return lista