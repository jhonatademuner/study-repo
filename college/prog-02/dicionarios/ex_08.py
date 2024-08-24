# Uma agencia de turismo possui armazenados os voos realizados por diversas 
# companhias aereas. Esses voos sao representados como um dicionario que contem 
# as informacoes pertinentes a cada um desses voos. A chave do dicionario e um 
# numero inteiro com o numero do voo, e o conteudo e uma tupla contendo:
# Companhia  que  realizou  o  voo  (String).
# Data  do  voo  (tupla  contendo  inteiros  positivos  para  o  dia,  mes  e  ano).
# Lista de escalas. Cada elemento da lista e uma tupla contendo uma cidade 
# (String) e um horario (tupla contendo a hora e o minuto, ambos inteiros). O 
# horario na cidade origem corresponde ao horario de saıda do voo. A ultima 
# tupla da lista corresponde sempre ao destino ﬁnal. O horario nas tuplas 
# seguintes corresponde a chegada em cada uma das demais escalas. Considere 
# que o tempo de voo do trecho entre duas escalas e a diferenca (em minutos) 
# dos horarios relativos as duas escalas.
# Implemente  as  funcoes  a  seguir:
# (a) Dados o numero de um voo x e o dicionario com os voos, calcule e retorne o 
# tempo total (em minutos) daquele voo. (Cuidado: um voo pode comecar em 
# um dia e terminar no outro).
# (b) Dados os voos, exiba o numero de cada voo seguido de suas cidades de origem 
# e de destino. Em cada linha do resultado devera aparecer o numero de um 
# voo e o nome das duas cidades.
# (c)   Dados  uma  cidade  origem  a,  uma  cidade  destino  b  e  o  dicionario  com  os  voos, 
# imprima  o  numero  de  todos  os  voos  que  se  iniciem  em  a  e  passem  por  b.
# (d) Dados uma cidade origem a, uma cidade destino b e o dicionario com os voos, 
# imprima a companhia e o numero do voo de menor tempo total que saia de 
# a e termine em b. Utilize a funcao do item 8a para calcular o tempo total de 
# um voo.

#$ Dicionario dado no exercicio
voos = {1024 : ("TAM", (11, 9, 2001) , [("ES", (11, 30)),
                                       ("RJ", (12, 30)),
                                       ("SP", (13, 50)),
                                       ("NY", (22, 00))]),
        1025 : ("GOL", (11, 9, 2001) , [("ES", (14, 00)),
                                       ("SP", (16, 00))])}

#$ Funcao para converter tempo em horas para minutos
def conversorMin(tempo):
    horas, minutos = tempo
    return horas * 60 + minutos

#$ Funcao para checar se um voo comeca e termina nas cidades dadas como argumentos
def vooCorreto(voo, origem, destino):
    if origem == voo[2][0][0]:
        escalas = voo[2]
        for cidade, _ in escalas:
            if destino == cidade:
                return True

#$ Funcao para calcular o tempo total de viagem em minutos
def tempoTotal(numVoo, voos):

    #$ Definindo a variavel das escalas do voo para melhor legibilidade
    escalas = voos[numVoo][2]

    #$ Checagem se o voo comeca um dia e termina no outro
    if conversorMin(escalas[-1][1]) < conversorMin(escalas[0][1]):

        #$ Calculo do tempo total levando em consideracao que o voo comeca um dia e termina no outro
        return (conversorMin((24,00)) - conversorMin(escalas[0][1])) + conversorMin(escalas[-1][1])
    
    #$ Calculo do tempo total
    else:
        return conversorMin(escalas[-1][1]) - conversorMin(escalas[0][1])


#$ Funcao para exibir todos os voos e suas cidades de origem e destino
def exibirVoos(voos):
    for numVoo in voos:
        print(f'Voo: {numVoo}\tOrigem: {voos[numVoo][2][0][0]}\tDestino: {voos[numVoo][2][-1][0]}')

#$ Funcao para exibir todos os voos que tem como origem e destino as cidades dadas como argumentos
def voosPossiveis(voos, origem, destino):

    #$ Percorrendo os voos do dicionario
    for numVoo in voos:

        #$ Checando se o voo comeca e termina nas cidades dadas como argumentos
        if vooCorreto(voos[numVoo], origem, destino):
            print(f'Voo: {numVoo}')

#$ Funcao para definir o voo mais rapido que parte da cidade origem e chega na cidade destino dada como argumento no menor tempo entre todos os voos
def vooMaisRapido(voos, origem, destino):

    #$ Inicializacao de variaveis
    melhorVoo = 0

    #$ Definindo o maior inteiro possivel para evitar problemas de comparacao
    tempoMelhorVoo = float('inf')

    #$ Percorrendo os voos do dicionario
    for numVoo in voos:

        #$ Checando se o voo e valido com base nas cidades de origem e destino dadas como argumento
        if vooCorreto(voos[numVoo], origem, destino):

            #$ Checando se o tempo total do voo e menor que o tempo do voo com o menor tempo atual
            if tempoTotal(numVoo, voos) < tempoMelhorVoo:
                tempoMelhorVoo = tempoTotal(numVoo, voos)
                melhorVoo = numVoo

    #$ Exibindo o voo mais rapido
    print(f'Companhia: {voos[melhorVoo][0]}\tVoo: {melhorVoo}')