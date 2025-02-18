import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))

l, r = 0, max(arr) - min(arr)

def solve(mid):
    cnt = 1
    min_value, max_value = arr[0], arr[0]
    
    for num in arr[1:]:
        min_value = min(min_value, num)
        max_value = max(max_value, num)
        
        if max_value - min_value > mid:
            cnt += 1
            min_value, max_value = num, num
            
            if cnt > M:
                return False
    return True

while l < r:
    mid = (l+r) // 2
    if solve(mid):
        r = mid
    else:
        l = mid + 1

print(l)