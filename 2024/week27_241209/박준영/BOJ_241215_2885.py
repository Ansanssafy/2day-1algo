N = int(input())

k = 0
while (1 << k) < N:
    k += 1

cho = 1 << k
remain = cho
cnt = 0

while N > 0:
    if N >= remain:
        N -= remain
    else:
        remain //= 2
        cnt += 1

print(cho, cnt)
