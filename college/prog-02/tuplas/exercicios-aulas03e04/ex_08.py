# Implemente um jogo semelhante ao Genius. Muito popular na decada de 1980, o 
# brinquedo buscava estimular a memorizacao de cores. Com um formato semelhante 
# a um OVNI, possuıa botoes coloridos que emitiam sons harmonicos e se iluminavam 
# em sequencia. Cabia aos jogadores repetir a ordem das cores sem errar. Ao inves de 
# cores, utilizaremos numeros. A cada iteracao, o programa ira sortear um algarismo 
# aleatorio, que sera exibido para o usuario. Cabera ao usuario memorizar e digitar 
# corretamente toda a sequencia de caracteres exibidos.

#$ Biblioteca utilizada para a geracao de numeros aleatorios
import random

#$ Biblioteca usada na funcao para limpar a tela
import os

#$ Funcao para limpar a tela
def clear():
    if os.name == 'nt':
        os.system('cls')
    else:
        os.system('clear')

#$ Funcao do jogo/ principal
def genius():

    #$ Inicializacao de variaveis
    contador = -1
    sequenciaGenius = []
    sequenciaUsuario = ()

    #$ Verificacao de sequencia correta
    while sequenciaUsuario == tuple(sequenciaGenius):

        #$ Sorteio do numero aleatorio
        numSorteado = random.randint(1,4)

        #$ Atribuicao da sequencia a uma lista
        sequenciaGenius.append(str(numSorteado))

        #$ Exibicao do numero sorteado
        print(f'O próximo número da sequência é: {numSorteado}')
        contador += 1

        #$ Entrada do usuario
        sequenciaUsuario = tuple(input('Insira a sequência de números:\n').split(' '))

        #$ Limpa tela
        clear()

    #$ Mensagem do final do jogo
    print(f'Mais sorte na próxima! Você conseguiu acertar {contador} números.')