import sys

input = sys.stdin.readline

def dfs(position, total_score):
    global max_score
    
    if position == 11:
        max_score = max(max_score, total_score)
        return
    
    for player in range(11):
        if not visited[player] and arr[player][position] > 0:
            visited[player] = True
            dfs(position + 1, total_score + arr[player][position])
            visited[player] = False

T = int(input())

for _ in range(T):
    arr = [list(map(int, input().split())) for _ in range(11)]
    visited = [False] * 11
    max_score = 0
    dfs(0, 0)
    print(max_score)
