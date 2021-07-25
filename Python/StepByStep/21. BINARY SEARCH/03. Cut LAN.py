import sys
input = sys.stdin.readline

def parametric_search(left, right):
    if left > right: #최댓 값으로 수렴
        return right
    pivot, res = (left+right)//2, 0
    for i in K_LAN:
        res += i//pivot #해당길이로 몇개를 자를 수 있는지 구함
    if res >= N: #목표 갯수보다 많거나 같으면
        return parametric_search(pivot+1, right) #최대값을 찾기 위해 값을 키움
    else:
        return parametric_search(left, pivot-1) #목표 갯수보다 적게 자르면 값을 줄임

K, N = map(int, input().split())
K_LAN = [int(input()) for _ in range(K)]
print(parametric_search(1, sum(K_LAN)//N))