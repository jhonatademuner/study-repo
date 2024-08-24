def circuito():
    userInput = input().split()
    while userInput != ['0', '0', '0']:
        counter = 0
        nMedicoes = int(userInput[1])
        comprimento = int(userInput[2])
        matriz = []
        for i in range(nMedicoes):
            userInput = input().split()
            matriz.append(userInput)
        for i in range(len(matriz[0])):
            palito = 0
            for linha in matriz:
                if linha[i] == '1': 
                    palito += 1
                    if palito >= comprimento:
                        counter += 1
                        break
                else:
                    palito = 0  
        print(counter)
        userInput = input().split()
        
circuito()