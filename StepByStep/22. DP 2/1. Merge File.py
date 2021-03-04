import sys
input = sys.stdin.readline

'''
- 일반적인 DP 풀이 O(n^3) -
n ~ m까지의 최소합을 dp[n][m] 이라고 표현했을때,
dp[0][m] 까지의 최소합은
dp[0][0]+dp[1][m]
dp[0][1]+dp[2][m]
......
dp[0][m-1]+dp[m][m]
중 최솟값이다.

for _ in range(int(input())):
    K, file = int(input()), list(map(int, input().split()))
    sum_ = [0]*(K+1)
    for i in range(K): #1부터 K까지 각 구간의 총합 비용
        sum_[i+1] = sum_[i]+file[i]
    dp = [[0]*K for _ in range(K)]
    for x in range(1, K): #1부터 K까지 합치는 범위
        for i in range(K-x): #i가 최소합을 구할 구간 Start
            j = i+x #j는 구간 End
            dp[i][j] = sys.maxsize
            for div in range(i, j): #i부터 j까지의 구간을 절반으로 분할하여 최솟값을 찾음
                dp[i][j] = min(dp[i][j], dp[i][div]+dp[div+1][j]) 
            dp[i][j] += sum_[j+1]-sum_[i] #sum_[j+1]-sum_[i]은 i부터 j까지 모두 합한 값
    print(dp[0][-1])
'''

'''
- Knuth's Optimization O(n^2) -
Knuth's Optimization은 Dynamic Programming의 점화식이 아래와 같은 특정 조건을 만족하는 경우 사용할 수 있는 "최적화" 기법이다.
i) DP 점화식 형태
dp[i][j]=min(dp[i][k]+dp[k+1][j])+C[i][j]   (i≤k<j), C는 Cost

ii) 사각 부등식 (Quadrangle Inequality)
C[a][c]+C[b][d]≤C[a][d]+C[b][c]
 
iii) 단조성 (Monotonicity) 
C[b][c]≤C[a][d]  (a≤b≤c≤d) 

위 세 조건을 만족하는 경우 아래와 같은 성질을 만족한다. 
A[i][j] = "D[i][j] 가 최소가 되기 위한 가장 작은 k" 이면 A[i][j−1]≤A[i][j]≤A[i+1][j]

만약 조건 ii)와 iii)을 만족한다면 가장 안쪽의 3번째 반복문 for div in range(j+1, i)를
for div in range(A[i][j-1], A[i+1][j]+1)로 바꿔줄 수 있게 된다. 
그렇게 되면 이 반복문은 '상수' 번 수행하므로 
O(n^3)의 시간복잡도에서 O(n^2) 로 줄어들게 된다.
'''

for _ in range(int(input())):
    K, file = int(input()), list(map(int, input().split()))
    sum_ = [0]*(K+1)
    for i in range(K): #1부터 K까지 각 구간의 총합 비용
        sum_[i+1] = sum_[i]+file[i]
    dp = [[0]*K for _ in range(K)]
    knuth = [[0]*K for _ in range(K)] #Knuth's Optimization 각 구간에서 나오는 k 저장
    for i in range(K): #초기화
        knuth[i][i] = i
    for x in range(1, K): #1부터 K까지 합치는 범위
        for i in range(K-x): #i가 최소합을 구할 구간 Start
            j = i+x
            dp[i][j] = sys.maxsize
            for div in range(knuth[i][j-1], knuth[i+1][j]+1): #범위에 knuth 최적화를 적용, 상수번 반복
                if div < K-1 and dp[i][j] > dp[i][div]+dp[div+1][j]: #최솟값 찾고 갱신
                    dp[i][j] = dp[i][div]+dp[div+1][j]
                    knuth[i][j] = div
            dp[i][j] += sum_[j+1]-sum_[i]
    print(dp[0][K - 1])