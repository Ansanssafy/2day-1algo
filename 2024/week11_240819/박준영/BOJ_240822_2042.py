class SegmentTree:
    def __init__(self, data):
        self.n = len(data)
        self.tree = [0] * (self.n * 3)
        
        self.build(data)
    
    def build(self, data):
        for i in range(self.n):
            self.tree[self.n + i] = data[i]
        
        for j in range(self.n-1, 0, -1):
            self.tree[j] = self.tree[2 * j] + self.tree[2 * j + 1]
    
    def partial_sum(self, l, r):
        l += self.n
        r += self.n
        
        sum = 0
        
        while l < r:
            if l & 1:
                sum += self.tree[l]
                l += 1
            
            if r & 1:
                r -= 1
                sum += self.tree[r]
            
            l //= 2
            r //= 2
            
        return sum
    
    def num_change(self, idx, num):
        idx += self.n
        self.tree[idx] = num
        
        i = idx
        while i > 1:
            self.tree[i // 2] = self.tree[i] + self.tree[i ^ 1]
            i //= 2

import sys
I = sys.stdin.readline

N, M, K = map(int, I().split())

arr = [int(I()) for i in range(N)]

segment_tree = SegmentTree(arr)

for i in range(M+K):
    a, b, c = map(int, I().split())
    
    if a == 1:
        segment_tree.num_change(b-1, c)
    elif a == 2:
        result = segment_tree.partial_sum(b-1, c)
        print(result)
