import sys

def heappush(heap, value):
    heap.append(value)
    idx = len(heap) - 1
    
    while idx > 0:
        parent_idx = (idx - 1) // 2
        if heap[idx] < heap[parent_idx]:
            heap[idx], heap[parent_idx] = heap[parent_idx], heap[idx]
            idx = parent_idx
        else:
            break

def heappop(heap):
    if len(heap) == 0:
        return 0
    
    smallheap = heap[0]
    
    if len(heap) == 1:
        heap.pop()
        return smallheap
    
    
    heap[0] = heap.pop()
    idx = 0
    length = len(heap)
    
    while True:
        left_child_idx = 2 * idx + 1
        right_child_idx = 2 * idx + 2
        small_idx = idx
        
        if left_child_idx < length and heap[left_child_idx] < heap[small_idx]:
            small_idx = left_child_idx
        
        if right_child_idx < length and heap[right_child_idx] < heap[small_idx]:
            small_idx = right_child_idx
        
        if small_idx == idx:
            break
        
        heap[idx], heap[small_idx] = heap[small_idx], heap[idx]
        idx = small_idx
        
    return smallheap

I = sys.stdin.readline

N = int(I())
heap = []

for i in range(N):
    a = int(I())
    
    if a == 0:
        print(heappop(heap))
    else:
        heappush(heap, a)

