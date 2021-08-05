import sys
input = sys.stdin.readline

def fib(n):
    if n == 0:
        print(1, 0)
    elif n == 1:
        print(0, 1)
    else:
        a = [1, 1]
        for i in range(n):
            a.append(a[i]+a[i+1])
        print(a[-4], a[-3]) #a[-3] 이 n의 피보니치

for i in range(int(input())):
    fib(int(input()))