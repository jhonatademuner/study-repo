
#$ Trabalho PROG-II
#$ Jhonata Polito Demuner
#$ João Pedro Spinassé Viana

def lerArquivo(nomeArquivo):
    import pickle

    with open (nomeArquivo, 'rb') as ler:
        return pickle.load(ler)

#$ Função para definir o bônus por presença do aluno
def bonusPresenca(nota):
    if nota >= 98:
        return 100
    else:
        return nota + 2

#$ Função para checar se o aluno1 deve vir antes do aluno2 na lista
def comparacao(aluno1, aluno2, dadosAlunos):

    #$ Obtendo dados dos alunos
    nome1, semestre1, notas1, faltas1 = dadosAlunos[aluno1]
    nome2, semestre2, notas2, faltas2 = dadosAlunos[aluno2]
    notaSemBonus1 = sum(notas1)
    notaSemBonus2 = sum(notas2)
    notaAluno1 = notaSemBonus1;
    notaAluno2 = notaSemBonus2;
    
    #$ Checando se os alunos devem receber bônus por presença
    if faltas1 == 0:
        notaAluno1 = bonusPresenca(notaSemBonus1)
    if faltas2 == 0:
        notaAluno2 = bonusPresenca(notaSemBonus2)

    if notaAluno1 != notaAluno2:
        return notaAluno1 > notaAluno2

    #$ Critério de desempate 1
    elif notaSemBonus1 != notaSemBonus2:
        return notaSemBonus1 > notaSemBonus2

    #$ Critério de desempate 2
    elif semestre1 != semestre2:
        if semestre1[0] != semestre2[0]:
            return semestre1[0] > semestre2[0]
        else:
            return semestre1[1] > semestre2[1]

    #$ Critério de desempate 3
    elif nome1 != nome2:
        return nome1 < nome2

    #$ Critério de desempate 4
    return aluno1 < aluno2

def mergeSort(matriculas, dadosAlunos):
    if len(matriculas) > 1:

        meio = len(matriculas) // 2
        listaEsq = matriculas[:meio]
        listaDir = matriculas[meio:]

        #$ Ordenando recursivamente as listas da esquerda e direita
        mergeSort(listaEsq, dadosAlunos)
        mergeSort(listaDir, dadosAlunos)

        i = 0
        j = 0
        k = 0

        #$ Checando se todos os elementos das listas não foram percorridos ainda
        while i < len(listaEsq) and j < len(listaDir):
            if comparacao(listaEsq[i], listaDir[j], dadosAlunos):

                #$ Inserindo o aluno na posição "k" da lista ordenada
                matriculas[k] = listaEsq[i]
                i += 1

            else:
                #$ Inserindo o aluno na posição "k" da lista ordenada
                matriculas[k] = listaDir[j]
                j += 1

            k += 1

        #$ Adicionando o restante dos elementos na lista ordenada
        while i < len(listaEsq):
            matriculas[k] = listaEsq[i]
            i += 1
            k += 1

        while j < len(listaDir):
            matriculas[k] = listaDir[j]
            j += 1
            k += 1

def buscaBinariaAlunos(matriculas, dadosAlunos, alvo):

    for i in range(alvo, 101): #$ "for" usado para obter o valor mais próximo acima do alvo se não existir o valor alvo na lista
        inicio = 0
        fim = len(matriculas) - 1

        #$ Checando se todos os itens da listas foram checados
        while inicio <= fim:
            meio = (inicio + fim) // 2

            #$ Obtendo dados do aluno na posição "meio"
            faltasMeio = dadosAlunos[matriculas[meio]][3]
            parciaisMeio = dadosAlunos[matriculas[meio]][2]
            notaMeio = sum(parciaisMeio)

            #$ Obtendo o valor dos dados do próximo aluno para verificar se é a última instância do valor alvo
            faltasProx = dadosAlunos[matriculas[meio + 1]][3]
            parciaisProx = dadosAlunos[matriculas[meio + 1]][2]
            notaProx = sum(parciaisProx)

            #$ Verificando se os alunos têm bônus por presenca e somando à nota do aluno
            if faltasMeio == 0:
                notaMeio = bonusPresenca(notaMeio)
            if faltasProx == 0:
                notaProx = bonusPresenca(notaProx)

            if notaMeio == i and notaProx != i:
                return meio

            elif notaMeio >= i:
                inicio = meio + 1
            
            else:
                fim = meio - 1

    return -1

def salvarArquivo(nomeArquivo, matriculas, dadosAlunos):
    with open(nomeArquivo, 'w', encoding='utf-8') as escrever:
        
        for aluno in matriculas:

            #$ Obtendo os dados de cada aluno usando o dicionário de dados dos alunos
            nome, _, notas, faltas = dadosAlunos[aluno]
            notaTotal = notas[0] + notas[1] + notas[2]

            #$ Escrevendo o nome e a nota sem o bônus do aluno
            escrever.write(str(nome) + ' - ' + str(notaTotal))

            #$ Checando se o aluno possui bônus por presenca, se sim, escrevendo o bônus do aluno
            if faltas == 0 and bonusPresenca(notaTotal) != notaTotal:
                escrever.write(' +' + str(bonusPresenca(notaTotal) - notaTotal) + '\n')
            else:
                escrever.write('\n')

def main():
    
    dadosAlunos = lerArquivo('entrada.bin')

    #$ Definindo a lista com as matrículas dos alunos (não ordenada)
    matriculas = list(dadosAlunos.keys())

    mergeSort(matriculas, dadosAlunos)

    #$ Exibindo a quantidade de alunos aprovados
    print(buscaBinariaAlunos(matriculas, dadosAlunos, 60) + 1)

    salvarArquivo('saida.txt', matriculas, dadosAlunos)
    
if __name__ == '__main__':
    main()