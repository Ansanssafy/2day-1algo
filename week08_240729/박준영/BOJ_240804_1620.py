import sys

I = sys.stdin.readline

N, M = map(int, I().split())

dictionary = dict()

num = 0
for i in range(N):
    num += 1
    dictionary[num] = I().strip()
    
dictionary_reverse = dict(map(reversed, dictionary.items()))

for j in range(M):
    value = I().strip()
    try:
        print(dictionary[int(value)])
    except:
        print(dictionary_reverse[value])