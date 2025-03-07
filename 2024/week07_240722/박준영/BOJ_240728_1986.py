import sys
I = sys.stdin.readline

n, m = map(int, I().split())
Q, *Q_point = list(map(int, I().split())) # 3
K, *K_point = list(map(int, I().split())) # 2
P, *P_point = list(map(int, I().split())) # 1

arr = [[0]*m for _ in range(n)]

for p in range(0, len(P_point), 2):
    a, b = P_point[p]-1, P_point[p+1]-1
    arr[a][b] = 1

dir_K = [(1, 2), (1, -2), (-1, 2), (-1, -2), (2, 1), (2, -1), (-2, 1), (-2, -1)]
for k in range(0, len(K_point), 2):
    a, b = K_point[k]-1, K_point[k+1]-1
    arr[a][b] = 2
    
    for d in dir_K:
        da, db = a+d[0], b+d[1]
        if 0 <= da < n and 0 <= db < m:
            if arr[da][db] == 0:
                arr[da][db] = 5

dir_Q = [(0, 1), (0, -1), (1, -1), (1, 0), (1, 1), (-1, -1), (-1, 0), (-1, 1)]
for q in range(0, len(Q_point), 2):
    a, b = Q_point[q]-1, Q_point[q+1]-1
    arr[a][b] = 3
    
    for d in dir_Q:
        for v in range(1, 1001):
            da, db = a+d[0]*v, b+d[1]*v
            if 0 <= da < n and 0 <= db < m:
                if arr[da][db] in {1, 2, 3}:
                    break
                arr[da][db] = 5
            else:
                break

cnt = 0

for i in arr:
    cnt += i.count(0)

print(cnt)