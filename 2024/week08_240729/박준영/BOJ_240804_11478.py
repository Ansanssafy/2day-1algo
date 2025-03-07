import sys

I = sys.stdin.readline

word = I().strip()

lst = set()

for i in range(len(word)):
    for j in range(len(word)-i):
        if word[i:i+j+1] not in lst:
            lst.add(word[i:i+j+1])

print(len(lst))