import sys

I = sys.stdin.readline
T = 0

while True:
    T += 1
    N = int(I())
    if N == 0:
        break
    arr = []
    cnt = 0
    for i in range(N):
        a, b = map(str, I().split())
        if len(arr) == 0:
            arr.append({a, b})
        else:
            for j in range(len(arr)):
                if a in arr[j] or b in arr[j]:
                    if a in arr[j] and b in arr[j]:
                        cnt += 1
                    else:
                        arr[j].add(a)
                        arr[j].add(b)
                    break
            else:
                arr.append({a, b})
    print(T, cnt)