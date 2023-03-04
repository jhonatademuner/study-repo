def handebol():
    counter = 0
    initialInput = input().split()
    n = int(initialInput[0])
    for i in range(n):
        matchGoals = input().split()
        if not '0' in matchGoals:
            counter += 1
    print(counter)

handebol()