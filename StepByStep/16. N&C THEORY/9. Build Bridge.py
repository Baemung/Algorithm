import sys
input = sys.stdin.readline

for i in range(int(input())):
    N, M = map(int, input().split())
    k = M
    for j in range(N-1, 0, -1):
        k, N = k*(M-j), N*j
    print(k//N)