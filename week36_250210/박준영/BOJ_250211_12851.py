import sys
from collections import deque
input = sys.stdin.readline

N, K = map(int, input().split())

Max = 100000
time = [-1] * (Max+1)
ways = [0] * (Max+1)

q = deque()
q.append(N)
time[N] = 0
ways[N] = 1

while q:
    position = q.popleft()
    
    for next_pos in (position-1, position+1, position*2):
        if 0<=next_pos<=Max:
            if time[next_pos] == -1:
                time[next_pos] = time[position]+1
                ways[next_pos] = ways[position]
                q.append(next_pos)
            elif time[next_pos] == time[position]+1:
                ways[next_pos] += ways[position]

print(time[K])
print(ways[K])