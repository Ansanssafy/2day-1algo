import sys
from collections import deque
input = sys.stdin.readline

N, M, K, X = map(int, input().split())
# N = 도시의 개수 / M = 도로의 개수 / K = 거리 정보 / X = 출발 도시 번호
arr = [[] for _ in range(N+1)]
distance = [float('inf')]*(N+1)
distance[X] = 0
for _ in range(M):
    a, b = map(int, input().split())
    arr[a].append(b)

q = deque()
q.append((0, X)) # 거리와 시작점
while q:
    
    dist, now = q.popleft()
    
    if dist > K:
        continue
    
    for pos in arr[now]:
        if dist+1 < distance[pos]:
            distance[pos] = dist+1
            q.append((dist+1, pos))

if K not in distance:
    print(-1)
else:
    for i in range(N+1):
        if distance[i] == K:
            print(i)

