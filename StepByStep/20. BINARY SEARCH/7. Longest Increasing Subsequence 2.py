import sys
input = sys.stdin.readline

def parametric_search(start, end, index):
    if start > end: #해당 자리(최솟값)으로 수렴
        return start
    mid = (start+end)//2
    if lis[mid] >= A[index]: #리스트의 값보다 크거나, 작으면 범위를 줄여서 자리를 찾음
        return parametric_search(start, mid-1, index)
    else:
        return parametric_search(mid+1, end, index)

N = int(input())
A = list(map(int, input().split()))
lis = [0] #인덱스를 담을 리스트이므로 초기 인덱스 0 지정
for i in range(N):
    idx = parametric_search(0, len(lis)-1, i)
    if idx >= len(lis): #찾은 인덱스의 자리가 범위안에 없으면
        lis.append(A[i]) #리스트에 추가
    else: #작은게 있으면
        lis[idx] = A[i] #해당자리에 값 갱신
print(len(lis)-1) #초기 인덱스 0을 제외한 lis길이