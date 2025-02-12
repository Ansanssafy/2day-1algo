import sys
input = sys.stdin.readline

n, m = map(int, input().split())
parents = [i for i in range(n)]

def find(x):
    if parents[x] != x:
        parents[x] = find(parents[x])
        
    return parents[x]

def union(u, v):
    x = find(u)
    y = find(v)
    
    if x < y:
        parents[y] = x
    else:
        parents[x] = y

for j in range(m):
    u, v = map(int, input().split())
    
    if find(u) == find(v):
        print(j+1)
        break
    
    union(u, v)
else:
    print(0)