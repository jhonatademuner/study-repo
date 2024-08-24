def geradorLista(tamanho, x, y):                                    #$ OK / Funcao para testes
    import random

    l = []
    for i in range(tamanho):
        l.append(random.randint(x, y))
    return l

def validaOrdenacao(lista):                                         #$ OK / Funcao para testes
    padrao = lista.copy()
    padrao.sort()
    return lista == padrao

def testeTempo(tamanhoLista):                                       #$ OK / Funcao para testes
    import time

    l1 = geradorLista(tamanhoLista, 1, 1000000)
    l2 = l1.copy()
    l3 = l1.copy()
    l4 = l1.copy()
    l5 = l1.copy()

    start_time = time.time()
    mergeSort(l5)
    print(validaOrdenacao(l5))
    print(f"MergeSort -> {(time.time() - start_time)} seconds")

    start_time = time.time()
    quickSort(l4, 0, len(l4) - 1)
    print(f"QuickSort -> {(time.time() - start_time)} seconds")

    start_time = time.time()
    selectionSort(l3)
    print(f"TimSort -> {(time.time() - start_time)} seconds")

    start_time = time.time()
    insertionSort(l2)
    print(f".sort() -> {(time.time() - start_time)} seconds")

    start_time = time.time()
    bubbleSort(l1)
    print(f"BubbleSort -> {(time.time() - start_time)} seconds")

def bubbleSort(lista):                                              #$ OK / Otimizado
    tamanhoLista = len(lista)
    for i in range(tamanhoLista):
        for j in range(0, tamanhoLista - i - 1):
            if lista[j] > lista[j + 1]:
                (lista[j], lista[j + 1]) = (lista[j + 1], lista[j])

def selectionSort(lista):                                           #$ OK / Otimizado
    for i in range(len(lista)):
        menor = i
        for j in range(i + 1, len(lista)):
            if lista[j] < lista[menor]:
                menor = j
        (lista[i], lista[menor]) = (lista[menor], lista[i])

def insertionSort(lista):                                           #$ OK / Otimizado
    for i in range(1,len(lista)):
        for j in range(i):
            if lista[i] < lista[j]:
                lista[j],lista[j+1:i+1] = lista[i],lista[j:i]
                break

def quickSort(lista, inferior, superior):                           #$ OK / Otimizado

    def particao(lista, inferior, superior):
        pivo = lista[inferior] # primeiro elemento da matriculas
        i = inferior + 1 # indice segundo elemento
        j = superior # indice ultimo elemento
        while i <= j: 
            while i <= j and lista[i] <= pivo:
                i += 1
            while j >= i and lista[j] > pivo:
                j -= 1
            if i < j:
                lista[i], lista[j] = lista[j], lista[i]
        lista[inferior], lista[j] = lista[j], lista[inferior]
        return j
    
    if inferior < superior:
        posicao = particao(lista, inferior, superior)
        quickSort(lista, inferior, posicao - 1)
        quickSort(lista, posicao + 1, superior)

def mergeSort(lista):                                               #$ OK / Otimizado

    if len(lista) > 1:
        meio = len(lista) // 2
        listaEsq = lista[:meio]
        listaDir = lista[meio:]

        mergeSort(listaEsq)
        mergeSort(listaDir)

        i = 0
        j = 0
        k = 0

        while i < len(listaEsq) and j < len(listaDir):
            if listaEsq[i] < listaDir[j]:
                lista[k] = listaEsq[i]
                i += 1
            else:
                lista[k] = listaDir[j]
                j += 1
            k += 1

        while i < len(listaEsq):
            lista[k] = listaEsq[i]
            i += 1
            k += 1

        while j < len(listaDir):
            lista[k] = listaDir[j]
            j += 1
            k += 1

def buscaBinaria(lista, target):                                    #$ OK / Otimizado
    inicio = 0
    fim = len(lista) - 1
    while inicio <= fim:
        meio = (inicio + fim) // 2
        if lista[meio] == target:
            return meio
        elif lista[meio] > target:
            inicio = meio + 1
        else:
            fim = meio - 1
    return -1