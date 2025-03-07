import sys

I = sys.stdin.readline

N = int(I())
arr = set()


for i in range(N):
    lst = list(I().split())
    if len(lst) == 2:
        a, b = lst[0], int(lst[1])
    else:
        a = lst[0]
    
    if a == 'add':
        arr.add(b)
    elif a == 'remove':
        if b in arr:
            arr.remove(b)
    elif a == 'check':
        if b in arr:
            print(1)
        else:
            print(0)
    elif a == 'toggle':
        if b not in arr:
            arr.add(b)
        else:
            arr.remove(b)
    elif a == 'all':
        arr = {i for i in range(1, 21)}
    elif a == 'empty':
        arr = set()
