from collections import deque
import sys

I = sys.stdin.readline
dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]

N, M = map(int, I().split())

arr = [list(I().strip()) for _ in range(N)]

visited = [[[False]*2 for _ in range(M)] for _ in range(N)]

que = deque([[0, 0, 1, 1]]) # y좌표, x좌표, 이동 횟수, 벽을 부술 수 있는 기회
visited[0][0][1] = True
min_move = float("inf")

while que:
    y, x, move, cnt = que.popleft()
    
    if y == N-1 and x == M-1:
        min_move = min(min_move, move)
        break
            
    for d in dirs:
        ny = d[0] + y
        nx = d[1] + x
            
        if 0 <= ny < N and 0 <= nx < M:
            if arr[ny][nx] == '1' and cnt == 1 and not visited[ny][nx][cnt]:
                visited[ny][nx][0] = True
                que.append([ny, nx, move+1, 0])
                
            if arr[ny][nx] == '0' and not visited[ny][nx][cnt]:
                visited[ny][nx][cnt] = True
                que.append([ny, nx, move+1, cnt])

if min_move == float("inf"):
    print(-1)
else:
    print(min_move)
