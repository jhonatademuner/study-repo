# Faca um procedimento que receba N e K como parametros e imprima os N primeiro multiplos de K.

def multiplos(n,k):
    for i in range (1, n + 1):
        print(f'{k} * {i} = {k * i}')

def multiplos2(n,k):
    i = 1
    while i <= n:
        print(f'{k} * {i} = {k * i}')
        i += 1