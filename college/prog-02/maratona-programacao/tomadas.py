def tomadas():
    powerPlugs = input().split()
    powerPlugs = list(map(lambda x: int(x), powerPlugs))
    powerPlugs = list(powerPlugs)
    print(sum(powerPlugs) - 3)

def tomadas2():
    powerPlugs = input().split()
    print(int(powerPlugs[0]) + int(powerPlugs[1]) + int(powerPlugs[2]) + int(powerPlugs[3])  - 3)

tomadas()