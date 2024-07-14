import sys

I = sys.stdin.readline

N, M = map(int, I().split())

dictionary = dict()

for i in range(N):
    address, password = map(str, I().split())
    dictionary[address] = password

for j in range(M):
    site = I().strip()
    print(dictionary[site])
