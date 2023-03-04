# Versão diretamente interativa do "ex_25_1" - Robo Colecionador (Maratona de programacao 2010)

# Instrucoes:
# Objetivo: Pegar todas as figurinhas da copa, para finalizar a arena deve se inserir qualquer comando diferente dos citados abaixo:
# "D" -> girar o robo 90 graus para a direita
# "E" -> girar o robo 90 graus para a esquerda
# "F" -> andar para frente
# "." -> celula normal;
# "*" -> celula que contem uma figurinha da Copa;
# "#" -> celula que contem uma pilastra;

def imprimirArena(arena):
    print("||", "===" * len(arena), "||")
    for linha in arena:
        print("||", end="  ")
        for elemento in linha:
            print(elemento, end="  ")
        print("||")
    print("||", "===" * len(arena), "||")

def ocorrencias(lista, elementoDesejado):
    ocorrencia = 0
    for elemento in lista:
        if elemento == elementoDesejado:
            ocorrencia += 1
    return ocorrencia

def roboColecionador(arena):
    orientacao = ["^",">","v","<"]
    figurinhasTotais = 0
    figurinhasRestantes = 0

    print("Arena a ser usada: ")
    imprimirArena(arena)

    #% Posicao Inicial da Peca
    for linha in arena: 
        for coluna in linha:
            if (coluna != ".") and (coluna != "*") and (coluna != "#"):
                posicaoY = arena.index(linha)
                posicaoX = linha.index(coluna)
                indice = orientacao.index(coluna)

    #% Figurinhas Totais na Arena
    for linha in arena:
        figurinhasTotais += ocorrencias(linha, "*")

    #% Comandos do Usuario
    comando = "D"
    while comando == 'D' or comando == 'E' or comando == 'F':
        entradaUsuario = input("\nInsira seu comando: ")
        comando = entradaUsuario.upper()

        #% Definicao da Orientacao
        if comando == 'D':
            indice += 1
            arena[posicaoY][posicaoX] = orientacao[indice % 4]
        elif comando == 'E':
            indice -= 1
            arena[posicaoY][posicaoX] = orientacao[indice % 4]

        #% Validacao/Movimentacao da Peca
        if comando == "F":
            if indice % 4 == 0:
                if posicaoY - 1 in range(len(arena)) and posicaoX in range(len(arena)):
                    if arena[posicaoY - 1][posicaoX] != "#":
                        arena[posicaoY][posicaoX], arena[posicaoY - 1][posicaoX] = ".", orientacao[indice  % 4]
                        posicaoY -= 1
            elif indice % 4 == 1:
                if posicaoY in range(len(arena)) and posicaoX + 1 in range(len(arena)):
                    if arena[posicaoY][posicaoX + 1] != "#":
                        arena[posicaoY][posicaoX], arena[posicaoY][posicaoX + 1] = ".", orientacao[indice  % 4]
                        posicaoX += 1
            elif indice % 4 == 2:
                if posicaoY + 1 in range(len(arena)) and posicaoX in range(len(arena)):
                    if arena[posicaoY + 1][posicaoX] != "#":
                        arena[posicaoY][posicaoX], arena[posicaoY + 1][posicaoX] = ".", orientacao[indice  % 4]
                        posicaoY += 1
            elif indice % 4 == 3:
                if posicaoY in range(len(arena)) and posicaoX - 1 in range(len(arena)):
                    if arena[posicaoY][posicaoX - 1] != "#":
                        arena[posicaoY][posicaoX], arena[posicaoY][posicaoX - 1] = ".", orientacao[indice  % 4]
                        posicaoX -= 1

        imprimirArena(arena)
    
    #% Figurinhas Restantes na Arena
    for linha in arena:
        figurinhasRestantes += ocorrencias(linha, "*")

    figurinhasColetadas = figurinhasTotais - figurinhasRestantes
    print(f'\nFigurinhas coletadas = {figurinhasColetadas}')


# Algumas arenas para teste:

# arena1 = [["*","*","*"],["*","v","*"],["*","*","*"]]
# roboColecionador(arena1)

# arena2 = [[".",".",".","#"],["*","#","<","."],["*",".","*","."],["*",".","#","."]]
# roboColecionador(arena2)

arena3 = [[".",".",".",".","*",".",".",".",".","."],[".",".",".",".",".",".",".","*",".","."],[".",".",".",".",".","*",".",".",".","."],[".",".","*",".","#",".",".",".",".","."],[".",".",".","#","^",".","*",".",".","*"],[".",".",".","*",".",".",".",".",".","."],[".",".",".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".",".",".","."]]
roboColecionador(arena3)