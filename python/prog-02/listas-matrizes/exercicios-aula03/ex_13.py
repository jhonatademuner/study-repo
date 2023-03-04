# Dadas duas listas L1 e L2 com a mesma quantidade de numeros, imprima quantos elementos aparecem exatamente na mesma posicao em amabas as listas.

def iguais(l1, l2):
	ocorrencias = 0
	for i in l1:
		for j in l2:
			if i == j and l1.index(i) == l2.index(j):
				ocorrencias += 1
	print(ocorrencias)
