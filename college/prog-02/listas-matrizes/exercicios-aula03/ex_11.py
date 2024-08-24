# Faca um procedimento que leia um numero N e depois as notas de N alunos. Em seguida, ccalcule e imprima a media da turma, e o numero de alunos que ficaram com nota acima de 60.

def media():
	l = []
	alunosAprovados = 0
	numeroAlunos = int(input())
	for i in range(numeroAlunos):
		l.append(int(input()))
	media = sum(l) / numeroAlunos
	for i in l:
		if i >= 60:
			alunosAprovados += 1
	print (f'Media da turma = {media}\nAlunos aprovados = {alunosAprovados}')
