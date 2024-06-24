N = int(input())

arr = [list(map(int, input().split())) for _ in range(N)]

dp = [[0] * 3 for _ in range(N)]

for i in range(3):
    dp[0][i] = arr[0][i]

for i in range(1, N):
    for j in range(3):
        dp[i][j] = min(dp[i-1][(j+1) % 3], dp[i-1][(j+2) % 3]) + arr[i][j]

print(min(dp[N-1]))