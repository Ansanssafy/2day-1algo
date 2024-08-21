import sys
from collections import deque

I = sys.stdin.readline

T = int(I())

for tc in range(T):
    visited = [True] * 10000
    a, b = map(int, I().split())
    visited[a] = False
    
    que = deque([(a, '')])
    
    while que:
        num, str1 = que.popleft()
        
        if num == b:
            print(str1)
            break
        
        # DSLR
        D = (num * 2) % 10000
        S = num - 1 if num != 0 else 9999
        L = (num % 1000) * 10 + num // 1000
        R = (num % 10) * 1000 + num // 10
        
        if visited[D]:
            que.append((D, str1 + "D"))
            visited[D] = False
        if visited[S]:
            que.append((S, str1 + "S"))
            visited[S] = False
        if visited[L]:
            que.append((L, str1 + "L"))
            visited[L] = False
        if visited[R]:
            que.append((R, str1 + "R"))
            visited[R] = False
