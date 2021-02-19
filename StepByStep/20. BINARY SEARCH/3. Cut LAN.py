import sys
input = sys.stdin.readline

def parametric_search(left, right):
    pivot = (left + right)//2
    if left > right:
        return right
    res = 0
    for i in K_LAN:
        res += i//pivot
    if res >= N:
        return parametric_search(pivot+1, right)
    else:
        return parametric_search(left, pivot-1)

K, N = map(int, input().split())
K_LAN = [int(input()) for _ in range(K)]
print(parametric_search(1, sum(K_LAN)//N))