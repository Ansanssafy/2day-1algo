import sys, heapq

class DualPriorityQueue:
    def __init__(self):
        self.min_heap = []
        self.max_heap = []
        self.entry_map = {}


    def insert(self, value):
        heapq.heappush(self.min_heap, value)
        heapq.heappush(self.max_heap, -value)
        if value in self.entry_map:
            self.entry_map[value] += 1
        else:
            self.entry_map[value] = 1
    
    def remove_min(self):
        while self.min_heap:
            min_val = heapq.heappop(self.min_heap)
            if self.entry_map[min_val] > 0:
                self.entry_map[min_val] -= 1
                break
        
    def remove_max(self):
        while self.max_heap:
            max_val = -heapq.heappop(self.max_heap)
            if self.entry_map[max_val] > 0:
                self.entry_map[max_val] -= 1
                break
    
    def get_min(self):
        while self.min_heap:
            min_val = self.min_heap[0]
            if self.entry_map[min_val] > 0 :
                return min_val
            else:
                heapq.heappop(self.min_heap)  # 무효화된 값은 pop
        else:
            return "EMPTY"
        
    def get_max(self):
        while self.max_heap:
            max_val = -self.max_heap[0]
            if self.entry_map[max_val] > 0 :
                return max_val
            else:
                heapq.heappop(self.max_heap)  # 무효화된 값은 pop
        else:
            return "EMPTY"
    

I = sys.stdin.readline

T = int(I())

for tc in range(T):
    que = DualPriorityQueue()
    
    k = int(I())
    
    for i in range(k):
        a, b = map(str, I().split())
        
        if a == "I":
            que.insert(int(b))
        elif a == "D":
            if b == "-1":
                que.remove_min()
            else:
                que.remove_max()
                
    min_val = que.get_min()
    if min_val == "EMPTY":
        print(min_val)
    else:
        max_val = que.get_max()
        print(max_val, min_val)