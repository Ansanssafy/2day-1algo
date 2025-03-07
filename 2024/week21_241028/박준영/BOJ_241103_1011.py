import sys
input = sys.stdin.readline


def min_moves(x, y):
    distance = y - x
    max_move = int(distance ** 0.5)

    if max_move ** 2 == distance:
        return 2 * max_move - 1
    elif max_move ** 2 < distance <= max_move * (max_move + 1):
        return 2 * max_move
    else:
        return 2 * max_move + 1

N = int(input())

for i in range(N):
    x, y = map(int, input().split())
    print(min_moves(x, y))