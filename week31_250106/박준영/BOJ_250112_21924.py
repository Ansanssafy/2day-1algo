import sys
input = sys.stdin.readline

def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]

def union(parent, rank, x, y):
    rootX = find(parent, x)
    rootY = find(parent, y)
    if rootX != rootY:
        if rank[rootX] > rank[rootY]:
            parent[rootY] = rootX
        elif rank[rootX] > rank[rootY]:
            parent[rootX] = rootY
        else:
            parent[rootY] = rootX
            rank[rootX] += 1
            

N, M = map(int, input().split())
edges = []
max_cost = 0
for _ in range(M):
    a, b, c = map(int, input().split())
    edges.append((c, a - 1, b - 1))
    max_cost += c

edges.sort()
parent = list(range(N))
rank = [0] * N

min_cost = 0
connected_edges = 0

for cost, a, b in edges:
    if find(parent, a) != find(parent, b):
        union(parent, rank, a, b)
        min_cost += cost
        connected_edges += 1

if connected_edges == N - 1:
    print(max_cost-min_cost)
else:
    print(-1)

