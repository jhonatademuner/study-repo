# Dada uma matriz, verifique se ela e uma matriz identidade:

def matrizIdentidade(m):
    for i in range(len(m)):
        if m[i][i] != m[0][0]:
            return False
    return True