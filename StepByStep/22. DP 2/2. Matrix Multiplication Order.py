import sys
input = sys.stdin.readline

'''
- 일반적인 DP 풀이 O(n^3) -
앞선 Merge File과 풀이가 거의 동일하다.
'''

N = int(input())
mat = [list(map(int, input().split())) for _ in range(N)]
dp = [[0]*N for _ in range(N)]
for x in range(1, N): #행렬 합치는 범위
    for i in range(N-x): #합치기 시작하는 인덱스
        j = i+x #끝나는 인덱스
        dp[i][j] = sys.maxsize
        for div in range(i, j): #i와 j를 div라는 기준으로 나워서 직전까지의 연산횟수 + 현재 연산횟수로 총 연산횟수의 최솟값을 구함
            dp[i][j] = min(dp[i][j], mat[i][0]*mat[div+1][0]*mat[j][1]+dp[i][div]+dp[div+1][j])  
            #mat[div+1][0] 또는 mat[div][1] 둘다 동일하다.
print(dp[0][-1])