# Enzo e um agente de transito que esta cursando Sistemas de Informacao e decidiu deixar o seu dia a dia mais informatizado.
# Ao inves de registrar as infracoes de transito no papel, ele quer criar um aplicativo para utilizar em seu tablet. Ele
# decidiu salvar as informacoes com as seguintes estruturas:
# Dicionario com dados dos motoristas: A chave do dicionario e o numero da CNH, e o conteudo e uma tupla com o nome do 
# motorista e a data de vencimento da sua CNH.
# Dicionario com dados dos veıculos: A chave e a placa do veıculo, e o conteudo e uma tupla contendo o numero da CNH do
# proprietario, o modelo do veıculo e a cor do veıculo.
# Lista com dados das infracoes: Cada elemento e uma tupla contendo o codigo da infracao, a data (tupla com dia, mes e ano),
# placa do veıculo multado e a natureza da infracao.
# Dicionario com a natureza das infracoes: A chave e o tipo da infracao, e o conteudo e a pontuacao que o condutor recebe por ela.
# Enzo ja comecou a desenvolver o sistema, mas esta precisando de ajuda com algumas  funcionalidades.
# (a) Enzo quer ﬁltrar as infracoes ocorridas ha menos de 1 ano, para que as demais deixem de contar pontos nas CNHs. Para
# isso, crie uma funcao que receba como parametros a lista de infracoes e uma tupla contendo a data atual, e retorne uma nova
# lista contendo apenas as infracoes que ocorreram ha menos de 1 ano. Sugestao: Crie uma funcao auxiliar que receba duas
# datas, e veriﬁque se a primeira ocorreu antes da segunda.
# (b) Enzo quer calcular e retornar os pontos da CNH de um motorista. Para isso, crie uma funcao que receba como parametros a
# CNH do motorista, a lista de infracoes e os dicionarios que achar necessarios, e retorne a pontuacao atual do motorista.
# Observacao: Considere que as infracoes ocorridas ha mais de 1 ano ja foram removidas.
# (c) Enzo quer consultar informacoes sobre um veıculo e seu motorista em uma blitz. Para isso, crie uma funcao que receba
# como parametros a CNH do motorista, a placa do veıculo, a data atual, a lista de infracoes e os dicionarios

#$ Dicionarios dados no exercicio
motoristas = {"01234567" : ("Seu Madruga", (15, 10, 2019)),
              "12345678" : ("Dona Florinda", (14, 10, 2019))}

veiculos = { "FLA1981" : ("12345678", "Fusca", "Preto"),
             "ALE2014" : ("12345678", "Brasilia", "Prata"),
             "BRU0071" : ("01234567", "Chevette", "Branco")}

infracoes = [("I0001", (15, 10, 2018), "BRU0071", "Gravissima"),
             ("I0002", (16, 10, 2018), "BRU0071", "Gravissima"),
             ("I0003", (17, 10, 2018), "ALE2014", "Leve") ]

naturezas = { "Leve" : 3, 
              "Media" : 4,
              "Grave" : 5,
              "Gravissima" : 7}

#$ Funcao para definir a data anterior
def dataAnterior(data1, data2):

    #$ Definicao de variaveis
    d1, m1, a1 = data1
    d2, m2, a2 = data2

    #$ Condicionais para definir o ano, mes ou dia que vem primeiro no calendario, respectivamente
    if a1 < a2: return True
    elif a2 < a1: return False
    elif m1 < m2: return True
    elif m2 < m1: return False
    elif d1 < d2: return True
    elif d2 < d1: return False

#$ Funcao para checar as infracoes validas na data desejada
def checagemInfracoes(infracoes, dataAtual):

    #$ Definicao de variaveis
    checagemInfracoes = []

    #$ Checangem das infracoes
    for multa in infracoes:
        if dataAnterior(dataAtual, multa[1]):
            checagemInfracoes.append(multa)

    #$ Saida das infracoes validas
    return checagemInfracoes

#$ Funcao para calcular os pontos de infracao para um motorista especifico
def emissaoMulta(cnh, infracoes, veiculos, naturezas):

    #$ Definicao de variaveis
    pontuacao = 0

    #$ Validacao e soma dos pontos
    for carro in veiculos:
        if veiculos[carro][0] == cnh:
            for _, _, placa, natureza in infracoes:
                if placa == carro:
                    pontuacao += naturezas[natureza]

    #$ Saida com a pontuacao total de infracoes
    return pontuacao

#$ Funcao para checagem de documentacao em dia
def blitz(cnhMotorista, placaVeiculo, dataAtual, infracoes, veiculos, motoristas, naturezas):

    #$ Definicao de variaveis
    documentacaoEmDia = True
    dv, mv, av = dataAtual
    dataVencimentoCNH = (dv, mv, av - 1)

    #$ Checagem placa cadastrada
    if placaVeiculo not in veiculos:
        print("ATENCAO. Placa nao cadastrada.")
        documentacaoEmDia = False

    #$ Checagem de CNH vencida
    if dataAnterior(motoristas[cnhMotorista][1], dataVencimentoCNH):
        print("ATENCAO. Motorista com CNH vencida.")
        documentacaoEmDia = False

    #$ Checagem CNH cassada
    if emissaoMulta(cnhMotorista, infracoes, veiculos, naturezas) >= 20:
        print("ATENCAO. Motorista com cnh cassada.")
        documentacaoEmDia = False

    #$ Impressao dos dados do carro, motorista e proprietario
    if documentacaoEmDia:
        cnhPropreitario = veiculos[placaVeiculo][0]
        print(f'Modelo do veiculo = {veiculos[placaVeiculo][1]} || Cor do veiculo = {veiculos[placaVeiculo][2]}')
        print(f'Nome do proprietario = {motoristas[cnhPropreitario][0]} || Pontuacao do proprietario = {emissaoMulta(cnhPropreitario, infracoes, veiculos, naturezas)}')
        print(f'Nome do motorista = {motoristas[cnhMotorista][0]} || Pontuacao do motorista = {emissaoMulta(cnhMotorista, infracoes, veiculos, naturezas)}')