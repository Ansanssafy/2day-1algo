import sys
sys.setrecursionlimit(10**6)

I = sys.stdin.readline

def make_set(x):
    return [i for i in range(x+1)]

def find_set(x):
    if arr[x] != x:
        arr[x] = find_set(arr[x])
    return arr[x]

def union(x, y):
    rootX = find_set(x)
    rootY = find_set(y)
    
    if rootX != rootY:
        if arr[rootX] <= arr[rootY]:
            arr[rootY] = rootX
        elif arr[rootX] > arr[rootY]:
            arr[rootX] = rootY

def check_set(x, y):
    rootX = find_set(x)
    rootY = find_set(y)
    
    if rootX == rootY:
        return "YES"
    else:
        return "NO"


N, M = map(int, I().split())

arr = make_set(N)

for _ in range(M):
    check, a, b = map(int, I().split())
    
    if not check:
        union(a, b)

    elif check:
        result = check_set(a, b)
        print(result)
