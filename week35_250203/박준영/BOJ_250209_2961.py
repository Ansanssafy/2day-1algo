import sys
input = sys.stdin.readline

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

result = float('inf')

for i in range(1, 1 << N):
    total_S = 1
    total_B = 0
    
    for j in range(N):
        if i & (1 << j):
            total_S *= arr[j][0]
            total_B += arr[j][1]
    
    cal = abs(total_B - total_S)
    
    result = min(cal, result)

print(result)