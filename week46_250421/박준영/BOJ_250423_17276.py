import sys
input = sys.stdin.readline

def rotation(arr, n, d):
    times = (abs(d) // 45) % 8

    if times == 0:
        return arr

    mid = n // 2
    pos = [(i, i) for i in range(n)] + [
        (i, mid) for i in range(n)] + [
        (i, n - 1 - i) for i in range(n)] + [
        (mid, i) for i in range(n)
    ]

    for _ in range(abs(times)):
        tmp = [arr[x][y] for (x, y) in pos]
        if d > 0:
            tmp = tmp[-n:] + tmp[:-2*n] + tmp[-2*n:-n][::-1]
        else:
            tmp = tmp[n:2*n] + tmp[2*n:3*n] + tmp[3*n:][::-1] + tmp[:n]

        for i, (x, y) in enumerate(pos):
            arr[x][y] = tmp[i]

    return arr

T = int(input())

for _ in range(T):
    n, d = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(n)]
    
    result = rotation(arr, n, d)
    
    for row in result:
        print(*row)
