def dividas():
    inputInicial = input().split()
    while inputInicial != ['0', '0']:
        necessitaEmprestimo = False
        nBancos = int(inputInicial[0])
        nDividas = int(inputInicial[1])
        reservas = input().split()
        banco = {}
        for i in range(nBancos):
            banco[i + 1] = int(reservas[i])
        for i in range(nDividas):
            transacao = input().split()
            if banco[int(transacao[0])] - int(transacao[2]) >= 0:
                banco[int(transacao[0])] -= int(transacao[2])
                banco[int(transacao[1])] += int(transacao[2])
            else:
                if banco[int(transacao[0])] != banco[int(transacao[1])]:
                    necessitaEmprestimo = True      
        if necessitaEmprestimo:
            print("N")
        else:
            print("S")
        inputInicial = input().split()
        
dividas()