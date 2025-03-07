import sys

I = sys.stdin.readline

A, B = I().split()
if len(A) >= len(B):
    high, low = A, B
else:
    high, low = B, A

high_len = max(len(A), len(B))
low_len = min(len(A), len(B))

arr = []

for i in range(high_len-low_len):
    arr.append(high[i])

for j in range(high_len-low_len, high_len):
    arr.append(str(int(high[j])+int(low[j-(high_len-low_len)])))

print(''.join(arr))