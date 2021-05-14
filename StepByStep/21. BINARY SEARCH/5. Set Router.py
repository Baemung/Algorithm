import sys
input = sys.stdin.readline

def set_router(distance): #해당거리로 몇개의 라우터를 설치할 수 있는지 계산
    cnt = 1
    cur_loc = loc[0]
    for i in range(1, N):
        if cur_loc+distance <= loc[i]: #다음 집이 현재집 + 거리안에 있으면
            cur_loc = loc[i] #현재집 갱신
            cnt += 1 #갯수 추가
    return cnt

def parametric_search(start, end):
    if start > end: #최대 거리로 수렴
        return end
    mid = (start+end)//2
    if set_router(mid) >= C: #거리에 따라 설치할 수 있는 라우터수가 C보다 크거나 같으면
        return parametric_search(mid+1, end) #거리를 최대화
    else:
        return parametric_search(start, mid-1) #적으면 거리를 줄임

N, C = map(int, input().split())
loc = sorted([int(input()) for _ in range(N)])
start, end = 1, loc[-1]-loc[0] #거리는 최소는 1부터, 최대는 처음집에서 마지막집까지의 거리
print(parametric_search(start, end))