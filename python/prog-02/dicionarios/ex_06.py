# Enzo nao estava fazendo sucesso como estudante de Sistemas de Informacao e se matriculou em uma
# academia de musculacao. Entretanto, como bom aluno, ﬁcou inconformado ao perceber que sua academia
# ainda armazenava os treinos em ﬁchas de papel. Enzo, portanto, resolveu desenvolver um aplicativo
# de celular para vender para sua academia. O aplicativo vai se chamar ”Hoje Ta Pago” e deve 
# armazenar as seguintes informacoes:

# Um dicionario contendo todos os possıveis exercıcios da academia. A chave e o codigo do exercıcio
# e o valor e o nome  do  exercıcio. Exemplo:

exercicios = {"P001":"Supino articulado inclinado",
              "P002":"Supino declinado com halteres",
              "P003":"Fly","C001":"Barragraviton",
              "C002":"Fly inverso",
              "C003":"Remada curvada supinada",
              "T001":"Triceps maquina",
              "T002":"Triceps testa com barra",
              "T003":"Triceps inverso",
              "B001":"Biceps barra W",
              "B002":"Biceps alternado polia baixa",
              "B003":"Rosca neutra com halteres",
              "A001":"Abdominal obliquo banco lombar",
              "A002":"Abdominal paralela joelho estendido",
              "A003":"Abdominal canivete",
              "A004":"Abdominal morcego", 
              "A005":"Lombar banco",
              "O001":"Desenvolvimento Arnold",
              "O002":"Elevacao frontal com corda",
              "O003":"Remada alta na polia baixa",
              "I001":"Agachamento Smith",
              "I002":"Leg horizontal",
              "I003":"Cadeira extensora",
              "I004":"Flexora vertical",
              "I005":"Cadeira flexora",
              "I006":"Panturrilha maquina"}

# Um dicionario para armazenar os dados dos alunos. A chave e o login do aluno, e o conteudo e uma 
# tupla contendo seu nome e senha. Exemplo:

alunos ={"Enzo": ("EnzodaSilva","12345"),
         "Vale": ("Valentina","abacaxi"),
         "Ramon": ("SeuMadruga","b71<3")}

# Um dicionario com todos os treinos cadastrados no aplicativo. A chave do dicionario e o login do
# aluno (portanto, so ha um treino para cada aluno). O conteudo de cada elemento do dicionario e uma
# lista de atividades que o aluno deve fazer, e cada atividade e representada por uma tupla contendo
# 4 informacoes:
# Codigo do exercıcio;
# Quantidade de series que o aluno deve executar;
# Numero de repeticoes em cada serie;
# Grupo do treino (o aluno pode fazer grupos diferentes de exercicios por dia).

treinos ={"Enzo": [("P001",3,8,"A"),("P002",3,8,"A"),
         ("P003",3,8,"A"),("T001",3,8,"A"),
         ("T002",3,8,"A"),("T003",3,8,"A"),
         ("A001",4,15,"A"),("A002",4,15,"A"),
         ("C001",3,8,"B"),("C002",3,8,"B"),
         ("C003",3,8,"B"),("B001",3,8,"B"),
         ("B002",3,8,"B"),("B003",3,8,"B"),
         ("A001",3,8,"B"),("A002",4,15,"B"),
         ("A003",4,15,"B"),("O001",4,15,"C"),
         ("O002",3,8,"C"),("O003",3,8,"C"),
         ("P001",3,8,"C"),("P002",3,8,"C"),
         ("P003",3,8,"C"),("P004",3,8,"C"),
         ("P005",3,8,"C"),("P006",3,8,"C") ],         
         "Vale": [("P001",3,8,"A"),("T001",3,8,"A"),
         ("A001",3,8,"A"),("C001",3,8,"B"),
         ("B001",3,8,"B"),("A001",3,8,"B"),
         ("A003",3,8,"C"),("O001",3,8,"C"),
         ("P006",3,8,"C") ]}

# Enzo ja comecou a desenvolver o sistema, mas esta precisando de ajuda com algumas funcionalidades.

# Crie uma funcao que receba como parametros os tres dicionarios, o login de um aluno e um grupo.
# A funcao deve imprimir o nome do aluno e quais atividades daquele grupo que o aluno devera fazer.

# Crie uma funcao que receba como parametros  os  tres  dicionarios e o login de um aluno, e imprima
# o nome de todos os exercıcios que o aluno ainda nao faz.

# Crie uma funcao para autenticar o aluno no sistema. A funcao deve solicitar que o usuario digite
# seu login e senha, e entao validar se a senha esta correta. 
# Caso esteja, a funcao solicita que o aluno informe o grupo que ele deseja treinar naquele dia, e
# entao utilizar a funcao da Questao 1 para exibir os exercıcios daquele grupo que o aluno deve
# realizar. A funcao deve exibir mensagens de erro diferentes para os seguintes casos: login nao
# existente, senha incorreta, ou grupo inexistente para o aluno (ou seja, se nenhum exercıcio tiver
# sido cadastrado para o aluno naquele grupo).

#$ Biblioteca usada na funcao "clear"
import os

#$ Funcao para limpar o terminal
def clear():
    if os.name == 'nt':
        os.system('cls')
    else:
        os.system('clear')

#$ Funcao para exibicao da lista de exercicios que o aluno ira executar
def listaExercicios(exercicios, alunos, treinos, login, grupo):

    #$ Processo para definicao do nome do aluno com base no seu login
    for pessoa in alunos:
        if alunos[pessoa][0] == login:
            nomeAluno = pessoa

    print(f'Aluno: {nomeAluno} \nGrupo: {grupo}\n')

    #$ Impressao do nome do exercicio, numero de series e repeticoes
    for codigoExercicio in treinos[nomeAluno]:
        if codigoExercicio[3] == grupo:
            for exercicio in exercicios:
                if codigoExercicio[0] == exercicio:
                    nomeExercicio = exercicios[exercicio]
            print(f'{nomeExercicio} - {codigoExercicio[1]} de {codigoExercicio[2]}')

#listaExercicios(exercicios, alunos, treinos, 'EnzodaSilva', 'A')

#$ Funcao para impressao de todos os exercicios que o aluno ainda nao faz
def execiciosFuturos(exercicios, alunos, treinos, login):

    #$ Definicao do nome de aluno
    for pessoa in alunos:
        if alunos[pessoa][0] == login:
            nomeAluno = pessoa

    #$ Criacao da lista com todos os exercicios que o aluno faz atualmente
    treinoAluno = []
    for exercicioAluno in treinos[nomeAluno]:
        treinoAluno.append(exercicioAluno[0])

    #$ Impressao dos exercicios que o aluno nao faz
    for exercicio in exercicios:
        if exercicio not in treinoAluno:
            print(f'{exercicio} - {exercicios[exercicio]}')

# execiciosFuturos(exercicios, alunos, treinos, 'Valentina')

#$ Funcao para autenticar o usuario
def autenticarUsuario(alunos, treinos, exercicios):

    #$ Entrada de login e senha do usuario
    login = input('Login: ')
    senha = input('Senha: ')

    #$ Validacao de login
    loginValido = False
    for pessoa in alunos:
        if login == alunos[pessoa][0]:
            loginValido = True
            nomeAluno = pessoa        
    if not loginValido:
        print('ERRO. Login nao existente.')

    #$ Validacao da senha
    elif alunos[nomeAluno][1] != senha:
        print('ERRO. Senha incorreta.')

    #$ Validacao de grupo de exercicios
    else:

        #$ Entrada do grupo desejado
        grupo = input('Grupo de exercicios desejado: ')
        grupo = grupo.upper()

        #$ Validacao de grupo existente
        grupoValido = False
        if nomeAluno not in treinos:
            print('ERRO. Grupo inexistente.')
        else:
            for _,_,_,grupoExercicio in treinos[nomeAluno]:
                if grupoExercicio == grupo:
                    grupoValido = True
            if not grupoValido:
                print('ERRO. Grupo inexistente.')
            else:

                #$ Impressao do grupo desejado
                clear()
                listaExercicios(exercicios, alunos, treinos, login, grupo)
     
# autenticarUsuario(alunos, treinos, exercicios)