import sys
from collections import Counter
input = sys.stdin.readline

N = int(input())
A = dict(Counter(list(map(int, input().split()))))
M = int(input())
B = list(map(int, input().split()))
for i in B:
    try:
        print(A[i], end=' ')
    except:
        print(0, end=' ')