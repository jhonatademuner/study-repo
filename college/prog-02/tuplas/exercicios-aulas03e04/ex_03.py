# Crie uma funcao para a segunda opcao do menu (visualizar jogadores cadastrados).
# A funcao deve imprimir os dados dos jogadores no seguinte formato:
# Enzo - CPF: 123.456.789-00
# Valentina - CPF: 234.567.890-00

def visualizarJogadores(bancoJogadores):

    #$ Borda superior
    print("=" * 54)
    print("||", "NOME", " " * 26, "|", "CPF", " " * 10, "||")
    print("||", "-" * 31,"|", "-" * 14, "||")

    #$ Saida dos nomes e cpf dos jogadores
    for (nome, cpf) in bancoJogadores:
        print("||", nome, " " * (30 - len(nome)), "|", end="")
        print(" ", cpf[0:3],".", cpf[3:6],".", cpf[6:9],"-", cpf[9:11], " ||",sep="")

    #$ Borda inferior
    print("=" * 54)
