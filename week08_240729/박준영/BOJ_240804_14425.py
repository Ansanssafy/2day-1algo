import sys

I = sys.stdin.readline

N, M = map(int, I().split())

S = {I().strip() for i in range(N)}

cnt = 0

for j in range(M):
    if I().strip() in S:
        cnt += 1

print(cnt)