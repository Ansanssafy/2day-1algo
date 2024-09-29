import sys
from collections import deque
input= sys.stdin.readline

N, M = map(int, input().split())

arr= [input().strip() for _ in range(N)]
dirs = [(1,0), (-1,0), (0,1), (0,-1)]
visited = [[False] * M for _ in range(N)]
point = deque([])

for i in range(N):
    for j in range(M):
        if arr[i][j] == 'I':
            point.append((i, j))
            visited[i][j] = True
            break
    if point:
        break

result = 0

while point:
    y, x = point.popleft()
    for d in dirs:
        ny, nx = y + d[0], x + d[1]
        if 0<=ny<N and 0<=nx<M and not visited[ny][nx] and arr[ny][nx] != 'X':
            point.append((ny,nx))
            visited[ny][nx] = True
            if arr[ny][nx] == 'P':
                result += 1

if result:
    print(result)
else:
    print('TT')