import sys
input = sys.stdin.readline

num,op = "",""
for i in input():
    if(i.isdigit()): num += i
    else:
        num += ' '
        op += i
num = num.split(' ')[:-1]
sum = int(num[0])
pm = 0
for i in range(len(num)-1):
    if(op[i] == '-'): pm = 1
    if(pm): sum -= int(num[i+1])
    else: sum += int(num[i+1])
print(sum)