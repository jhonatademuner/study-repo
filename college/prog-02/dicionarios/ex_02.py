# Faca um programa no qual o usuario possa armazenar o numero de telefone de quantos
# contatos ele quiser. O programa tem um menu com duas opcoes:
# Cadastrar telefone: Usuario digita nome e telefone de um novo contato.
# Visualizar agenda: Programa exibe nomes e telefones cadastrados.
# As informacoes cadastradas precisam ser salvas em um arquivo texto. Enquanto
# estiverem na memoria, serao armazenadas em um dicionario.

import os

#$ Funcao para limpar o terminal
def clear():
    if os.name == 'nt':
        os.system('cls')
    else:
        os.system('clear')

def main():
    
    #$ Definicao de variaveis
    contatos = {}
    opcao = 0

    #$ Impressao das opcoes
    while opcao != '3':
        print('''
1 - Cadastrar telefone
2 - Visualizar agenda
3 - Sair do programa
        ''')

        #$ Entrada do usuario para escolha de opcao
        opcao = input('Insira a opcao que voce deseja: ')
        clear()

        #$ Cadastramento de novos telefones
        if opcao == '1':
            nome = input('Nome: ')
            contatos[nome] = input('Telefone: ')

        #$ Visualizando os telefones cadastrados
        if opcao == '2':
            for pessoa in contatos:
                print(f'Nome: {pessoa}\tTelefone: {contatos[pessoa]}')

if __name__ == '__main__':
    main()