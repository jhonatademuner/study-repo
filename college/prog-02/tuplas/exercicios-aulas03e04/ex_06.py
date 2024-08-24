# Crie uma funcao para inserir um sorteio, verificar as apostas vencedoras, dividir
# o premio entre os bilhetes vencedores, e listar o premio que cada participantes ir a
# receber. Modularize a funcao utilizando ao menos as seguintes sub-rotinas:
# - Funcao que faz a leitura dos 6 is sorteados, e retorna uma lista com
# esses is.
# - Funcao que verifica se uma lista l1 esta contida na lista l2. Utilizada para
# conferir se todos os is sorteados fazem parte dos is apostas em um bilhete.
# - Funcao que conta quais bilhetes foram premiados.
# - Funcao que lista todos os vencedores de cada bilhete premiado, alem do premio
# que cada apostador recebera por ele. Recebe como parametro os indices dos
# bilhetes premiados na lista de apostas, e o premio daquele bilhete, ja dividido
# entre a quantidade de bilhetes que foram premiados. Para identificar cada bilhete,
# enumere-os a partir de 1.

#$ Biblioteca utilizada para a geracao de numeros aleatorios
import random

#$ Funcao para sorteio dos numeros vencedores
def sorteador():

    quantNum = int(input("Insira quantos numeros serao sorteados: "))

    #$ Definicao de variavel
    numSorteados = []

    #$ Sorteio dos numeros e atribuicao a uma lista
    while quantNum > 0:
        num = random.randint(1,60)
        if not(num in numSorteados):
            numSorteados.append(num)
            quantNum -= 1
    numSorteados.sort()

    #$ Saida da funcao
    return numSorteados


#$ Funcao para validar se os numeros sorteados estao presentes em ao menos um bilhete
def validacaoNumSorteados(bancoApostas, numSorteados):

    #$ Definicao de variavel
    ocorrencias = 0

    #$ Checagem se o numero esta presente na lista em questao
    for aposta in bancoApostas:
        for numero in numSorteados:
            if numero in aposta[1]:
                ocorrencias += 1
                
    #$ Saida da funcao
    return ocorrencias >= 6


#$ Funcao para definir os bilhetes ganhadores do sorteio
def definicaoGanhadores(bancoApostas, numSorteados):

    #$ Definicao de variavel
    ganhadores = []

    #$ Checagem se o bilhete em questao ganhou o sorteio
    for aposta in bancoApostas:
        ganhador = []
        acertos = 0
        for i in numSorteados:
            if i in aposta[1]:
                acertos += 1
        if acertos >= 6:
            ganhador.append(aposta[0])
            ganhador.append(bancoApostas.index(aposta) + 1)
            ganhadores.append(ganhador)

    #$ Saida da funcao
    return ganhadores


#$ Funcao para imprimir os ganhadores do sorteio
def imprimirGanhadores(ganhadores):
    premio = float(input("Insira o valor do premio do sorteio: "))
    for bilhete in ganhadores:

        #$ Contador do numero de apostas
        print("BILHETE GANHADOR:", bilhete[1])

        #$ Borda superior
        print("=" * 80)
        print("||", "NOME", " " * 26, "|", "CPF", " " * 10, "|", "PREMIO"," " * 16,"||")
        print("||", "-" * 31,"|", "-" * 14, "|",  "-" * 23, "||")

        #$ Saida dos nomes do jogadores
        for jogador in bilhete[0]:
            print("||", jogador[0], " " * (30 - len(jogador[0])), "|", end="")

            #$ Saida do CPF dos jogadores
            print(" ", jogador[1][0:3],".", jogador[1][3:6],".", jogador[1][6:9],"-", jogador[1][9:11], " |",sep="",end=" ")

            #$ Saida do numero apostador

            premioJogador = premio / len(ganhadores) / len(bilhete[0])
            print(f'R$ {premioJogador:.2f}', end='')
            print(' ' * (19 - len(str(premioJogador))), '||')

        #$ Borda inferior
        print("=" * 80, "\n")

#@ =====================================
#@ || CODIGO TESTADO - 100% FUNCIONAL ||
#@ =====================================