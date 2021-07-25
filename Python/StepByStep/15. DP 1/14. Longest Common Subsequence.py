strA = [i for i in input()]
strB = [i for i in input()]
lenA, lenB = len(strA), len(strB)
dp = [[0]*(lenA+1) for _ in range(lenB+1)]
for i in range(1, lenB+1):
    for j in range(1, lenA+1):
        dp[i][j] = max(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]+(strA[j-1] == strB[i-1]))
print(dp[lenA][lenB])