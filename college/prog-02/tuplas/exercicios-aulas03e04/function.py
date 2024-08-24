# # Definicao de todas as funcoes utilizadas no Programa

#$ Biblioteca usada na funcao de limpar o terminal
import os

#$ Biblioteca usada para obter a tecla pressionada pelo usuario
import msvcrt

#$ Biblioteca usada para a geracao de numeros aleatorios
import random


#$ Funcao para limpar o terminal
def limpaTela():
    if os.name == 'nt':
        os.system('cls')
    else:
        os.system('clear')

#$ Funcao auxiliar para imprimir os elementos de uma lista
def imprimirLista(lista):
    for elemento in lista:
        print(elemento, end=" ")


# #$ ==========
# #$ || MENU ||
# #$ ==========

#$ Funcao principal do menu
def menu():

    #$ Definicao de variaveis
    key = -2
    indice = 0
    cursor = ['<-', '', '', '', '', '']
    
    #$ Saida das opcoes do menu
    opcoes(cursor)

    while key != b'\r':

        #$ Entrada do usuario (tecla pressionada)
        key = msvcrt.getch()

        #$ Validacao de primeira entrada("Enter" como primeira tecla)
        if key != b'\r':
            indice, cursor = cursorOpcao(key, indice)
            limpaTela()
            opcoes(cursor)

    #$ Saida principal da funcao
    return cursor.index('<-')


# #$ Saida das opcoes do menu
def opcoes(cursor):
    
    print('=' * 45)
    print("Cadastrar novo jogador","\t" * 3, cursor[0])
    print("Visualizar jogadores cadastrados","\t", cursor[1])
    print("Cadastrar nova aposta","\t" * 3, cursor[2])
    print("Visualizar apostas cadastradas","\t" * 2, cursor[3])
    print("Inserir resultados e listar vencedores","\t", cursor[4])
    print("Finalizar programa","\t" * 3, cursor[5])
    print('=' * 45)
    

#$ Definicao da posicao do cursor
def cursorOpcao(key, indice):

    #$ Entrada da tecla pressionada
    if key == b'H':
        indice -= 1
    elif key == b'P':
        indice += 1

    #$ Movimentacao do cursor
    indice %= 6
    cursor = ['', '', '', '', '','']
    cursor[indice] = '<-'
    return indice, cursor


#$ =================================
#$ || CADASTRO DE NOVOS JOGADORES ||
#$ =================================

#$ Funcao para validacao de CPF repetido
def cpfRepetido(cpf, bancoJogadores):
    for (_, cpfJogador) in bancoJogadores:
        if cpf == cpfJogador:
            return True


#$ Funcao para cadastro de novo jogador
def cadastrarNovoJogador(bancoJogadores):

    #$ Entrada do usuario
    nome = input("Insira o nome do jogador: ")
    cpf = input("Insira o CPF do jogador: ")
    print()

    #$ Definicao das variaveis
    jogador = (nome, cpf)

    #$ Validacao de cpf repetido
    if cpfRepetido(cpf, bancoJogadores):
        print('ERRO. Jogador ja cadastrado no sistema.')
    
    #$ Validacao da quantidade de digitos do cpf
    elif len(cpf) != 11:
        print("ERRO. O cpf deve ter 11 digitos.")

    #$ Cadastro de jogadores
    else:
        bancoJogadores.append(jogador)
        return bancoJogadores

    #$ Saida principal da funcao
    return bancoJogadores


#$ =========================================
#$ || VISUALIZAR OS JOGADORES CADASTRADOS ||
#$ =========================================

#$ Funcao para impressao das apostas cadastradas
def visualizarJogadores(bancoJogadores):

#$ Borda superior
    print("=" * 68)
    print("||", "NOME", " " * 40, "|", "CPF", " " * 10, "||")
    print("||", "-" * 45,"|", "-" * 14, "||")

    #$ Saida dos nomes e cpf dos jogadores
    for (nome, cpf) in bancoJogadores:
        print("||", nome, " " * (44 - len(nome)), "|", end="")
        print(" ", cpf[0:3],".", cpf[3:6],".", cpf[6:9],"-", cpf[9:11], " ||",sep="")

    #$ Borda inferior
    print("=" * 68)


#$ ===============================
#$ || CADASTRO DE NOVAS APOSTAS ||
#$ ===============================

#$ Funcao para pegar o nome do jogador usando o cpf
def buscadorNomePorCpf(cpf, bancoJogadores):
    for (_, cpfJogador) in bancoJogadores:
        if cpf == cpfJogador:
            return (bancoJogadores.index((_, cpfJogador)))


#$ Funcao para obtencao e validacao dos jogadores da aposta
def validacaoQuantJogadoresCpf(bancoJogadores): 

    #$ Definicao de variaveis
    cpf = ''
    jogadores = []

    #$ Entrada do usuario
    quantJogadoresAposta = int(input("Insira quantos jogadores participarao dessa aposta: "))
    while quantJogadoresAposta > 0:
        cpf = input("Insira o CPF do jogador: ")

        #$ Validacao de CPF
        if cpfRepetido(cpf, bancoJogadores)  and cpf != "0" and not(cpf in jogadores):
            quantJogadoresAposta -= 1
            indice = buscadorNomePorCpf(cpf, bancoJogadores)
            nome = bancoJogadores[indice][0]
            listaAux = []
            listaAux = [nome, cpf]
            jogadores.append(listaAux)
        elif cpf == "0":
            quantJogadoresAposta = 0
        elif cpf in jogadores:
            print("Voce ja inseiriu esse cpf, tente outro.")
        else:
            print("O cpf inseriodo nao se encontra no banco de jogadores cadastrados.")

    #$ Saida da funcao
    return jogadores


#$ Funcao para obtencao e validacao dos numeros da aposta
def leituraNumerosAposta(quantNumerosAposta):

    #$ Definicao de variavel
    numerosApostados = []

    #$ Entrada do usuario
    while quantNumerosAposta > 0:
        num = int(input("Insira o numero que deseja apostar: "))

        #$ Validacao dos numeros inseridos
        if num in numerosApostados:
            print("ERRO. Numero ja inserido, insira outro numero.")
        elif not num in range(1, 61):
            print("ERRO. Insira um numero entre 1 e 60")
        else:
            numerosApostados.append(num)
            quantNumerosAposta -= 1

    #$ Saida da funcao
    return numerosApostados


#$ Funcao para cadastrar novas apostas
def cadastrarNovaAposta(bancoJogadores, bancoApostas):

    #$ Cadastro de novas apostas
    jogadores = validacaoQuantJogadoresCpf(bancoJogadores)
    quantNumerosAposta = int(input("Quantos numeros voce quer apostar: "))
    while quantNumerosAposta not in range (6, 16):
        print("Insira um numero entre 6 e 15.")
        quantNumerosAposta = int(input("Quantos numeros voce quer apostar: "))
    numerosApostados = leituraNumerosAposta(quantNumerosAposta)

    #$ Saida da funcao
    aposta = (jogadores, numerosApostados)
    bancoApostas.append(aposta)
    return bancoApostas


#$ ====================================
#$ || VISUALIZAR APOSTAS CADASTRADAS ||
#$ ====================================
ba = [([['jhonata', '12345678900']], [14, 47, 58, 69, 36, 25, 12, 32, 45,59,84,45]), ([['tiago', '98765432100'], ['joao', '78945612300']], [68, 57, 35, 24, 14, 69, 78, 23, 54])]
#$ Funcao para imprimir o banco de apostas
def imprimirApostas(bancoApostas):
    for aposta in bancoApostas:

        #$ Contador do numero de apostas
        print("APOSTA:", bancoApostas.index(aposta) + 1)

        #$ Borda superior
        print("=" * 116)
        print("||", "NOME", " " * 40, "|", "CPF", " " * 10, "|", "NUMEROS APOSTADOS"," " * 27,"||")
        print("||", "-" * 45,"|", "-" * 14, "|",  "-" * 45, "||")

        #$ Saida dos nomes do jogadores
        for jogador in aposta[0]:
            print("||", jogador[0], " " * (44 - len(jogador[0])), "|", end="")

            #$ Saida do CPF dos jogadores
            print(" ", jogador[1][0:3],".", jogador[1][3:6],".", jogador[1][6:9],"-", jogador[1][9:11], " |",sep="",end=" ")

            #$ Saida do numero apostador
            if aposta[0].index(jogador) == 0:
                imprimirLista(aposta[1])
                print(" " * (45 - len(aposta[1]) * 3), "||")
            else:
                print(" " * 45, "||")

        #$ Borda inferior
        print("=" * 116, "\n")


#$ ===================================
#$ || DEFINIR E IMPRIMIR GANHADORES ||
#$ ===================================

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
        print("=" * 95)
        print("||", "NOME", " " * 40, "|", "CPF", " " * 10, "|", "PREMIO"," " * 16,"||")
        print("||", "-" * 45,"|", "-" * 14, "|",  "-" * 23, "||")

        #$ Saida dos nomes do jogadores
        for jogador in bilhete[0]:
            print("||", jogador[0], " " * (44 - len(jogador[0])), "|", end="")

            #$ Saida do CPF dos jogadores
            print(" ", jogador[1][0:3],".", jogador[1][3:6],".", jogador[1][6:9],"-", jogador[1][9:11], " |",sep="",end=" ")

            #$ Saida do numero apostador

            premioJogador = premio / len(ganhadores) / len(bilhete[0])
            print(f'R$ {premioJogador:.2f}', end='')
            print(' ' * (19 - len(str(premioJogador))), '||')

        #$ Borda inferior
        print("=" * 95, "\n")