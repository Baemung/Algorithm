import sys
input = sys.stdin.readline

def parametric_search(left, right):
    pivot = (left + right)//2
    if left > right:
        return right
    res = 0
    for i in Tree:
        if i - pivot >= 0:
            res += i - pivot
    if res >= M:
        return parametric_search(pivot+1,right)
    else:
        return parametric_search(left, pivot-1)

N,M = map(int, input().split())
Tree = list(map(int, input().split()))
print(parametric_search(0, max(Tree)))