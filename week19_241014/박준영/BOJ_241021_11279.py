import sys, heapq

input = sys.stdin.readline

N = int(input())
arr = []
for i in range(N):
    num = int(input())
    if num:
        heapq.heappush(arr, -num)
    else:
        if len(arr):
            print(-heapq.heappop(arr))
        else:
            print(0)