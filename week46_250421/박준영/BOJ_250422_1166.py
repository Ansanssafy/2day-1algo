import sys
input = sys.stdin.readline

N, L, W, H = map(int, input().split())
s, e = 0, min(L, W, H)

for i in range(10000):
    mid = (s + e) / 2
    
    cnt = (L//mid) * (W//mid) * (H//mid)
    
    if cnt >= N:
        s = mid
    else:
        e = mid

print(f'{s:.15f}')