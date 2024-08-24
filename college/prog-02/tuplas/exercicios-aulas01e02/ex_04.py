# Uma agencia de turismo possui armazenados os voos realizados por diversas companhiasa aereas. Cada voo e representado como uma tupla com as seguintes informacoes:
# Numero do voo
# Companhia que realizou o voo (string)
# Lista de escalas (cada elemento da lista e o nome de uma cidade, na ordem em que foram visitadas.)
# Exemplos: voos = [(1024,"TAM", ["ES", "RJ", "SP", "NY"]),(1025, "GOL", ["ES", "SP"])]
# Crie funcoes para:
# a) Dada a lista de voos, uma cidade origem A e uma cidade destino B, imprima o numero e a companhia de todos os voos que se iniciem em A e cujo destino final seja B.
# b) Dada a lista de voos, uma cidade origem A e uma cidade destino B, imprima quantos voos se iniciem em A e que facam alguma escala em B.
# c) Dada a lista de voos, uma cidade origem A e uma cidade destino B, verifique se ha algum voo direto de A para B, mesmo que A e B nao sejam is destinos iniciais e finais do voo.

def destinoFinal(listaVoos, origem, destino):
    for (numVoo, companhia, escala) in listaVoos:
        if escala[0] == origem and escala[len(escala) - 1] == destino:
            print(f'Numero do voo: {numVoo}\tCompanhia: {companhia}')

def escalas(listaVoos, origem, destino):
    for (numVoo, companhia, escala) in listaVoos:
        if escala[0] == origem and escala.count(destino) != 0:
            print(f'Numero do voo: {numVoo}\tCompanhia: {companhia}')

def vooDireto(listaVoos, origem, destino):
    for voo in listaVoos:
        for indice in range(len(voo[2])):
            if voo[2][indice] == origem and voo[2][indice + 1] == destino:
                print(f'Numero do voo: {voo[0]}\tCompanhia: {voo[1]}')