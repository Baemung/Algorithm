text = input().upper()
textSet = set(text)
max = 0
word = 0

for i in textSet:
    cnt = 0
    for j in text:
        if(i == j):
            cnt += 1
    if(max < cnt):
        max = cnt
        word = i
    elif(max == cnt):
        word = '?'

print(word)