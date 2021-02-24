num = int(input())
man = []
rank = [1]*num
for i in range(num):
    man.append([int(i) for i in input().split()])
    for j in range(i-1,-1,-1):
        if man[i][0] > man[j][0] and man[i][1] > man[j][1]:
            rank[j] += 1
        elif man[i][0] < man[j][0] and man[i][1] < man[j][1]:
            rank[i] += 1
for i in rank:
    print(i, end=' ')