import sys
from collections import deque
input = sys.stdin.readline
#분할정복 시간초과
#가장 낮은 높이를 구하여(동일하면 가장 먼저 나온것) 좌우로 분할하고 시작과 끝을 높이로 곱함
''' 
def dq(start, end):
    global res
    if end-start < 1:
        return
    height = max(case)
    for i in range(start,end+1):
        if case[i] < height:
            low = i
            height = case[i]
    res = max(res, height*(end-start+1))    
    dq(start, low-1)
    dq(low+1, end)
    return

while True:
    n, *case = list(map(int, input().split()))
    if n == 0:
        break
    if len(set(case)) == 1:
        print(n * case[0])
        continue
    res = max(case)
    dq(0, n-1)
    print(res)
'''
#스택풀이
while True:
    n, *histogram = list(map(int, input().split())) #첫번째는 n 나머지는 리스트형태로 h로 저장
    histogram.insert(0, 0) #첫번째 기둥을 비교하기 위해 앞에 0을 추가
    histogram.append(0) #마지막 기둥을 비교하기 위해 뒤에 0을 추가
    if n == 0:
        break
    stack = [0] #첫번째를 위해 추가하려고 미리 0을 저장
    ans = 0
    for i in range(1, n+2): #앞뒤로 하나씩 총 2개를 추가했기 때문에 n+2
        while stack and histogram[stack[-1]] > histogram[i]: #낮은것이 발견되거나 스택이 비어있지 않다면
            cur_h = stack.pop()
            ans = max(ans, (i-1-stack[-1])*histogram[cur_h]) #i-1는 end, stack[-1]은 start, histogram[cur_h]는 기둥 높이
        stack.append(i)
    print(ans)