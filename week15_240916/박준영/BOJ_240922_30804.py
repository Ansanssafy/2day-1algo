import sys
from collections import Counter
I = sys.stdin.readline

N = int(I())
arr = list(map(int, I().split()))
fruit = Counter()
result = 0

l, r = 0, 0

while r < N:
    fruit[arr[r]] += 1
    
    while len(fruit) > 2:
        fruit[arr[l]] -= 1
        if fruit[arr[l]] == 0:
            del fruit[arr[l]]
        l += 1
    
    result = max(result, r - l + 1)
    r += 1

print(result)
