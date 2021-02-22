import sys
input = sys.stdin.readline

def set_router(distance):
    cnt = 1
    cur_loc = loc[0]
    for i in range(1,N):
        if cur_loc + distance <= loc[i]:
            cur_loc = loc[i]
            cnt += 1
    return cnt

def parametric_search(start, end):
    if start > end:
        return end

    mid = (start+end)//2
    if set_router(mid) >= C:
        return parametric_search(mid+1, end)
    else:
        return parametric_search(start, mid-1)

N, C = map(int, input().split())
loc = sorted([int(input()) for _ in range(N)])
start, end = 1, loc[-1]-loc[0]
print(parametric_search(start, end))