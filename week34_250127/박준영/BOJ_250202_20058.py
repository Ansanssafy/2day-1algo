import sys
from collections import deque
input = sys.stdin.readline
dirs = [(0,1), (0,-1), (1,0), (-1,0)]

def rotation_board(board, size, L):
    new_board = [[0] * size for _ in range(size)]
    
    resize = 2 ** L
    for y in range(0, size, resize):
        for x in range(0, size, resize):
            for i in range(resize):
                for j in range(resize):
                    new_board[y+j][x+resize-i-1] = board[y+i][x+j]
    
    board = new_board
    
    melt_lst = []
    for y in range(size):
        for x in range(size):
            if board[y][x] == 0:
                continue
            
            cnt = 0
            for d in dirs:
                ny, nx = y + d[1], x + d[0]
                if 0<=ny<size and 0<=nx<size and board[ny][nx] >0:
                    cnt += 1
                    
            if cnt < 3:
                melt_lst.append((y, x))
    
    for y, x in melt_lst:
        board[y][x] -= 1
    
    return board

def bfs_ice(board, size):
    
    visited = [[False] * size for _ in range(size)]
    hole_ice_cnt = 0
    area_size = 0
    
    for y in range(size):
        for x in range(size):
            area_cnt = 0
            if visited[y][x] or board[y][x] == 0:
                continue
            q = deque()
            q.append((y, x))
            visited[y][x] = True
            
            while q:
                yy, xx = q.popleft()
                hole_ice_cnt += board[yy][xx]
                area_cnt += 1
                
                for d in dirs:
                    ny, nx = yy + d[0], xx + d[1]
                    if 0<=ny<size and 0<=nx<size and not visited[ny][nx] and board[ny][nx] != 0:
                        visited[ny][nx] = True
                        q.append((ny,nx))
            
            area_size = max(area_size, area_cnt)
    
    print(hole_ice_cnt)
    print(area_size)
    


N, Q = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(2 ** N)]

storm_power = list(map(int, input().split()))

for power in storm_power:
    arr = rotation_board(arr, 2 ** N, power)

bfs_ice(arr, 2 ** N)
