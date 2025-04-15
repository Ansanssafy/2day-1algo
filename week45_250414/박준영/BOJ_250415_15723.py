import sys
input = sys.stdin.readline

N = int(input())
dictionary = dict()

for _ in range(N):
    word = input().strip()
    s, e = word[0], word[-1]
    if s in dictionary:
        dictionary[s].append(e)
    else:
        dictionary[s] = [e]

def solve(s, e, visited=set()):
    if s == e:
        return True
    if s in visited:
        return False
    visited.add(s)
    
    for next_char in dictionary.get(s, []):
        if solve(next_char, e, visited):
            return True
    return False

M = int(input())
for _ in range(M):
    quest = input().strip()
    s, e = quest[0], quest[-1]
    
    if solve(s, e, set()):
        print('T')
    else:
        print('F')
