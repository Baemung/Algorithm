import sys
input = sys.stdin.readline

def parametric_search(start, end, val):
    if start > end: #해당 자리(최솟값)으로 수렴
        return start
    mid = (start+end)//2
    if lis[mid] >= val: #리스트의 값보다 크거나, 작으면 범위를 줄여서 자리를 찾음
        return parametric_search(start, mid-1,val) #lis[mid]가 리스트값보다 크면 lis를 start - mid로 범위를 줄여서 다시 서치
    else:
        return parametric_search(mid+1, end, val) #lis[mid]가 리스트값보다 작으면 lis를 mid - end로 범위를 줄여서 다시 서치

N = int(input())
A = list(map(int, input().split()))
lis = [0] #인덱스를 담을 리스트이므로 초기 인덱스 0 지정
for i in A:
    if lis[-1] < i: #lis 의 가장 큰값이 리스트요소 값보다 작으면
        lis.append(i) #lis에 추가
    else: #lis의 값 범위 안이면
        lis[parametric_search(0, len(lis)-1, i)] = i #lis에 위치 갱신

print(len(lis)-1) #초기 인덱스 0을 제외한 lis길이