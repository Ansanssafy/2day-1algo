import sys
input = sys.stdin.readline

N = int(input())
village = []
total_people = 0

for _ in range(N):
    x, y = map(int, input().split())
    village.append((x, y))
    total_people += y

village.sort()

acc = 0
for x, y in village:
    acc += y
    if acc >= total_people / 2:
        print(x)
        break
