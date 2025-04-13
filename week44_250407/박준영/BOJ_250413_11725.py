import sys
from collections import deque

sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n = int(input())
graph = [[] for _ in range(n + 1)]
parent = [0] * (n + 1)

for _ in range(n - 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def bfs(start):
    queue = deque([start])
    while queue:
        current = queue.popleft()
        for neighbor in graph[current]:
            if parent[neighbor] == 0:
                parent[neighbor] = current
                queue.append(neighbor)

bfs(1)

for i in range(2, n + 1):
    print(parent[i])