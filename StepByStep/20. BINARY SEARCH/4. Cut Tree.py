import sys
input = sys.stdin.readline

def parametric_search(left, right):
    if left > right: #최대 높이로 수렴
        return right
    pivot, res = (left+right)//2, 0
    for i in Tree:
        if i-pivot >= 0: #나무 높이보다 작게 잘랐을때만 나무토막이 생성되기 때문에
            res += i-pivot
    if res >= M: #목표 길이보다 길거나 같으면
        return parametric_search(pivot+1, right) #최대 높이를 찾기 위해 값을 키움
    else:
        return parametric_search(left, pivot-1) #목표 길이보다 짧게 남으면 높이를 줄임

N,M = map(int, input().split())
Tree = list(map(int, input().split()))
print(parametric_search(0, max(Tree)))