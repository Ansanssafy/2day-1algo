import sys
input = sys.stdin.readline

N = int(input())
T = []
P = []
for _ in range(N):
    t, p = map(int, input().split())
    T.append(t)
    P.append(p)

dp = [0] * (N + 1)
max_profit = 0

for i in range(N):
    max_profit = max(max_profit, dp[i])
    if i + T[i] <= N:
        dp[i + T[i]] = max(dp[i + T[i]], max_profit + P[i])

print(max(dp))
