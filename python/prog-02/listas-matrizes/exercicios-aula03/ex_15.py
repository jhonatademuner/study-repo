# Dada uma lista ordenada L e dois inteiros X e Y (X < Y), retorne uma sublista contendo todos os elementos de L que estiverem entre X e Y.

def sublista(l,x,y):
    elementos = []
    for i in l:
        if i > x and i < y:
            elementos.append(i)
    return elementos