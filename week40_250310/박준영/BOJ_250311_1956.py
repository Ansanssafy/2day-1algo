import sys
input = sys.stdin.readline

V, E = map(int, input().split())
dist = [[float('inf')]*(V+1) for _ in range(V+1)]

for _ in range(E):
    a, b, c = map(int, input().split())
    dist[a][b] = c
    
for k in range(1, V+1):
    for i in range(1, V+1):
        for j in range(1, V+1):
            if dist[i][j] > dist[i][k] + dist[k][j]:
                dist[i][j] = dist[i][k] + dist[k][j]

min_cycle = float('inf')
for i in range(1, V+1):
    min_cycle = min(min_cycle, dist[i][i])

if min_cycle == float('inf'):
    print(-1)
else:
    print(min_cycle)