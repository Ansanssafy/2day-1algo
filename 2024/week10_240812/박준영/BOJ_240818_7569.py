from collections import deque

def bfs():
    directions = [(1, 0, 0), (-1, 0, 0), (0, 1, 0), (0, -1, 0), (0, 0, 1), (0, 0, -1)]
    while queue:
        z, x, y = queue.popleft()
        for dz, dx, dy in directions:
            nz, nx, ny = z + dz, x + dx, y + dy
            if 0 <= nz < H and 0 <= nx < N and 0 <= ny < M and box[nz][nx][ny] == 0:
                box[nz][nx][ny] = box[z][x][y] + 1
                queue.append((nz, nx, ny))

M, N, H = map(int, input().split())
box = []
queue = deque()

for z in range(H):
    floor = []
    for x in range(N):
        row = list(map(int, input().split()))
        floor.append(row)
        for y in range(M):
            if row[y] == 1:
                queue.append((z, x, y))
    box.append(floor)

bfs()

max_days = 0
for z in range(H):
    for x in range(N):
        for y in range(M):
            if box[z][x][y] == 0:  # 익지 않은 토마토가 남아있으면
                print(-1)
                exit(0)
            max_days = max(max_days, box[z][x][y])

print(max_days - 1)  # 초기 상태가 1이므로 -1을 해줌
