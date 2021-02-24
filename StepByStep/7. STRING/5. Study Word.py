text = input().upper()
textSet = set(text)
max_, word = 0, 0
for i in textSet:
    cnt = 0
    for j in text:
        if i == j:
            cnt += 1
    if max_ < cnt:
        max_ = cnt
        word = i
    elif max_ == cnt:
        word = '?'
print(word)