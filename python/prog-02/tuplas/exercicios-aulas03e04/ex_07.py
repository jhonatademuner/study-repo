# Implemente um jogo semelhante ao Genius. Muito popular na decada de 1980, o
# brinquedo buscava estimular a memorizacao de cores. Com um formato semelhante
# a um OVNI, possuia botoes coloridos que emitiam sons harmonicos e se iluminavam
# em sequencia. Cabia aos jogadores repetir a ordem das cores sem errar. Ao inves de
# cores, utilizaremos numeros. A cada iteracao, o programa ira sortear um algarismo
# aleatorio, que sera exibido para o usuario. Cabera ao usuario memorizar e digitar
# corretamente toda a sequencia de caracteres exibidos

import random
import os

#$ Funcao para limpar o terminal
def clear():
    if os.name == 'nt':
        os.system('cls')
    else:
        os.system('clear')

def main():

    #$ Criacao de variaveis
    sequenciaSorteada = []
    sequenciaUsuario = []

    #$ Checagem da sequencia
    while sequenciaUsuario == sequenciaSorteada:
        
        clear()

        #$ Definicao e saida do numero sorteado
        numeroSorteado = random.randint(1,4)
        sequenciaSorteada.append(numeroSorteado)
        print(f'O numero sorteado foi: {numeroSorteado}')

        #$ Entrada do usuario
        sequenciaUsuario = input('\nInsira a sequencia de numeros separada por espacos:\n').split()
        sequenciaUsuario = map(int, sequenciaUsuario) 
        sequenciaUsuario = list(sequenciaUsuario)

    #$ Saida final do programa
    print(f'Voce perdeu! Voce acertou uma sequencia de {len(sequenciaSorteada) - 1} numeros.')

if __name__ == '__main__':
    main()