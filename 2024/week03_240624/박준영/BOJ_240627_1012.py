import sys
from collections import deque
dir = [(0, 1), (1, 0), (-1, 0), (0, -1)]

T = int(sys.stdin.readline())

for t in range(T):
    M, N, K = map(int, sys.stdin.readline().split())
    
    arr = [[0] * M for _ in range(N)]
    
    for p in range(K):
        X, Y = map(int, sys.stdin.readline().split())
        arr[Y][X] = 1
    
    q = deque([])
    cnt = 0
    
    for i in range(N):
        for j in range(M):
            if arr[i][j] == 1:
                q.append((i, j))
                arr[i][j] = 0
            
                while q:
                    a, b = q.popleft()
                    
                    for d in dir:
                        na = a + d[0]
                        nb = b + d[1]
                        if 0 <= na < N and 0 <= nb < M and arr[na][nb] == 1:
                            q.append((na, nb))
                            arr[na][nb] = 0
                cnt += 1
    print(cnt)