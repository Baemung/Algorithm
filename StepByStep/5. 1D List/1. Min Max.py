num = int(input())
inputlist = [int(i) for i in input().split()]
min = 1000000
max = -1000000

for i in range(num):
    if(inputlist[i] <= min):
        min = inputlist[i]
    if(inputlist[i] >= max):
        max = inputlist[i]

print(min, max)