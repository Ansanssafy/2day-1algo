import sys
from collections import deque

I = sys.stdin.readline

N, M = map(int, I().split())

move_arr = [0] * 101

for i in range(N+M):
    x, y = map(int, I().split())
    move_arr[x] = y

q = deque([(1, 0)])
min_cnt = float('inf')

while q:
    start, cnt = q.popleft()
    
    for j in range(1, 7):
        if start+j < 100:
            if move_arr[start+j] != 0 and move_arr[start+j] != -1:
                q.append((move_arr[start+j], cnt+1))
                move_arr[start+j] = -1
                
        elif start+j == 100:
            min_cnt = min(cnt+1, min_cnt)
        
        elif start+j > 100:
            break
        
    for p in range(6, 0, -1):
        if start+p < 100 and move_arr[start+p] == 0:
            q.append((start+p, cnt+1))
            break
        elif start+p == 100:
            min_cnt = min(cnt+1, min_cnt)

print(min_cnt)