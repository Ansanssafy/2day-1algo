import sys
input = sys.stdin.readline

N = int(input())

parents = [i for i in range(1000001)]
size = [1] * (1000001)

def find(X):
    if parents[X] != X:
        parents[X] = find(parents[X])
    return parents[X]
    

def union(X, Y):
    X_root = find(X)
    Y_root = find(Y)
    
    if X_root != Y_root:
        parents[Y_root] = X_root
        size[X_root] += size[Y_root]


for _ in range(N):
    order = input().split()    
    
    if order[0] == 'I':
        x, y = map(int, order[1:])
        union(x, y)
    
    elif order[0] == 'Q':
        x = int(order[1])
        print(size[find(x)])