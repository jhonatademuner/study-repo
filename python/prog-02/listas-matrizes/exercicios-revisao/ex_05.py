# Dado um numero K, imprima todos os divisores de K.

import ex_04

def divisores(k):
    i = 1
    while i <= k:
        if ex_04.divisor(i,k):
            print(i, end = ' ')
        i += 1