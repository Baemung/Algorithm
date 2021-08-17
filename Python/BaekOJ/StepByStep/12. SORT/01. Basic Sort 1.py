li = list(int(input()) for _ in range(int(input())))
for i in range(len(li)-1):
    for j in range(i+1, len(li)):
        if li[i] > li[j]:
            temp = li[i]
            li[i] = li[j]
            li[j] = temp
for i in li:
    print(i)