import sys
sys.setrecursionlimit(10**5)
input = sys.stdin.readline

def find_lca(a, b, parent, depth):
    while depth[a] > depth[b]:
        a = parent[a]
    while depth[b] > depth[a]:
        b = parent[b]
    
    while a != b:
        a = parent[a]
        b = parent[b]
    
    return a

def solve():
    T = int(input())

    for _ in range(T):
        N = int(input())
        parent = [0] *(N+1)
        depth = [0] * (N+1)
        children = [[] for _ in range(N+1)]
        is_root = [True] * (N+1)
        
        for _ in range(N-1):
            a, b = map(int, input().split())
            parent[b] = a
            children[a].append(b)
            is_root[b] = False

        root = is_root.index(True, 1)
        
        def dfs(node, d):
            depth[node] = d
            for child in children[node]:
                dfs(child, d+1)
        
        dfs(root, 0)
        
        x, y = map(int, input().split())
        print(find_lca(x, y, parent, depth))

solve()