import sys
input = sys.stdin.readline
dir = [(1,0), (-1,0), (0,1), (0,-1)]

# 배열 받기
R, C, T = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(R)]

# 공기청정기 위치찾기
top_air = None
btm_air = None
for i in range(R):
    if arr[i][0] == -1:
        if top_air == None:
            top_air = [i, 0]
        else:
            btm_air = [i, 0]
            break

# 먼지 확산 시뮬레이션
def diffusion():
    copy_arr = [[0] * C for _ in range(R)]
    
    for i in range(R):
        for j in range(C):
            if arr[i][j] > 4:
                check_diff = 0 # 확산된 숫자 체크
                diff_dust = arr[i][j] // 5  # 확산량
                for d in dir:
                    ni, nj = d[0]+i, d[1]+j
                    if 0<=ni<R and 0<=nj<C and arr[ni][nj] != -1:
                        check_diff += 1
                        copy_arr[ni][nj] += diff_dust
                arr[i][j] -= check_diff * diff_dust
    
    for i in range(R):
        for j in range(C):
            arr[i][j] += copy_arr[i][j]

# 공기청정기 작동 시뮬레이션
top_dir = [(0, 1), (-1, 0), (0, -1), (1, 0)]
btm_dir = [(0, 1), (1, 0), (0, -1), (-1, 0)]
def move_air(point, directions):
    s = [point[0], 0]
    s_move = 0
    affter_dust = 0

    while True:
        nr, nc = s[0] + directions[s_move][0], s[1] + directions[s_move][1]
        if not (0 <= nr < R and 0 <= nc < C):
            s_move += 1
            continue
        if arr[nr][nc] == -1:
            break
        before_dust = arr[nr][nc]
        arr[nr][nc] = affter_dust
        affter_dust = before_dust
        s = [nr, nc]

for i in range(T):
    diffusion()
    move_air(top_air, top_dir)
    move_air(btm_air, btm_dir)

total_dust = 0
for i in range(R):
    total_dust += sum(arr[i])

print(total_dust + 2)