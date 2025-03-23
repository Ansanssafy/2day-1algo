import sys
from collections import deque
input = sys.stdin.readline

def changeDirs(wallType, dir):
    if wallType == 1:
        if dir // 2 == 0:
            return 1-dir
        return dir
    elif wallType == 2:
        if dir // 2 == 0:
            return dir
        return 5-dir
    elif wallType == 3:
        return [3, 2, 1, 0][dir]
    elif wallType == 4:
        return [2, 3, 0, 1][dir]

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]

answer_visited = [[False]*M for _ in range(N)]

air_pos = []

for i in range(N):
    for j in range(M):
        if arr[i][j] == 9:
            air_pos.append((i, j))
            answer_visited[i][j] = True

def bfs(sx, sy, d):
    q = deque()
    q.append((sx, sy, d))
    while q:
        x, y, dir = q.popleft()
        dx, dy = dirs[dir]
        nx, ny = x + dx, y + dy

        if 0 <= nx < N and 0 <= ny < M and arr[nx][ny] != 9:
            answer_visited[nx][ny] = True

            if arr[nx][ny] in [1,2,3,4]:
                new_dir = changeDirs(arr[nx][ny], dir)
                q.append((nx, ny, new_dir))
            elif arr[nx][ny] == 0:
                q.append((nx, ny, dir))

for x, y in air_pos:
    for i in range(4):
        bfs(x, y, i)

result = sum(row.count(True) for row in answer_visited)
print(result)
