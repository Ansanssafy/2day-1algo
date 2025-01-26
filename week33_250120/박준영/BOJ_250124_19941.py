import sys
input = sys.stdin.readline

N, K = map(int, input().split())
arr = list(input())

visited = [False] * N
cnt = 0

for i in range(N):
    if arr[i] == 'P':
        for j in range(max(0, i-K), min(N, i+K+1)):
            if arr[j] == 'H' and not visited[j]:
                visited[j] = True
                cnt += 1
                break

print(cnt)