import sys
input = sys.stdin.readline

K = int(input())

n, num, rank = 0, 0, 0

while True:
    n += 1
    num += 2**n

    if num >= K:
        rank = K - (num - 2**n)
        break

result = ''

s, e = 1, 2**n
for i in range(n):
    middle = (s + e) // 2
    
    if rank > middle:
        result += '7'
        s = middle + 1
    else:
        result += '4'
        e = middle - 1

print(result)