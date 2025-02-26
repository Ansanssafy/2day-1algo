import sys
from collections import deque
input = sys.stdin.readline

N, k = map(int, input().split())

ways = [input().strip() for _ in range(2)]
visited = [[False] * N for _ in range(2)]
q = deque()
q.append((0, 0, 0))
visited[0][0] = True
result = 0

while q and result == 0:
    load, pos, time = q.popleft()
    
    if pos >= N:
        result = 1
        break
    
    if ways[load][pos] == '0':
        continue
    
    for new_load, new_pos in [(load, pos+1), (load, pos-1), ((load+1)%2, pos+k)]:
        if new_pos >= N:
            result = 1
            break
        if new_pos > time and new_pos >= 0 and ways[new_load][new_pos] == '1' and not visited[new_load][new_pos]:
            visited[new_load][new_pos] = True
            q.append((new_load, new_pos, time+1))
        

print(result)
