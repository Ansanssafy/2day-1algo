import sys
from collections import deque
input = sys.stdin.readline

N, K = map(int, input().split())
arr = deque([(N, 0)])
visited = dict()

while arr:
    location, cnt = arr.popleft()
    
    if location == K:
        print(cnt)
        break
    
    visited[location] = cnt
    for next_location in (location-1, location+1, location*2):
        if 0 <= next_location <= 1000000 and next_location not in visited:
            arr.append((next_location, cnt+1))