import sys
input = sys.stdin.readline

num = int(input())
coord = list(map(int, input().split()))

for i in range(num):
    coord[i] = [coord[i],i] #좌표의 인덱스를 같이 저장
coord.sort(key= lambda x:x[0]) #좌표 기준으로 정렬

idx, ret = 0, [0]*num #압축된 좌표를 담을 리스트와 기준 인덱스
ret[coord[0][1]] = idx #전 요소와 크기비교를 위한 첫번 째 값 세팅

for i in range(1, num): #두번 째 값부터 끝까지
    if coord[i][0] > coord[i-1][0]: #전 좌표와 크기 비교를 하여 더 크면 인덱스 +1, 아니라면 인덱스 크기 유지
        idx += 1
    ret[coord[i][1]] = idx #인덱스(압축된 좌표값) 할당

for i in ret:
    print(i, end=' ')