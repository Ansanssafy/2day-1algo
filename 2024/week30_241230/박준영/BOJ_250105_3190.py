import sys
from collections import deque

input = sys.stdin.readline

N = int(input()) # 보드 크기
K = int(input()) # 사과 개수

board = [[0] * N for _ in range(N)]
for _ in range(K):
    y, x = map(int, input().split())
    board[y-1][x-1] = 1 # 사과 위치

L = int(input())
dir = deque()
for _ in range(L):
    t, d = input().split()
    dir.append((int(t), d))

dy = [0, 1, 0, -1]
dx = [1, 0, -1, 0]

time = 0
cur_dir = 0
snake = deque([(0, 0)])
board[0][0] = 2

while True:
    time += 1

    head_y, head_x = snake[-1]
    ny = head_y + dy[cur_dir]
    nx = head_x + dx[cur_dir]

    if not (0 <= ny < N and 0 <= nx < N) or board[ny][nx] == 2:
        break

    if board[ny][nx] == 1:
        board[ny][nx] = 2
        snake.append((ny, nx))
    else:
        board[ny][nx] = 2
        snake.append((ny, nx))
        tail_y, tail_x = snake.popleft()
        board[tail_y][tail_x] = 0

    if dir and time == dir[0][0]:
        _, turn = dir.popleft()
        if turn == 'L':
            cur_dir = (cur_dir - 1) % 4
        elif turn == 'D':
            cur_dir = (cur_dir + 1) % 4

print(time)
