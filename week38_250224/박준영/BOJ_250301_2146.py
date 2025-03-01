import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
maps = [list(map(int, input().split())) for _ in range(N)]
dirs = [(0,1), (0,-1), (1,0), (-1,0)]
ireland_num = 2
visited = []
result = float('inf')


def tieLand(i, j):
    q = deque()
    q.append([i,j])
    maps[i][j] = ireland_num
    coast = deque()
    
    while q:
        x, y = q.popleft()
        is_coast = False
        
        for d in dirs:
            nx, ny = d[0] + x, d[1] + y
            
            if 0 <= nx < N and 0 <= ny < N:
                if maps[nx][ny] == 0:
                    is_coast = True
                elif maps[nx][ny] == 1:
                    q.append((nx, ny))
                    maps[nx][ny] = ireland_num
        
        if is_coast:
            coast.append((x, y))
            
    return coast
        

coasts = []
for i in range(N):
    for j in range(N):
        if maps[i][j] == 1:
            coasts.append(tieLand(i, j))
            ireland_num += 1

def checkRoot(coast, land_num):
    global result
    q = deque()
    visited = [[False] * N for _ in range(N)]
    
    for x, y in coast:
        q.append((x, y, 0))
        visited[x][y] = True
    
    while q:
        a, b, cnt = q.popleft()
        
        if cnt >= result:
            break
        
        for d in dirs:
            na, nb = d[0] + a, d[1] + b
            
            if 0<=na<N and 0<=nb<N and not visited[na][nb]:
                if maps[na][nb] == 0:
                    visited[na][nb] = True
                    q.append((na, nb, cnt+1))
                elif maps[na][nb] > 1 and maps[na][nb] != land_num:
                    result = min(result, cnt)
                    return
                    

for idx, coast in enumerate(coasts):
    checkRoot(coast, idx+2)

print(result)