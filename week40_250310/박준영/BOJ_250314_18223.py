import sys
import heapq
input = sys.stdin.readline

def dijkstra(s):
    pq = []
    heapq.heappush(pq, (0, s))
    distance[s] = 0
    
    while pq:
        dist, now = heapq.heappop(pq)
        
        if distance[now] < dist:
            continue
        
        for next, cost in graph[now]:
            new_cost = dist + cost
            if new_cost < distance[next]:
                distance[next] = new_cost
                heapq.heappush(pq, (new_cost, next))


V, E, P = map(int, input().split())
graph = [[] for _ in range(V+1)]

for _ in range(E):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

distance = [float('inf')] * (V+1)
dijkstra(1)
Vminvalue = distance[V]
pMinValue = distance[P]

distance = [float('inf')] * (V+1)
dijkstra(P)
pvMinValue = distance[V]

if Vminvalue == pMinValue + pvMinValue:
    print('SAVE HIM')
else:
    print('GOOD BYE')