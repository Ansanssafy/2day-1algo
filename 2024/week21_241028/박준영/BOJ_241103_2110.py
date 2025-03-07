import sys
input = sys.stdin.readline

def place_router(arr, d, C):
    cnt = 1
    located_router = arr[0]
    
    for i in range(1, len(arr)):
        if arr[i] - located_router >= d:
            cnt += 1
            located_router = arr[i]
            if cnt >= C:
                return True
    return False

N, C = map(int, input().split())

arr = [int(input()) for _ in range(N)]
arr.sort()
left = 1
right = arr[-1] - arr[0]
result = 0

while left <= right:
    mid = (left + right) // 2
    if place_router(arr, mid, C):
        result = mid
        left = mid + 1
    else:
        right = mid - 1

print(result)