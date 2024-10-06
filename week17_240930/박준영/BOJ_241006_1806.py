import sys
input = sys.stdin.readline

N, S = map(int, input().split())
arr = list(map(int, input().split()))

s, e = 0, 0
current_sum = 0
min_length = float('inf')

while True:
    if current_sum >= S:
        min_length = min(min_length, e - s)
        current_sum -= arr[s]
        s += 1
    elif e == N:
        break
    else:
        current_sum += arr[e]
        e += 1

if min_length == float('inf'):
    print(0)
else:
    print(min_length)
