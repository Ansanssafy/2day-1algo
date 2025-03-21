import sys
input = sys.stdin.readline

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(x, y):
    a = find(x)
    b = find(y)
    
    if a != b:
        parent[a] = b
        return True
    return False


N, M, T = map(int, input().split())
edges = []

for _ in range(M):
    A, B, C = map(int, input().split())
    edges.append((C, A, B)) # cost, a, b

edges.sort()
parent = [i for i in range(N+1)]

total_cost = 0
conquered = 0

for cost, a, b in edges:
    if union(a, b):
        total_cost += cost + conquered * T
        conquered += 1

print(total_cost)

