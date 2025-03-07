import sys
input = sys.stdin.readline

def floyd_warshall(n, graph):
    for k in range(1, n + 1):
        for i in range(1, n + 1):
            for j in range(1, n + 1):
                if graph[i][j] > graph[i][k] + graph[k][j]:
                    graph[i][j] = graph[i][k] + graph[k][j]

def find_kevin_bacon(n, graph):
    min_bacon = float('inf')
    result = -1
    for i in range(1, n + 1):
        bacon_sum = sum(graph[i][1:])
        if bacon_sum < min_bacon:
            min_bacon = bacon_sum
            result = i
    return result

n, m = map(int, input().split())
graph = [[float('inf')] * (n + 1) for _ in range(n + 1)]

for i in range(1, n + 1):
    graph[i][i] = 0

for _ in range(m):
    a, b = map(int, input().split())
    graph[a][b] = 1
    graph[b][a] = 1

floyd_warshall(n, graph)

print(find_kevin_bacon(n, graph))