import sys
input = sys.stdin.readline

N, L = map(int, input().split())

for i in range(L, 101):
    K = N - (i*(i-1))//2
    if K % i == 0:
        start = K // i
        if start >=0:
            result = [start + A for A in range(i)]
            print(*result)
            break
else:
    print(-1)