# A mesma empresa deseja saber se seus produtos estao dando lucro. Para Isso pediu para voce cria uma sub-rotina que reebe uma lista de tuplas contendo o preco de custo e o preco de venda de cada mercadoria e imprima:
# A quantidade de produtos com menos de 20% de lucro
# A pocentagem de produtos com lucro superior a 25%

def lucro(lista):
    lucroInferior = 0
    lucroSuperior = 0
    for (custo, venda) in lista:
        porcetagemLucro = (venda - custo) / custo * 100
        if porcetagemLucro < 20:
            lucroInferior += 1
        elif porcetagemLucro > 25:
            lucroSuperior += 1
    print(f"Produtos com menos de 20% de lucro = {lucroInferior}")
    print(f"Porcentage de produtos com mais de 25% de lucro = {lucroSuperior / len(lista) * 100}%")