from collections import deque

N, M, V = map(int, input().split())

arr = [[] for _ in range(N+1)]

for i in range(M):
    a, b = map(int, input().split())
    arr[a].append(b)
    arr[b].append(a)

dfs_visited = [True] + [False]*N
bfs_visited = [True] + [False]*N

def dfs(s):
    dfs_visited[s] = True
    print(s, end= ' ')

    for i in sorted(arr[s]):
        if not dfs_visited[i]:
            dfs(i)
dfs(V)
print()

def bfs(s):
    q = deque([])
    q.append(s)
    bfs_visited[s] = True

    while q:
        ss = q.popleft()
        print(ss, end=' ')

        for j in sorted(arr[ss]):
            if not bfs_visited[j]:
                bfs_visited[j] = True
                q.append(j)
bfs(V)
