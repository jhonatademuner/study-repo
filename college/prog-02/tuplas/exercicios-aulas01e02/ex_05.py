# Uma Copa do Mundo de futebol de botoes esta sendo realizada com times de todo o mundo. A classificao e baseada no numero de pontos ganhos pelo times, e a distribuicao de pontos e feita da forma usual. Ou seja, quando um time ganha um jogo, ele recebe 3 pontos; se o jogo termina empatado, ambos os times recevem 1 ponto; e o perdedor nao recebe nenhum ponto. Dada a classificacao atual dos times e o numero de times participantes na Copa do Mundo, sua tarefa e criar uma funcao que determine quantos jogos terminaram empatados ate  o momento. A funcao deve receber dois parametros: o numero de jogos ja realizados ate o momento e uma lista com a classificao atual. A classificao atual e dada por uma lista de tuplas, onde cada tupla contem o nome de um time e os pontos ganhos por aquele time.

def copaMundo(jogos, classificacao):
    pontosTotal = 0
    for (_, pontos) in classificacao:
        pontosTotal += pontos
    empates = jogos * 3 - pontosTotal
    return empates