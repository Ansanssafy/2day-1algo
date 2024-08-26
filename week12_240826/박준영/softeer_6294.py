import sys
I = sys.stdin.readline

N, K = map(int, I().split())

arr = list(map(int, I().split()))

segement_tree = [0] * (2 * N)
for i in range(N):
    segement_tree[N + i] = arr[i]
for j in range(N-1, 0, -1):
    segement_tree[j] = segement_tree[j*2] + segement_tree[j*2 + 1]

for n in range(K):
    result = 0
    l, r = map(int, I().split())
    length = r - l + 1
    l += (N-1)
    r += (N)
    
    while l < r:
        
        if l & 1 :
            result += segement_tree[l]
            l += 1
        if r & 1 :
            r -= 1
            result += segement_tree[r]

        l //= 2
        r //= 2
        
    print(f'{result/length:.2f}')
        
        
