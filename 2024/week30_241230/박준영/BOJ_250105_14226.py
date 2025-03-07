from collections import deque

S = int(input())

visited = set()
q = deque()
q.append((1, 0, 0)) # 화면이모티콘 개수, 시간, 클립보드 복사 개수

while q:
    screen, time, clipboard = q.popleft()
    
    if screen == S :
        print(time)
        break
    
    if (screen, clipboard) in visited:
        continue
    visited.add((screen, clipboard))
    
    q.append((screen, time+1, screen)) # 클립보드에 복사
    if screen-1 != 0:
        q.append((screen-1, time+1, clipboard)) # 이모티콘 하나 삭제
    q.append((screen + clipboard, time+1, clipboard)) # 클립보드에 있는걸 붙여넣기
