from collections import deque

N, K = map(int, input().split())

def bfs(N, K):
    queue = deque([(N, 0)])  # (현재 위치, 시간)
    visited = set()  # 방문한 노드를 기록

    while queue:
        current, time = queue.popleft()

        if current == K:
            return time

        if current not in visited:
            visited.add(current)

            if current <= K + 1:
                queue.append((2 * current, time))
            if current >= 0:
                queue.append((current - 1, time + 1))
            if current <= K + 1:
                queue.append((current + 1, time + 1))

min_value = bfs(N, K)
print(min_value)