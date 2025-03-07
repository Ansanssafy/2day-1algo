import sys
I = sys.stdin.readline

N, M = map(int, I().split())

arr = [[0 for _ in range(M)] for _ in range(N)]

arr_num = [list(map(int, I().split())) for _ in range(N)]


for r in range(N):
    for c in range(M):
        if c != 0:
            arr[r][c] += arr_num[r][c] + arr[r][c-1]
        else:
            arr[r][c] += arr_num[r][c]

T = int(I())

for tc in range(T):
    i, j, x, y = map(int, I().split())
    total_sum = 0

    for a in range(i-1, x):
        if j != y:
            if j != 1:
                total_sum += arr[a][y-1] - arr[a][j-2]
            else:
                total_sum += arr[a][y-1]
        else:
            total_sum += arr_num[a][j-1]

    print(total_sum)
