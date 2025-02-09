import sys
from collections import deque
input = sys.stdin.readline

N, K = map(int, input().split())
arr = list(map(int, input().split()))

visited = set(arr)

q = deque()

for well in arr:
    q.append((well, 0))

house_cnt = 0
total_unluck = 0

while q:
    pos, dist = q.popleft()
    
    for new_pos in (pos-1, pos+1):
        if new_pos not in visited:
            visited.add(new_pos)
            q.append((new_pos, dist+1))
            total_unluck += dist + 1
            house_cnt += 1
            
            if house_cnt == K :
                print(total_unluck)
                sys.exit()