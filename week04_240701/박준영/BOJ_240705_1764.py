import sys

I = sys.stdin.readline

N, M = map(int, I().split())

listen = []
shows = set()

for i in range(N):
    listen.append(I().strip())

for j in range(M):
    shows.add(I().strip())

people = []

for p in listen:
    if p in shows:
        people.append(p)

print(len(people))
for q in sorted(people):
    print(q)