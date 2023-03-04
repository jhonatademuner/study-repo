# O procedimento a seguir recebe a lista de funcionarios(com 'Nome', 'Tempo de casa' e 'Salario') como paramentro e imprime  o nome dos funcionarios mais antigos com seus salarios diferenciados neste mes.

def maiorTempo(lista):
    maior = 0
    for tupla in lista:
        if tupla[1] > maior:
            maior = tupla[1]
    return maior


def bonus(lista):
    for tupla in lista:
        if tupla[1] == maiorTempo(lista):
            print(
                f'Nome do funcionario = {tupla[0]}\tSalario com bonus = R$ {tupla[2] * 1.1:.2f}')