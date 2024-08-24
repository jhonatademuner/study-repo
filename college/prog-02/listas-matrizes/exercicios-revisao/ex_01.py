# Dado um inteiro >= 0, calcule o fatorial de N.

def fatorial(x):
    i = 1
    resultado = 1
    while i <= x:
        resultado *= i
        i += 1
    return resultado