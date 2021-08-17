import sys
input = sys.stdin.readline

num, op = "", ""
for i in input():
    if i.isdigit():
        num += i
    elif i != '\n':
        num += ' '
        op += i
num = num.split(' ')
res = int(num[0])
pm = 0
for i in range(len(num)-1):
    if op[i] == '-':
        pm = 1
    if pm:
        res -= int(num[i+1])
    else:
        pm = 0
        res += int(num[i+1])
print(res)