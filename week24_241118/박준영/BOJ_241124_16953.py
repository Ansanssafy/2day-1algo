from collections import deque

def bfs(a, b):
    queue = deque([(a, 1)])
    
    while queue:
        current, count = queue.popleft()
        if current == b:
            return count
        if current * 2 <= b:
            queue.append((current * 2, count + 1))
        if current * 10 + 1 <= b:
            queue.append((current * 10 + 1, count + 1))
    return -1

a, b = map(int, input().split())
result = bfs(a, b)
print(result)
