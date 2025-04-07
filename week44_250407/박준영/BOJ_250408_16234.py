import sys
from collections import deque
input = sys.stdin.readline

N, L, R = map(int, input().split())
country = [list(map(int, input().split())) for _ in range(N)]
dirs = [(0,1), (0,-1), (1,0), (-1,0)]
result = 0

def check_country():
    check_dirs = [(0,1), (1,0)]
    for i in range(N):
        for j in range(N):
            for d in check_dirs:
                ni = i + d[0]
                nj = j + d[1]
                if 0 <= ni < N and 0 <= nj < N:
                    cnt_human = abs(country[i][j] - country[ni][nj])
                    if L <= cnt_human <= R:
                        return True
    return False


def movement():
    global country
    visited = [[False]*N for _ in range(N)]

    for i in range(N): 
        for j in range(N):
            if not visited[i][j]:
                items = set()
                q = deque()
                value = 0
                items.add((i, j))
                q.append((i, j))
                value += country[i][j]
                visited[i][j] = True
                
                while q:
                    x, y = q.popleft()
                    
                    for d in dirs:
                        nx, ny = x+d[0], y+d[1]
                        
                        if nx < 0 or nx >= N or ny < 0 or ny >= N or visited[nx][ny]:
                            continue
                        if L <= abs(country[x][y] - country[nx][ny]) <= R:
                            items.add((nx, ny))
                            q.append((nx, ny))
                            value += country[nx][ny]
                            visited[nx][ny] = True
                            
                cal_value = value // len(items)
                for ii, jj in list(items):
                    country[ii][jj] = cal_value


while check_country():
    movement()
    result += 1

print(result)