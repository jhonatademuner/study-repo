# Dada duas posicoes (X, Y) e (M, N) em um tabuleiro de xadrez vazio, calcule e imprima a quantidade minima demovimentos que a dama precisa fazer para ir da posicao (X, Y) para a posicao (M, N).

def dama(x,y,m,n):
    if x == m and y == n:
        print('0')
    
    elif x == m or y == n or (abs(x-m) == abs(y-n)):
        print('1')

    else:
        print('2')