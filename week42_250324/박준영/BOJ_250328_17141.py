import sys
from itertools import combinations
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
dirs = [(0,1), (0,-1), (1,0), (-1,0)]
INF = float('inf')
result = INF

virus_s = []
for i in range(N):
    for j in range(N):
        if arr[i][j] == 2:
            virus_s.append((i, j))

for comb in combinations(virus_s, M):
    q = deque()
    visited = [[False] * N for _ in range(N)]
    
    for a, b in comb:
        q.append((a, b, 0))
        visited[a][b] = True
    
    max_time = 0
    while q:
        x, y, time = q.popleft()
        
        max_time = max(max_time, time)
        
        for d in dirs:
            nx = d[0] + x
            ny = d[1] + y
            
            if 0>nx or nx>=N or 0>ny or ny>=N:
                continue
            if visited[nx][ny] == True or arr[nx][ny] == 1:
                continue
            
            q.append((nx, ny, time+1))
            visited[nx][ny] = True
    
    for i in range(N):
        for j in range(N):
            if arr[i][j] != 1 and not visited[i][j]:
                max_time = INF
                break
        else:
            continue
        break
    
    result = min(result, max_time)

print(result if result != INF else -1)