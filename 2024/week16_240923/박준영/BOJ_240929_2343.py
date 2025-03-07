import sys
input= sys.stdin.readline

def binary(lectures, max_lec):
    cnt = 1
    total = 0
    
    for lecture in lectures:
        if total + lecture > max_lec:
            cnt += 1
            total = lecture
        else:
            total += lecture
    
    return cnt

N, M = map(int, input().split())

arr = list(map(int, input().split()))

l = max(arr)
r = sum(arr)

while l <= r:
    mid = (l + r) // 2
    if binary(arr, mid) <= M:
        r = mid - 1
    else:
        l = mid + 1

print(l)

