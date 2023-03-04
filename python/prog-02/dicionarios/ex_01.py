# Crie um dicionario com nome, idade e telefone de 10 pessoas (os dados serao digitados pelo usuario).
# Depois, remova todos os usu ́arios que forem menores de idade, e imprima nome/telefone dos que permanecerem.

#$ Funcao para checar a idade das pessoas
def maiorIdade(tabela):
    tabelaMaiores = {}
    for pessoa in tabela:
        if int(tabela[pessoa][0]) > 18:
            tabelaMaiores[pessoa] = (tabela[pessoa][0], tabela[pessoa][1])
    return tabelaMaiores

def main():

    #$ Definicao de variavel
    tabela = {}

    #$ Entrada do usuario
    while len(tabela) < 10:
        nome = input('Nome: ')
        idade = input('Idade: ')
        tel = input('Telefone: ')
        tabela[nome] = (idade, tel)

        #$ Checagem de idade
        tabelaChecada = maiorIdade(tabela)

    #$ Saida principal
    print(tabelaChecada)

if __name__ == '__main__':
    main()