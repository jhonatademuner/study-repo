# As meninas querem saber qual u o numero maximo de cartas que podem ser trocadas. Por exemplo, se Alice tem o conjunto de cartas [1,1,2,3,5,7,8,8,9,15] e Beatriz o conjunto [2,2,2,3,4,6,10,11,11], elas podem trocar entre si no maximo quatro cartas. Escreva uma funcao que receba como parmetros a lista de cartas que Alice tem e a lista de cartas que Beatriz possui, e imprima o numero maximo de cartas que podem ser trocadas. As cartas de Alice e Beatriz sao apresentadas em ordem nao decrescente.

def ocorrencias(lista, elemento):
    ocorrencia = 0
    for i in lista:
        if i == elemento:
            ocorrencia += 1
    return ocorrencia

def menor(x,y):
    if x < y:
        return x
    else:
        return y

def trocaCartas(l1,l2):
    cartasL1 = 0
    cartasL2 = 0
    for i in l1:
        while ocorrencias(l1,i) > 1:
            l1.pop(l1.index(i))
    for i in l2:
        while ocorrencias(l2,i) > 1:
            l2.pop(l2.index(i))
    for i in l1:
        if ocorrencias(l2,i) == 0:
            cartasL1 += 1
    for i in l2:
        if ocorrencias(l1,i) == 0:
            cartasL2 += 1
    print(menor(cartasL1,cartasL2))
    