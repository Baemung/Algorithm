num = int(input())
scoreArr = [int(i) for i in input().split()]
maxScore, sum_ = 0, 0
for i in range(num):
    if maxScore <= scoreArr[i]:
        maxScore = scoreArr[i]
for i in range(num):
    scoreArr[i] = (scoreArr[i]/maxScore)*100
    sum_ += scoreArr[i]
print(sum_/num)