import sys
input = sys.stdin.readline

N = int(input())

arr = [list(map(str, input().split())) for _ in range(N)]
dp = [[[-float('inf'), float('inf')] for _ in range(N)] for _ in range(N)]

dir = [(1, 0), (0, 1)] #아래, 오른쪽


def dfs(x, y, value, cal):
    tmp_value = value
    
    if arr[x][y] in '+-*':
        cal = arr[x][y]
    else:
        if cal == '*':
            tmp_value = value * int(arr[x][y])
        elif cal == '-':
            tmp_value = value - int(arr[x][y])
        elif cal == '+':
            tmp_value = value + int(arr[x][y])
        
        if tmp_value > dp[x][y][0] or tmp_value < dp[x][y][1]:
            if tmp_value > dp[x][y][0]:
                dp[x][y][0] = tmp_value
            if tmp_value < dp[x][y][1]:
                dp[x][y][1] = tmp_value
        else:
            return
    
    for d in dir:
        nx = d[0] + x
        ny = d[1] + y
        
        if 0<=nx<N and 0<=ny<N:
            dfs(nx, ny, tmp_value, cal)

dfs(0, 0, int(arr[0][0]), '')

print(*dp[N-1][N-1])
