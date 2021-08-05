num = int(input())
inputArr = [int(i) for i in input().split()]
min_, max_ = 1000000, 1000000
for i in range(num):
    if inputArr[i] <= min_:
        min_ = inputArr[i]
    if inputArr[i] >= max_:
        max_ = inputArr[i]
print(min, max)