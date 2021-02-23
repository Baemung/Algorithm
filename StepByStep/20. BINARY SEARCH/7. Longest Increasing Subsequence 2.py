import sys
input = sys.stdin.readline

def parametric_search(start, end, index):
    if start > end:
        return start

    mid = (start+end)//2
    if lis[mid] < A[index]:
        return parametric_search(mid+1, end, index)
    else:
        return parametric_search(start, mid-1, index)

N = int(input())
A = list(map(int, input().split()))
lis = [0]
for i in range(N):
    idx = parametric_search(0, len(lis)-1, i)
    if idx >= len(lis):
        lis.append(A[i])
    else:
        lis[idx] = A[i]

print(len(lis)-1)