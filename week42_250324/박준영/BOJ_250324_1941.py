from itertools import combinations
from collections import deque

arr = [list(input().strip()) for _ in range(5)]

positions = [(i, j) for i in range(5) for j in range(5)]

def is_connected(selected):
    q = deque([selected[0]])
    visited = set([selected[0]])
    selected_set = set(selected)
    
    while q:
        x, y = q.popleft()
        for dx, dy in [(-1,0), (1,0), (0,-1), (0,1)]:
            nx, ny = x + dx, y + dy
            if (nx, ny) in selected_set and (nx, ny) not in visited:
                visited.add((nx, ny))
                q.append((nx, ny))
    
    return len(visited) == 7

result = 0

for comb in combinations(positions, 7):
    s_count = sum(1 for x, y in comb if arr[x][y] == 'S')
    if s_count < 4:
        continue
    if is_connected(comb):
        result += 1

print(result)
