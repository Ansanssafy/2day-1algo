import sys
input = sys.stdin.readline

N = int(input())
arr = sorted(int(input()) for _ in range(N))
max_weight = 0

max_weight = max(arr[i] * (N - i) for i in range(N))

print(max_weight)