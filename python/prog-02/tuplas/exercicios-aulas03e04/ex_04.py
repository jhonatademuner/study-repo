# Crie uma funcao para cadastrar uma nova aposta. Modularize a funcao, de forma
# que ela utilize duas sub-rotinas auxiliares:
# Funcao que faz a leitura da quantidade de jogadores que irao dividir o bilhete
# e dos CPFs dos jogadores participantes da aposta (sempre verificando se o
# CPF pertence a algum jogador ja cadastrado no sistema). Quando um CPF
# nao cadastrado for digitado, permanece solicitando um novo CPF at ́e que o
# usuario digite um CPF correto, ou digite 0 para desistir do cadastro da aposta
# e voltar ao menu.
# Funcao que faz a leitura da quantidade de numeros a serem apostados no
# bilhete e dos numeros apostados. Caso o usuario digite um numero ja inserido,
# deve permanecer solicitando outro numero at ́e que seja digitado um numero valido.

import function

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
        if function.cpfRepetido(cpf, bancoJogadores)  and cpf != 0 and not(cpf in jogadores):
            quantJogadoresAposta -= 1
            indice = function.buscadorNomePorCpf(cpf, bancoJogadores)
            nome = bancoJogadores[indice][0]
            listaAux = []
            listaAux = [nome, cpf]
            jogadores.append(listaAux)
        elif cpf == "0":
            quantJogadoresAposta = 0

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
        else:
            numerosApostados.append(num)
            quantNumerosAposta -= 1

    #$ Saida da funcao
    return numerosApostados

def cadastrarNovaAposta(bancoJogadores, bancoApostas):

    #$ Cadastro de novas apostas
    jogadores = validacaoQuantJogadoresCpf(bancoJogadores)
    quantNumerosAposta = int(input("Quantos numeros voce quer apostar: "))
    while quantNumerosAposta not in range (6, 16):
        print("Insira um numero entre 6 e 8.")
        quantNumerosAposta = int(input("Quantos numeros voce quer apostar: "))
    numerosApostados = leituraNumerosAposta(quantNumerosAposta)

    #$ Saida da funcao
    aposta = (jogadores, numerosApostados)
    bancoApostas.append(aposta)
    return bancoApostas
