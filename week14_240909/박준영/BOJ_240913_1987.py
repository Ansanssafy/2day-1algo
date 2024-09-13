import sys
I = sys.stdin.readline

R, C = map(int, I().split())

arr = [I().strip() for _ in range(R)]
dirs = [(0,1), (0,-1), (1,0), (-1,0)]
max_cnt = 0
visited = [False] * 26
visited[ord(arr[0][0])-ord('A')] = True

def dfs(x, y, cnt):
    global max_cnt
    max_cnt = max(cnt, max_cnt)
    
    for d in dirs:
        nx, ny = x + d[0], y + d[1]
        if 0 <= nx < R and 0 <= ny < C:
            idx = ord(arr[nx][ny])-ord('A')
            if not visited[idx]:
                visited[idx] = True
                dfs(nx, ny, cnt + 1)
                visited[idx] = False

dfs(0, 0, 1)

print(max_cnt)