# Dado um numero X, verifique se ele e primo.

import ex_04

def primo(x):
    possiveisDivisores = 0
    i = 1
    while i <= x:
        if ex_04.divisor(i,x):
            possiveisDivisores += 1
        i += 1
    return possiveisDivisores == 2