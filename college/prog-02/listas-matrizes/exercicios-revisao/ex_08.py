# Dado um numero K, imprima todos os numeros primos ate K.

import ex_07

def primos(k):
    i = 1
    while i <= k:
        if ex_07.primo(i):
            print(i)
        i += 1