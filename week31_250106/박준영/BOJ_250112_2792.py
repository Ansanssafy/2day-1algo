import sys
input = sys.stdin.readline

N, M = map(int, input().split())
jewelry = [int(input()) for _ in range(M)]

s, e = 1, max(jewelry)
result = e

while s <= e:
    mid = (s + e) // 2
    children = 0
    
    for jewel in jewelry:
        children += (jewel + mid -1) // mid
    
    if children <= N:
        result = mid
        e = mid - 1
    else:
        s = mid + 1

print(result)