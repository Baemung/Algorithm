import sys
input = sys.stdin.readline

def count_lower(num): #num보다 작은수를 카운트하는 함수
    cnt = 0
    for i in range(1, N+1): #각 i행별로 갯수 체크
        if N < num//i: #num에서 i를 나누면 동일한 기준으로 카운트가능
            cnt += N #해당 행의 N개 수 모두 카운트
        else:
            cnt += num//i #해당 행의 N개중 작은 수 num//i개만 카운트
    return cnt

def parametric_search(start, end):
    if start > end: #최소 값으로 수렴
        return start
    mid = (start+end)//2
    lower = count_lower(mid) #mid보다 작은 수가 몇개인지 카운트
    if lower >= k: #k보다 크거나 같으면
        return parametric_search(start, mid-1) #최소값을 찾기 위해 값을 줄임
    else:
        return parametric_search(mid+1, end) #값을 키움

N, k = int(input()), int(input())
start, end = 1, N**2 #값의 전체 범위
print(parametric_search(start, end))