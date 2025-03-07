import sys
input= sys.stdin.readline

N = int(input())

arr = []
for _ in range(N):
    day, value = map(int, input().split())
    arr.append((day, value))

dp = [0] * (N+1)

for i in range(N-1, -1, -1):
    if i + arr[i][0] <= N:
        dp[i] = max(arr[i][1] + dp[i+arr[i][0]], dp[i+1])
    else:
        dp[i] = dp[i+1]

print(dp[0])