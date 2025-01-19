import sys
input = sys.stdin.readline

R, C, Q = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(R)]
sum_arr = [[0] * (C+1) for _ in range(R+1)]

for i in range(1, R+1):
    for j in range(1, C+1):
        sum_arr[i][j] = arr[i - 1][j - 1] + sum_arr[i - 1][j] + sum_arr[i][j - 1] - sum_arr[i - 1][j - 1]

for _ in range(Q):
    r1, c1, r2, c2 = map(int, input().split())
    total = (sum_arr[r2][c2] - sum_arr[r1 - 1][c2] - sum_arr[r2][c1 - 1] + sum_arr[r1 - 1][c1 - 1])
    area = (r2 - r1 + 1) * (c2 - c1 + 1)
    print(total // area)