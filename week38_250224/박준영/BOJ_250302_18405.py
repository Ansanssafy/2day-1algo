import sys
from collections import deque

input = sys.stdin.readline

N, K = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
S, X, Y = map(int, input().split())

virus = []
dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]

for i in range(N):
    for j in range(N):
        if arr[i][j] != 0:
            virus.append((arr[i][j], i, j, 0))

virus.sort()
queue = deque(virus)

while queue:
    v, x, y, time = queue.popleft()

    if time == S:
        break

    for dx, dy in dirs:
        nx, ny = x + dx, y + dy

        if 0 <= nx < N and 0 <= ny < N and arr[nx][ny] == 0:
            arr[nx][ny] = v
            queue.append((v, nx, ny, time + 1))

print(arr[X-1][Y-1])
