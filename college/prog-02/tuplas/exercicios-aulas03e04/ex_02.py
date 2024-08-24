# Crie uma funcao para a primeira opcao do menu (cadastrar novo jogador). A funcao
# deve fazer a leitura do nome e CPF de um jogador e inseri-lo no sistema. Caso
# um jogador com o mesmo CPF ja tenha sido inserido, deve exibir uma mensagem
# de erro e volta para o menu sem que ele tenha sido inserido. Utilize uma funcao
# auxiliar para verificar se algum funcionario com aquele CPF ja foi inserido no sistema.

import function

def cadastrarNovoJogador(bancoJogadores):

    #$ Entrada do usuario
    nome = input("Insira o nome do jogador: ")
    cpf = input("Insira o CPF do jogador: ")
    print('\n' * 5)

    #$ Definicao das variaveis
    jogador = (nome, cpf)

    #$ Cadastro do primeiro jogador
    if bancoJogadores == []:
        bancoJogadores.append(jogador)

    #$ Validacao de cpf repetido
    else:
        if function.cpfRepetido(cpf, bancoJogadores):
            print('ERRO. Jogador ja cadastrado no sistema.')

        #$ Cadastro de demais jogadores
        else:
            bancoJogadores.append(jogador)
            return bancoJogadores

    #$ Saida principal da funcao
    return bancoJogadores
