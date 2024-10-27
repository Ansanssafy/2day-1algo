import sys

input = sys.stdin.readline

N, M = map(int, input().split())

arr = [int(input()) for i in range(N)]

def minimum_time(M, times):
    left, right = 1, max(times) * M
    result = right
    
    while left <= right:
        mid = (left + right) // 2
        total_people = sum(mid // time for time in times)
        
        if total_people >= M:
            result = mid
            right = mid - 1
        else:
            left = mid + 1
    
    return result

print(minimum_time(M, arr))