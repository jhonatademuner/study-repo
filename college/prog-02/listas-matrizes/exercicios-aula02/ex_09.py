# Defina um procedimento que receba duas listas com a mesma quantidade de numeros inteiros. A primeira lista contem as abscissas de um conjunto de pontos, e a segunda contem as ordenadas desses mesmos pontos. Calcule o numero A de abscissa que sao pares e o numero B de ordenadas que sao impares. Se A >= B, imprima a soma de todas as abscissas. Caso contrario, imprima o produto de todas as ordenadas.

def ordenadasAbscissas(abscissas, ordenadas):
    abscissasCount = 0
    ordenadasCount = 0
    resultado = 0
    for i in range (len(abscissas)):
        if abscissas[i] % 2 == 0:
            abscissasCount += 1
        if ordenadas[i] % 2 != 0:
            ordenadasCount += 1
    if abscissasCount >= ordenadasCount:
        for i in range(len(abscissas)):
            resultado += abscissas[i]
    else:
        resultado = 1
        for i in range(len(ordenadas)):
            resultado *= ordenadas[i]
    print(resultado)