import sys
I = sys.stdin.readline

N, M = map(int, I().split())

arr = list(map(int, I().split()))

arr_i = [0 for _ in range(N+1)]

for _ in range(M):
    a, b, k = map(int, I().split())
    arr_i[a-1] += k
    arr_i[b] -= k

dig = 0

for i in range(N):
    dig += arr_i[i]
    print(arr[i] + dig, end= " ")