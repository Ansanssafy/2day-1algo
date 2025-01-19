import sys
input = sys.stdin.readline

n, m = map(int, input().split())
men = list(map(int, input().split()))
women = list(map(int, input().split()))

men.sort()
women.sort()

dp = [[float('inf')] * (m + 1) for _ in range(n + 1)]
dp[0][0] = 0

for i in range(1, n + 1):
    for j in range(1, m + 1):
        dp[i][j] = dp[i-1][j-1] + abs(men[i-1] - women[j-1])
        if i > j:
            dp[i][j] = min(dp[i][j], dp[i-1][j])
        elif i < j:
            dp[i][j] = min(dp[i][j], dp[i][j-1])
            
print(dp[n][m])
