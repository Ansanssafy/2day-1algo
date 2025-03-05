import sys
import heapq
input = sys.stdin.readline
INF = float('inf')

V, E = map(int, input().split())
start = int(input())

graphs = [[] for _ in range(V+1)]
for _ in range(E):
    u, v, w = map(int, input().split())
    graphs[u].append((v, w))

def dijkstra(s):
    distance = [INF] * (V+1)
    distance[s] = 0
    
    q = []
    heapq.heappush(q, (0, s))
    
    while q:
        cur_val, cur_pos = heapq.heappop(q)
        
        if cur_val > distance[cur_pos]:
            continue
        
        for next_pos, next_val in graphs[cur_pos]:
            cost = next_val + cur_val
            
            if cost < distance[next_pos]:
                distance[next_pos] = cost
                heapq.heappush(q, (cost, next_pos))
    
    return distance

result = dijkstra(start)

for i in result[1:]:
    print('INF' if i == float('inf') else i)
