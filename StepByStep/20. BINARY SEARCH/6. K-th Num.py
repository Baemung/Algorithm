import sys
input = sys.stdin.readline

def count_lower(num):
    cnt = 0
    for i in range(1,N+1):
        if N < num//i:
            cnt += N
        else:
            cnt += num//i
    return cnt

def parametric_search(start, end):
    if start > end:
        return start

    mid = (start+end)//2
    lower = count_lower(mid)
    if lower >= k:
        return parametric_search(start, mid-1)
    else:
        return parametric_search(mid+1, end)

N, k = int(input()), int(input())
start, end = 1, N**2
print(parametric_search(start, end))