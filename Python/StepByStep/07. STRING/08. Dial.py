word = input()
alp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
sec = "11122233344455566667778888"
time = 0
for i in word:
    for j in range(len(alp)):
        if i == alp[j]:
            time += (int(sec[j])+2)
print(time)