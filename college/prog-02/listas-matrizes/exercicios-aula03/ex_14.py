# Dado um numero N, faca um procedimento que leia  o nome e  o salario de N funcionarios de uma empresa e imprima  o nome de todos os funcionarios que ganham mais que a media dos demais.

def salario(n):
    nome = []
    salario = []
    ganhamMais = []
    for i in range(n):
        nome.append(input())
        salario.append(float(input()))
    for i in range(len(nome)):
        if salario[i] > ((sum(salario) - salario[i]) / (len(salario)-1)):
            ganhamMais.append(nome[i])
    print(ganhamMais)