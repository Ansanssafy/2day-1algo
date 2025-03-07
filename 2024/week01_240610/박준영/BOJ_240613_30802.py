import sys

N = int(sys.stdin.readline())
size = list(map(int, sys.stdin.readline().split()))
T, P = map(int, sys.stdin.readline().split())

T_num = 0
P_sum, P_num = divmod(N, P)

for i in size:
       a, b = divmod(i, T)
       T_num += a
       if b != 0:
              T_num += 1

print(T_num)
print(P_sum, P_num)

# test