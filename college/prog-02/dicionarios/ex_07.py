# Uma certa loja possui um programa que mantem armazenados os produtos vendidos por ela,  os clientes cadastrados e o historico
# de pedidos ja realizados, ou seja, dos produtos que ja foram vendidos. Para isso, o sistema armazena 3 dicionarios na memoria:
# O dicionario clientes, contendo cpf (String), nome (String) e endereco eletronico (String) de cada cliente. A chave do
# dicionario  e  o  cpf.
# O dicionario produtos, contendo o codigo do produto (String), o valor unitario (double), o nome do produto (String) e a
# quantidade em estoque (inteiro). A chave do dicionario e o codigo do produto.
# O dicionario pedidos, contendo o codigo do pedido (String), o codigo do cliente que realizou o pedido, o status do pedido
# (verdadeiro caso ele ja tenha sido entregue, ou falso caso ainda esteja em aberto) e a lista de produtos que o cliente 
# comprou. Cada elemento da lista de produtos e uma tupla, contendo o codigo de um produto e a quantidade de itens daquele 
# produto que o cliente solicitou. A chave do dicionario e o codigo do pedido.
# Crie as seguintes funcoes:
# (a) Crie uma funcao que receba como parametro o codigo de um produto e os tres dicionarios, e veriﬁque se ha quantidade em
# estoque suﬁciente para todos os pedidos em aberto que envolvem aquele produto.
# (b) Crie uma funcao que receba como parametro o codigo de um pedido e os tres dicionarios, e imprima o pedido.
# (c) Crie uma funcao que receba como parametro o codigo de um pedido e os tres dicionarios, e retorne o valor total daquele pedido.
# (d) Crie uma funcao que receba como parametro os tres dicionarios, e imprima o nome de cada cliente ao lado do valor total
# ja pago por ele na loja. Para calcular o valor de cada pedido feito por um cliente, utilize a funcao da Questao (c).

#$ Dicionarios dados no exercicio
clientes = {"123.456.789 -00" : ("Maria da Silva", "maria@gmail.com"),
            "234.567.890 -00" : ("Joao da Cruz", "joao@gmail.com"),
            "345.678.900 -00" : ("Jose de Souza", "zezinho@gmail.com")}

produtos = {"A0001": (1.20, "Pera", 1),
            "A0002": (3.40, "Uva", 1),
            "A0003": (1.00 , "Maca", 1),
            "A0004": (10.00, "Salada de frutas", 1),
            "A0005": (12.00, "Acai medio", 1),
            "A0006": (3.00, "Granola", 1),
            "A0007": (5.00, "Suco 300 ml", 1)}

pedidos = {"345": ("123.456.789 -00", True, [("A0001",3), ("A0002",1), ("A0003",5), ("A0004",1)]),
           "123": ("234.567.890 -00", False, [("A0005",2), ("A0006",1)])}


#$ Funcao para checar se o estoque tem os produtos necessarios para os pedidos
def checagemEstoque(codProduto, produtos, pedidos):

    #$ Definicao de variavel
    qtdTotal = 0

    #$ Contagem de produtos nos pedidos
    for codPedido in pedidos:
        if not pedidos[codPedido][1]:
            for produtoPedido, qtdProduto in pedidos[codPedido][2]:
                if produtoPedido == codProduto:
                    qtdTotal += qtdProduto

    #$ Saida com a verificao de produtos suficientes para suprir os pedidos
    return produtos[codProduto][2] >= qtdTotal

#$ Funcao para impressao de pedido
def imprimirPedido(codPedido, produtos, pedidos):

    #$ Impressao do numero do pedido
    print(f'Pedido #{codPedido}:')

    #$ Impressao dos produtos do pedido
    for codProduto, qtdProduto in pedidos[codPedido][2]:
        print(f'- {produtos[codProduto][1]}')
        print(f'  Qtd: {qtdProduto}')
        print(f'  Valor unitário: R$ {produtos[codProduto][0]:.2f}')
        print(f'  Valor total: R$ {produtos[codProduto][0] * qtdProduto:.2f}')

    #$ Checagem e impressao do status do pedido
    if pedidos[codPedido][1]:
        print(f'Status: Entregue')
    else:
        print(f'Status: Em aberto')

#$ Funcao para calcular o valor total de um pedido em especifico
def valorTotalPedido(codPedido, produtos, pedidos):

    #$ Definicao de variaveis
    valorTotal = 0

    #$ Percorrendo o pedido e somando os valores
    for codProduto, qtdProduto in pedidos[codPedido][2]:
        valorTotal += produtos[codProduto][0] * qtdProduto

    #$ Saida do valor total do pedido
    return valorTotal

#$ Funcao para calcular quanto cada cliente gastou na loja
def valorCliente(clientes, produtos, pedidos):

    #$ Percorrendo o dicionario de pedidos
    for codPedido in pedidos:

        #$ Definicao do nome do cliente
        nomeCliente = clientes[pedidos[codPedido][0]][0]

        #$ Saida do valor total usando a funcao para obtencao do valor total de um pedido
        print(f'Nome cliente: {nomeCliente} \t Valor gasto: {valorTotalPedido(codPedido, produtos, pedidos)}')