# Um certo concurso publico oferece vagas em diferentes areas.
# Cada candidato possui um numero de inscricao, nome, data de nascimento, nota na primeira fase
# e nota na segunda fase. Cada area possui um codigo, um nome e uma lista com o numero de inscricao
# de todos os candidatos inscritos nesta area.
# Crie funcoes para:
# (a) Dado um dicionario com os candidatos, o dicionario com as areas, e o codigo de uma area
# especifica, liste todos os candidatos classificados para a segunda etapa naquela area (apenas os
# candidatos com nota menor que 60 sao eliminados na primeira etapa).
# (b) Dados o dicionario com os candidatos e o dicionario com as areas, liste o candidato aprovado
# em cada area. a nota final e a soma das duas etapas e ha apenas uma vaga para cada area. Em caso
# de dois candidatos com a mesma nota ficarem em primeiro lugar, ́e aprovado o candidato mais velho.

#$ Funcao para definir o candidato mais velho
def dataAnterior(data1, data2):

    #$ Definicao de variaveis
    d1, m1, a1 = data1
    d2, m2, a2 = data2

    #$ Condicionais para definir o ano, mes ou dia que vem primeiro no calendario, respectivamente
    if a1 < a2: return True
    elif a2 < a1: return False
    elif m1 < m2: return True
    elif m2 < m1: return False
    elif d1 < d2: return True
    elif d2 < d1: return False

#$ Funcao para analise de notas de uma area e fase especifica
def analiseNotas(candidatos, codigoareas, areaDesejada, fase):

    #$ Definicao de variaveis
    candidatosaprovados = []
    fase += 1
    areaSelecionada = codigoareas.get(areaDesejada)

    #$ Checando se a nota e maior que 60
    for nInscricao in areaSelecionada[1]:
        if nInscricao in candidatos.keys():
            inscrito = candidatos.get(nInscricao)
            if inscrito[fase] >= 60:
                candidatosaprovados.append(inscrito)

    #$ Saida com os candidatos aprovado na area e fase especificada
    return candidatosaprovados

#$ Funcao principal usada para fazer a analise da nota final entre as duas fases
def analiseNotaFinal(areas, candidatos):

    #$ Percorrendo a lista de aprovados na primeira fase
    for area in areas:
        notaFinalaprovado = 0
        aprovadosFase1 = analiseNotas(candidatos, areas,area, 1)
        for inscrito in aprovadosFase1: 

            #$ Definicao da nota final do candidato
            notaFinal = inscrito[2] + inscrito[3]

            #$ Checagem de nota maior
            if notaFinal > notaFinalaprovado:
                notaFinalaprovado = notaFinal
                candidatoaprovado = inscrito

            #$ Checagem de candidato mais velho
            elif notaFinal == notaFinalaprovado:
                if dataAnterior(inscrito[1], candidatoaprovado[1]):
                    notaFinalaprovado = notaFinal
                    candidatoaprovado = inscrito

        #$ Impressao do resultado da funcao
        print(f'Area = {area} \t Candidato aprovado = {candidatoaprovado[0]} \t Media Final = {notaFinalaprovado / 2}')