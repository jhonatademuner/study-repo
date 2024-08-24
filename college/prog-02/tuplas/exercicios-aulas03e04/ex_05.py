# Crie uma fun ̧c ̃ao para visualizar as apostas cadastradas no sistema. A fun ̧c ̃ao deve
# imprimir os dados das apostas no seguinte formato:
# APOSTA 1
# Numeros: 12 23 35 39 41 46 52 55
# Jogadores:
# Enzo - CPF: 123.456.789-00
# Valentina - CPF: 234.567.890-00

import function

def imprimirApostas(bancoApostas):
    for aposta in bancoApostas:

        #$ Contador do numero de apostas
        print("APOSTA:", bancoApostas.index(aposta) + 1)

        #$ Borda superior
        print("=" * 80)
        print("||", "NOME", " " * 26, "|", "CPF", " " * 10, "|", "NUMEROS APOSTADOS"," " * 5,"||")
        print("||", "-" * 31,"|", "-" * 14, "|",  "-" * 23, "||")

        #$ Saida dos nomes do jogadores
        for jogador in aposta[0]:
            print("||", jogador[0], " " * (30 - len(jogador[0])), "|", end="")

            #$ Saida do CPF dos jogadores
            print(" ", jogador[1][0:3],".", jogador[1][3:6],".", jogador[1][6:9],"-", jogador[1][9:11], " |",sep="",end=" ")

            #$ Saida do numero apostador
            if aposta[0].index(jogador) == 0:
                function.imprimirLista(aposta[1])
                if len(aposta[1]) == 8:
                    print("||")
                elif len(aposta[1]) == 7:
                    print("   ||")
                elif len(aposta[1]) == 6:
                    print("      ||")
            else:
                print(" " * 23, "||")

        #$ Borda inferior
        print("=" * 80, "\n")
