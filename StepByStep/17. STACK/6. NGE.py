import sys
input = sys.stdin.readline

n = int(input())
li = list(map(int, input().split()))
stack_,top = [],0

for i in range(n-1):
    while(len(stack_)>0 and top<li[i]):
