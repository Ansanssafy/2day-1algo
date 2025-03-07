import sys

I = sys.stdin.readline

lst = ['***', '* *', '***']

N = int(I())

def recur(n, new_lst):
    if n == N:
        return new_lst
    tmp = []

    for i in range(n):
        tmp.append(new_lst[i] * 3)
    for j in range(n):
        tmp.append(new_lst[j] + ' ' * n + new_lst[j])
    for m in range(n):
        tmp.append(new_lst[m] * 3)

    return recur(n * 3, tmp)

result = recur(3, lst)

for k in result:
    print(k)