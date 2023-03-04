def revisao():
    userInput = input().split()
    while userInput != ['0', '0']:
        brokenKey = userInput[0]
        text = userInput[1]
        while brokenKey in text:
            text = text.replace(brokenKey, '')
        if text == '':
            text = 0
        print(int(text))
        userInput = input().split()

revisao()