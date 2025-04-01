import sys
input = sys.stdin.readline

N, M = map(int , input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
dp = [[[float('inf')] * 3 for _ in range(M)] for _ in range(N)]

for j in range(M):
    for d in range(3):
        dp[0][j][d] = arr[0][j]

for i in range(1, N):
    for j in range(M):
        for d in range(3):
            nj = j + d - 1
            if 0<=nj<M:
                for pd in range(3):
                    if pd == d:
                        continue
                    dp[i][j][d] = min(dp[i][j][d], dp[i-1][nj][pd]+arr[i][j])

result = min(dp[N-1][j][d] for j in range(M) for d in range(3))

print(result)