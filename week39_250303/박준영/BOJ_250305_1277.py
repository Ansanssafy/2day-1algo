import sys
import math
import heapq
input = sys.stdin.readline

N, W = map(int, input().split())
M = float(input())
points = []

for _ in range(N):
    x, y = map(int, input().split())
    points.append((x, y))

graph = [[] for _ in range(N)]
already_connected = set()

for _ in range(W):
    u, v = map(int, input().split())
    u -= 1
    v -= 1
    graph[u].append((v, 0))
    graph[v].append((u, 0))
    already_connected.add((u, v))
    already_connected.add((v, u))

for i in range(N):
    for j in range(i+1, N):
        if (i, j) in already_connected:
            continue
        dist = math.sqrt((points[i][0] - points[j][0])**2 + (points[i][1] - points[j][1])**2)
        if dist <= M:
            graph[i].append((j, dist))
            graph[j].append((i, dist))

def dijkstra(start):
    INF = float('inf')
    distance = [INF] * N
    distance[start] = 0
    pq = []
    heapq.heappush(pq, (0, start))
    
    while pq:
        cur_dist, cur_node = heapq.heappop(pq)
        
        if cur_dist > distance[cur_node]:
            continue
        
        for neighbor, weight in graph[cur_node]:
            new_dist = cur_dist + weight
            if new_dist < distance[neighbor]:
                distance[neighbor] = new_dist
                heapq.heappush(pq, (new_dist, neighbor))
    return distance

result = dijkstra(0)
final_value = int(result[N-1]*1000)
print(final_value)
