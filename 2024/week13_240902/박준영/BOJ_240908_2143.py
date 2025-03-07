import sys
from collections import Counter

input = sys.stdin.readline

T = int(input())

n = int(input())
arr = list(map(int, input().split()))

sum_a = []
for i in range(n):
    s = 0
    for j in range(i, n):
        s += arr[j]
        sum_a.append(s)

count_a = Counter(sum_a)

m = int(input())
brr = list(map(int, input().split()))

result = 0

for i in range(m):
    s = 0
    for j in range(i, m):
        s += brr[j]
        result += count_a[T - s]

print(result)
