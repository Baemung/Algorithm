num = int(input())
scoreArr = [int(i) for i in input().split()]

maxScore = 0
for i in range(num):
    if(maxScore <= scoreArr[i]):
        maxScore = scoreArr[i]

sum = 0
for i in range(num):
    scoreArr[i] = (scoreArr[i]/maxScore)*100
    sum += scoreArr[i]

mean = sum/num
print(mean)