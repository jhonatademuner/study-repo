# Considere um jogo de cadrez onde pecas sao movimentadas em um tabuleiro divido e, 8 linha e 8 colunas. Considere ainda os movimentos do cavalo, que se movimenta em L. Defina um procedimento que recebe uma matriz M 8x8 como parametro, na qual rodos os elemento sao nulos exceto a posicao em que  o cavalo se encontra (representado pelo numero 1). Encontre esta posicao e imprima a quantidade de movimentos que este cavalo pode fazer, considerando que ele nao pode se movimentar para uma posicao fora do tabuleiro.

def ocorrencia(lista, elemento):
    for i in lista:
        if i == elemento:
            return True

def cavalo(tabuleiro):
    for linha in tabuleiro:
        if ocorrencia(linha, 1):
            linha = tabuleiro.index(linha)
            coluna = linha.index(1)
    if linha in range(0,8,7) and coluna in range(0,8,7):
        movimentosPossiveis = 2
    elif (linha in range(1, 7, 5) and coluna in range(0, 8, 7)) or (coluna in range(1, 7, 5) and linha in range(0, 8, 7)):
        movimentosPossiveis = 3
    elif linha in range(1,7,5) and coluna in range(1,7,5):
        movimentosPossiveis = 4
    elif ((linha in range(2, 6)) or (coluna in range(2, 6))) and ((linha in range(0, 8, 7)) ^ (coluna in range(0, 8, 7))):
        movimentosPossiveis = 4
    elif (linha in range(2,6) and coluna in range(1,7,5)) or (coluna in range(2,6) and linha in range(1,7,5)):
        movimentosPossiveis = 6
    else:
        movimentosPossiveis = 8
    print(movimentosPossiveis)