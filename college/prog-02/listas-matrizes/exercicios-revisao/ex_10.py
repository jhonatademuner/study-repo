# Conhecendo o numero de amigos, a quantidade de frutas colhidas, e sabendo que cada unidade de fruta e suficiente para produzir 50 ml de suco, escreva uma funcao que receba como parametros o numero N de amigos e a quantidade F de frutas colhidas, e imprima com precisao de duas casas decimais qual o volume, em litros, que cada amigo podera tomar.

def acerola(n, f):
    print(f'{f * 0.05 / n:.2f}')