import sys

I = sys.stdin.readline

def find(x):
    if set_trip[x] == x:
        return x
    set_trip[x] = find(set_trip[x])  # 경로 압축
    return set_trip[x]

def union(x, y):
    rootX = find(x)
    rootY = find(y)
    
    if rootX != rootY:  # 루트가 다를 때만 합침
        set_trip[rootY] = rootX

N = int(I())  # 도시 수
M = int(I())  # 여행 계획에 속한 도시들의 수

arr = [list(map(int, I().split())) for _ in range(N)]

trip = list(map(int, I().split()))
set_trip = [i for i in range(N + 1)]  # 도시의 인덱스를 1부터 사용

for i in range(N):
    for j in range(i+1, N):
        if arr[i][j] == 1:
            union(i + 1, j + 1)  # 도시 인덱스를 1부터 사용

base = find(trip[0])
for i in trip:
    if find(i) != base:
        print("NO")
        break
else:
    print("YES")
