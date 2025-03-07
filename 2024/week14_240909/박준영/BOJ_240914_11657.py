import sys
I = sys.stdin.readline

def bellmanFord(start):
    # 시작 노드에 대해서 초기화
    dist[start] = 0
    
    # 전체 N번의 반복
    for i in range(N):
        # 매 반복마다 모든 간선을 확인
        for j in range(M):
            cur = edges[j][0]
            next_node = edges[j][1]
            cost = edges[j][2]

            # 현재 간선을 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
            if dist[cur] != float('inf') and dist[next_node] > dist[cur] + cost:
                dist[next_node] = dist[cur] + cost
                
                # N 번째 라운드에서도 값이 갱신된다면 음수 순환이 존재
                if i == N-1:
                    return True
    return False

# 노드의 개수, 간선의 개수를 입력 받기
N, M = map(int, I().split())

# 모든 간선에 대한 정보를 담는 리스트 만들기
edges = []

# 최단 거리 테이블을 모두 무한으로 초기화
dist = [float('inf')] * (N+1)

# 모든 간선 정보를 입력받기
for _ in range(M):
    a, b, c = map(int, I().split())
    # a번 노드에서 b번 노드로 가는 비용이 c
    edges.append((a, b, c))

# 밸만-포드 알고리즘 수행
negative_cycle = bellmanFord(1)

if negative_cycle:
    print(-1)
else:
    # 1번 노드를 제외한 다른 모든 노드로 가기 위한 최단 거리 출력
    for i in range(2, N+1):
        # 도달할 수 없는 경우, -1을 출력
        if dist[i] == float('inf'):
            print(-1)
        else:
            print(dist[i])