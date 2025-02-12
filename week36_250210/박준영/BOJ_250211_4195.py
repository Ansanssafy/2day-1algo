import sys
input = sys.stdin.readline

T = int(input())

def find(x):
    if parents[x] != x:
        parents[x] = find(parents[x])
        
    return parents[x]

def union(u, v):
    x = find(u)
    y = find(v)
    
    if x != y:
        parents[y] = x
        size[x] += size[y]
    
    return size[x]

for tc in range(T):
    F = int(input())
    parents = {}
    size = {}
    
    idx = 0
    
    name_to_id = {}
    
    for _ in range(F):
        f1, f2 = input().split()
        
        if f1 not in name_to_id:
            name_to_id[f1] = idx
            parents[idx] = idx
            size[idx] = 1
            idx += 1
        
        if f2 not in name_to_id:
            name_to_id[f2] = idx
            parents[idx] = idx
            size[idx] = 1
            idx += 1
        
        print(union(name_to_id[f1], name_to_id[f2]))