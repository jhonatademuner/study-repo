import function

#$ Programa principal
def main():

    #$ Menu inicial
    opcao = function.menu()

    #$ Definicao de variaveis
    bancoJogadores = []
    bancoApostas = []

    #$ Definicao do processo a ser executado
    while opcao != 5:

        #$ Processo de cadastrar novo jogador
        if opcao == 0:
            function.limpaTela()
            bancoJogadores = function.cadastrarNovoJogador(bancoJogadores)
            print()
            opcao = function.menu()

        #$ Processo de visualizar todos os jogadores cadastrados
        elif opcao == 1:
            function.limpaTela()
            function.visualizarJogadores(bancoJogadores)
            print()
            opcao = function.menu()
        
        #$ Processo de cadastrar nova aposta
        elif opcao == 2:
            function.limpaTela()
            function.visualizarJogadores(bancoJogadores)
            print()
            bancoApostas = function.cadastrarNovaAposta(bancoJogadores, bancoApostas)
            print()
            opcao = function.menu()

        #$ Processo de visualizar todos as apostas feitas ate o momento
        elif opcao == 3:
            function.limpaTela()
            function.imprimirApostas(bancoApostas)
            print()
            opcao = function.menu()

        #$ Processo de sortear os numeros ganhadores, definir e imprimir os bilhetes
        elif opcao == 4:
            function.limpaTela()
            numSorteados = function.sorteador()
            print()
            if function.validacaoNumSorteados(bancoApostas, numSorteados):
                function.imprimirGanhadores(function.definicaoGanhadores(bancoApostas, numSorteados))
            else:
                 print("Nenhum bilhete contem os numeros sorteados.")
            print()
            opcao = function.menu()

    print("Programa finalizado")

if __name__ == '__main__':
    main()