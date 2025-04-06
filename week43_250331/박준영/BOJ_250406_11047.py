import sys
input = sys.stdin.readline
N, K = map(int, input().split())
token = []
result = 0

for _ in range(N):
    token.append(int(input()))
token.sort(reverse=True)

for money in token:
    if K == 0:
        break
    mok, na = divmod(K, money)
    result += mok
    K = na

print(result)