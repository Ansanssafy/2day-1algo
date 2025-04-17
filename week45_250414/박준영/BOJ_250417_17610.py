import sys
input = sys.stdin.readline

k = int(input())
weight = list(map(int, input().split()))
result = 0

items = set()
items.add(0)

for w in weight:
    new_item = set()
    for i in items:
        new_item.add(i+w)
        new_item.add(abs(i-w))
    items.update(new_item)

for i in range(1, sum(weight)+1):
    if i not in items:
        result += 1

print(result)