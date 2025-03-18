import sys
input = sys.stdin.readline

N, L, R, X = map(int, input().split())
arr = list(map(int, input().split()))

count = 0

for mask in range(1, 1<<N):
    selected = [arr[i] for i in range(N) if mask & (1<<i)]
    
    if len(selected) < 2:
        continue
    
    total = sum(selected)
    min_value = min(selected)
    max_value = max(selected)
    
    if L <= total <= R and (max_value-min_value) >= X:
        count += 1

print(count)
    