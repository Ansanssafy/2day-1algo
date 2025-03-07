import sys

input = sys.stdin.readline

N = int(input())

paper = [list(map(int, input().split())) for _ in range(N)]
result = [0, 0, 0]

def check(x, y, n):
    initial = paper[x][y]
    for i in range(x, x + n):
        for j in range(y, y + n):
            if paper[i][j] != initial:
                return False
    return True

def divide(x, y, n):
    if check(x, y, n):
        result[paper[x][y] + 1] += 1
        return
    
    new_n = n // 3
    for i in range(3):
        for j in range(3):
            divide(x + i * new_n, y + j * new_n, new_n)

divide(0, 0, N)

print(result[0])
print(result[1])
print(result[2])