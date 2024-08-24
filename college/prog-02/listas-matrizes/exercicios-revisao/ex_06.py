# Dados dois numeros M e N, imprima o máximo divisor comum entre M e N.

import ex_04

def menor(m,n):
    if m < n:
        return m
    else:
        return n

def mdc(m,n):
    menorNum = menor(m,n)
    while not(ex_04.divisor(menorNum,m)) or not(ex_04.divisor(menorNum,n)):
        menorNum -= 1
    print(menorNum)