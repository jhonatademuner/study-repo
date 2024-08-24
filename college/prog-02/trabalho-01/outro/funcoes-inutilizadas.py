def bonusPresenca(faltas, nota):                                    #$ OK / Otimizado
    if faltas == 0:
        if nota >= 98 and nota <= 100:
            return nota + (100 - nota)
        else:
            return nota + 2
    return nota

def notaMaior(notaAluno1, notaAluno2):                              #$ OK / Otimizado
    return notaAluno1 > notaAluno2

def dataAnterior(data1, data2):                                     #$ OK / Otimizado
    if data1[0] != data2[0]:
        return data1[0] > data2[0]
    else:
        return data1[1] > data2[1]

def ordemAlfabetica(nome1, nome2):                                  #^ Permitido?
    # from unidecode import unidecode
    # return unidecode(nome1.lower()) < unidecode(nome2.lower())
    l = [nome1, nome2]
    k = sorted(l)
    return l == k

def comparacaoIgual(aluno1, aluno2, dadosAlunos):                   #$ OK / Otimizado

    nome1, semestre1, notas1, faltas1 = dadosAlunos[aluno1]
    nome2, semestre2, notas2, faltas2 = dadosAlunos[aluno2]

    notaSemBonus1 = sum(notas1)
    notaAluno1 = notaSemBonus1

    notaSemBonus2 = sum(notas2)
    notaAluno2 = notaSemBonus2

    notaAluno1 = bonusPresenca(faltas1, notaAluno1)

    notaAluno2 = bonusPresenca(faltas2, notaAluno2)

    if notaAluno1 != notaAluno2:
        return notaMaior(notaAluno1,notaAluno2)

    elif notaSemBonus1 != notaSemBonus2:
        return notaMaior(notaSemBonus1, notaSemBonus2)

    elif semestre1 != semestre2:
        return dataAnterior(semestre1, semestre2)

    elif nome1 != nome2:
        return ordemAlfabetica(nome1, nome2)

    else:
        return True

def comparacaoDiferente(aluno1, aluno2, dadosAlunos):               #$ OK / Otimizado

    nome1, semestre1, notas1, faltas1 = dadosAlunos[aluno1]
    nome2, semestre2, notas2, faltas2 = dadosAlunos[aluno2]

    notaSemBonus1 = sum(notas1)
    notaAluno1 = notaSemBonus1

    notaSemBonus2 = sum(notas2)
    notaAluno2 = notaSemBonus2

    notaAluno1 = bonusPresenca(faltas1, notaAluno1)

    notaAluno2 = bonusPresenca(faltas2, notaAluno2)

    if notaAluno1 != notaAluno2:
        return notaMaior(notaAluno1,notaAluno2)

    elif notaSemBonus1 != notaSemBonus2:
        return notaMaior(notaSemBonus1, notaSemBonus2)

    elif semestre1 != semestre2:
        return dataAnterior(semestre1, semestre2)

    elif nome1 != nome2:
        return ordemAlfabetica(nome1, nome2)

    else:
        return False

def comparacao(aluno1, aluno2, dadosAlunos, tipo):                  #$ OK / Otimizado

    nome1, semestre1, notas1, faltas1 = dadosAlunos[aluno1]
    nome2, semestre2, notas2, faltas2 = dadosAlunos[aluno2]

    notaSemBonus1 = sum(notas1)
    notaAluno1 = notaSemBonus1

    notaSemBonus2 = sum(notas2)
    notaAluno2 = notaSemBonus2

    notaAluno1 = bonusPresenca(faltas1, notaAluno1)

    notaAluno2 = bonusPresenca(faltas2, notaAluno2)

    if notaAluno1 != notaAluno2:
        return notaAluno1 > notaAluno2

    elif notaSemBonus1 != notaSemBonus2:
        return notaSemBonus1 > notaSemBonus2

    elif semestre1 != semestre2:
        return dataAnterior(semestre1, semestre2)

    elif nome1 != nome2:
        return ordemAlfabetica([nome1, nome2])

    else:
        return tipo

def bubbleSortAlunos(matriculas, dadosAlunos):                      #$ OK / Otimizado
    tamanhoLista = len(matriculas)
    for i in range(tamanhoLista):
        for j in range(0, tamanhoLista - i - 1):
            if comparacaoIgual(matriculas[j + 1], matriculas[j], dadosAlunos):
                (matriculas[j + 1], matriculas[j]) = (matriculas[j], matriculas[j + 1])

def insertionSortAlunos(matriculas, dadosAlunos):                   #$ OK / Otimizado
    for i in range(len(matriculas)):
        for j in range(i):
            if comparacao(matriculas[i], matriculas[j], dadosAlunos):
                matriculas[j],matriculas[j+1:i+1] = matriculas[i],matriculas[j:i]
                break

def quickSortAlunos(matriculas, inferior, superior, dadosAlunos):   #$ OK / Otimizado

    def particao(matriculas, inferior, superior, dadosAlunos):
        pivo = matriculas[inferior] # primeiro elemento da matriculas
        i = inferior + 1 # indice segundo elemento
        j = superior # indice ultimo elemento
        while i <= j: 
            while i <= j and comparacao(matriculas[i], pivo,  dadosAlunos):
                i += 1
            while j >= i and comparacao(pivo, matriculas[j], dadosAlunos):
                j -= 1
            if i < j:
                matriculas[i], matriculas[j] = matriculas[j], matriculas[i] 
        matriculas[inferior], matriculas[j] = matriculas[j], matriculas[inferior]
        return j
    
    if inferior < superior:
        posicao = particao(matriculas, inferior, superior, dadosAlunos)
        quickSortAlunos(matriculas, inferior, posicao - 1, dadosAlunos)
        quickSortAlunos(matriculas, posicao + 1, superior, dadosAlunos)

def mergeSortAlunos(matriculas, dadosAlunos):                       #$ OK / Otimizado

    if len(matriculas) > 1:
        meio = len(matriculas) // 2
        listaEsq = matriculas[:meio]
        listaDir = matriculas[meio:]

        mergeSortAlunos(listaEsq, dadosAlunos)
        mergeSortAlunos(listaDir, dadosAlunos)

        i = 0
        j = 0
        k = 0

        while i < len(listaEsq) and j < len(listaDir):
            if comparacao(listaEsq[i], listaDir[j], dadosAlunos):
                matriculas[k] = listaEsq[i]
                i += 1
            else:
                matriculas[k] = listaDir[j]
                j += 1
            k += 1

        while i < len(listaEsq):
            matriculas[k] = listaEsq[i]
            i += 1
            k += 1

        while j < len(listaDir):
            matriculas[k] = listaDir[j]
            j += 1
            k += 1

def mergeInsertionSortAlunos(matriculas, dadosAlunos):
    divisor = 5
    numListas = len(matriculas) // divisor
    j = 0
    for i in range(0, numListas):
        quickSortAlunos(matriculas[j: j + divisor],0 ,len(matriculas[j: j + divisor]) -1, dadosAlunos)
        j += divisor
    
    if len(matriculas) > 1:
        meio = len(matriculas) // 2
        listaEsq = matriculas[:meio]
        listaDir = matriculas[meio:]

        mergeSortAlunos(listaEsq, dadosAlunos)
        mergeSortAlunos(listaDir, dadosAlunos)

        i = 0
        j = 0
        k = 0

        while i < len(listaEsq) and j < len(listaDir):
            if comparacao(listaEsq[i], listaDir[j], dadosAlunos, False):
                matriculas[k] = listaEsq[i]
                i += 1
            else:
                matriculas[k] = listaDir[j]
                j += 1
            k += 1

        while i < len(listaEsq):
            matriculas[k] = listaEsq[i]
            i += 1
            k += 1

        while j < len(listaDir):
            matriculas[k] = listaDir[j]
            j += 1
            k += 1

def compararArquivos(arquivo1, arquivo2):                           
    with open (arquivo1, 'r', encoding='utf-8') as ler:
        arq1 = ler.read()
    with open (arquivo2, 'r', encoding='utf-8') as ler:
        arq2 = ler.read()
    for i in range(len(arq1)):
        if arq1[i] != arq2[i]:
            print('erro: ', i)
            print(arq1[i:i + 30])
            break
    stringSaida = ('||' + '  ' + 'Saidas compativeis = ' + str(arq1 == arq2) + '  ' + '||')
    print('\t' + '=' * len(stringSaida))
    print('\t' + stringSaida)
    print('\t' + '=' * len(stringSaida))