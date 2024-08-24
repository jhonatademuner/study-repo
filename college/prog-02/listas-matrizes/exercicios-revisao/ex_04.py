# Dado dois inteiros positivos X e Y, verifique se X e divisor de Y. O retorno deve ser booliano.

def divisor(x,y):
    return y % x == 0

def divisor2(x,y):
    if y % x == 0:
        return True
    else:
        return False
