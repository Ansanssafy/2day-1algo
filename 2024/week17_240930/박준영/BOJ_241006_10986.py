import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))

lst = [0] * M
lst[0] = 1

sum_number = 0
cnt = 0

for num in arr:
    sum_number += num
    check = sum_number % M
    cnt += lst[check]
    lst[check] += 1

print(cnt)
