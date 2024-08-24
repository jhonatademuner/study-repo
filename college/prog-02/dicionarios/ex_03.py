# Adapte o codigo do Bolao para que os dados dos jogadores sejam salvos em um dicionario, ao inves de uma lista.

#$ Funcao para validacao de CPF repetido
def cpfRepetido(cpf, bancoJogadores):
    for nome in bancoJogadores:
        if cpf == bancoJogadores[nome]:
            return True

#$ Funcao para cadastrar novo jogador
def cadastrarNovoJogador(bancoJogadores):

    #$ Entrada do usuario
    nome = input("Insira o nome do jogador: ")
    cpf = input("Insira o CPF do jogador: ")
    print('\n' * 5)

    #$ Cadastro do primeiro jogador
    if bancoJogadores == {}:
        bancoJogadores[nome] = cpf

    #$ Validacao de cpf repetido
    else:
        if cpfRepetido(cpf, bancoJogadores):
            print('ERRO. Jogador ja cadastrado no sistema.')

        #$ Cadastro de demais jogadores
        else:
            bancoJogadores[nome] = cpf
            return bancoJogadores

    #$ Saida principal da funcao
    return bancoJogadores

