# Dados dois numero inteiro positivos N e P, calcule a combinacao de N e P.

import ex_01

def combinacao(n,p):
    return ex_01.fatorial(n) / (ex_01.fatorial(p) * ex_01.fatorial(n-p))