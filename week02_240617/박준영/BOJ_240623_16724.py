N, M = map(int, input().split())

arr = [list(input()) for _ in range(N)]

parent = [i for i in range(M*N)]

dict = {
    'D': (1, 0),
    'U': (-1, 0),
    'L': (0, -1),
    'R': (0, 1),
}

def getParent(num):
    if num == parent[num]:
        return num
    else:
        parent[num] = getParent(parent[num])
        return parent[num]

def unionParent(x, y):
    x_root = getParent(x)
    y_root = getParent(y)
    if x_root != y_root:
        if x_root < y_root:
            parent[y_root] = x_root
        else:
            parent[x_root] = y_root
    return

for num in range(M*N):
    x = num % M
    y = num // M
    move = dict[arr[y][x]]
    a, b = x + move[1], y + move[0]
    next_move = b*M + a
    if next_move < 0 or next_move >= N*M:
        continue
    unionParent(num, next_move)

answer = 0
visited = set()
for i in range(N*M):
    root = getParent(parent[i])  # 각 셀의 루트 노드를 찾음
    if root not in visited:  # 새로운 루트 노드인 경우
        answer += 1
        visited.add(root)
print(answer)