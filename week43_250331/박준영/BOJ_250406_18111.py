import sys
from collections import Counter

input = sys.stdin.readline

N, M, B = map(int, input().split())

height_counter = Counter()
for _ in range(N):
    height_counter.update(map(int, input().split()))

min_h = min(height_counter)
max_h = max(height_counter)

best_time = float('inf')
best_height = -1

for target_h in range(min_h, max_h + 1):
    remove, add = 0, 0
    for h, count in height_counter.items():
        if h > target_h:
            remove += (h - target_h) * count
        else:
            add += (target_h - h) * count

    if remove + B >= add:
        time = remove * 2 + add
        if time < best_time or (time == best_time and target_h > best_height):
            best_time = time
            best_height = target_h

print(best_time, best_height)
