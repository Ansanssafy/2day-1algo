import sys
input = sys.stdin.readline

N, M = map(int, input().split())

train = [0] * N

for _ in range(M):
    order = list(map(int, input().split()))
    
    if order[0] == 1:
        i, x = order[1] -1, order[2] -1
        train[i] |= (1<<x)
    elif order[0] == 2:
        i, x = order[1] -1, order[2] -1
        train[i] &= ~(1<<x)
    elif order[0] == 3:
        i = order[1] -1
        train[i] <<= 1
        train[i] &= (1<<20) -1
    elif order[0] == 4:
        i = order[1] -1
        train[i] >>= 1

pass_train = set(train)
print(len(pass_train))