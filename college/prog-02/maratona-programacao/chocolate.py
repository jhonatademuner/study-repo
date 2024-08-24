def chocolate():
    tamanhoBarra = int(input())
    meioBarra = tamanhoBarra / 2
    posFigurinha1 = input().split()
    posFigurinha1 = [int(i) for i in posFigurinha1]
    posFigurinha2 = input().split()
    posFigurinha2 = [int(i) for i in posFigurinha2]
    if posFigurinha1[0] <= meioBarra and posFigurinha2[0] > meioBarra: print("S")
    elif posFigurinha1[1] <= meioBarra and posFigurinha2[1] > meioBarra: print("S")
    elif posFigurinha2[0] <= meioBarra and posFigurinha1[0] > meioBarra: print("S")
    elif posFigurinha2[1] <= meioBarra and posFigurinha1[1] > meioBarra: print("S")
    else: print("N")

chocolate()