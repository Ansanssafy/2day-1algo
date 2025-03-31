import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = [list(map(int, list(input().strip()))) for _ in range(N)]
max_sum = 0

for bit in range(1 << (N*M)):
    total = 0
    
    for i in range(N):
        row_sum = 0
        for j in range(M):
            idx = i*M + j
            if bit & (1 << idx):
                row_sum = row_sum * 10 + arr[i][j]
            else:
                total += row_sum
                row_sum = 0
        total += row_sum
    
    for j in range(M):
        col_sum = 0
        for i in range(N):
            idx = i*M + j
            if not (bit & (1 << idx)):
                col_sum = col_sum * 10 + arr[i][j]
            else:
                total += col_sum
                col_sum = 0
        total += col_sum
    
    max_sum = max(max_sum, total)

print(max_sum)
