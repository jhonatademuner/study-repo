# Defina um menu para o programa, a ser exibido no console, com as seguintes opcoes:
# - Cadastrar novo jogador
# - Visualizar jogadores cadastrados
# - Inserir nova aposta
# - Visualizar apostas cadastradas
# - Inserir resultados e listar vencedores
# - Sair do programa
# Utilize uma funcao auxiliar para limpar a tela do programa cada vez que uma opcao for escolhida.

import function

#$ Biblioteca usada para obter a tecla pressionada pelo usuario
import msvcrt

#$ Funcao principal do menu
def menu():

    #$ Definicao de variaveis
    key = -2
    indice = 0
    cursor = ['<-', '', '', '', '', '']
    
    #$ Saida das opcoes do menu
    function.opcoes(cursor)

    while key != b'\r':

        #$ Entrada do usuario (tecla pressionada)
        key = msvcrt.getch()

        #$ Validacao de primeira entrada("Enter" como primeira tecla)
        if key != b'\r':
            indice, cursor = function.cursorOpcao(key, indice)
            function.limpaTela()
            function.opcoes(cursor)

    #$ Saida principal da funcao
    return cursor.index('<-')
