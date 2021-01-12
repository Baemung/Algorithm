num = int(input())
inputArr = [int(i) for i in input().split()]
min = 1000000
max = -1000000

for i in range(num):
    if(inputArr[i] <= min):
        min = inputArr[i]
    if(inputArr[i] >= max):
        max = inputArr[i]

print(min, max)