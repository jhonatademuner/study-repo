# Faca um procedimento que leia uma matriz contendo as notas dos alunos. O procedimento comeca perguntando o numero M de alunos e o numero N de notas, e cria uma matriz M x N que armazena as N notas de cada um dos M alunos. A nota final de cada aluno e a media simples das suas N notas. O procedimento deve imprimir a nota de cada aluno, e no final a media geral da turma.

def lerNotas(numAlunos, numNotas):
    matriz = []
    for i in range(numAlunos):
        notasAluno = []
        for j in range(numNotas):
            notasAluno.append(float(input(f'Insira a nota {j+1} do aluno {i+1}: ')))
        matriz.append(notasAluno)
    return matriz

def media(matriz):
    soma = []
    for i in matriz:
        soma.append(sum(i) / len(matriz[0]))
    return sum(soma) / len(matriz)

def notas(numAlunos, numNotas):
    matriz = lerNotas(numAlunos, numNotas)
    aluno = 0
    for i in matriz:
        aluno += 1
        print(f'Aluno {aluno}: {sum(i) / numNotas:.2f}')
    print(f'Media da turma: {media(matriz):.2f}')