from collections import deque

N, M = map(int, input().split())

known_fact_person, *person_list = list(map(int, input().split()))

if known_fact_person == 0:
    print(M)
elif N == known_fact_person:
    print(0)
else:
    arr = [list(map(int, input().split()))[1:] for _ in range(M)]
    
    q = deque(person_list)
    
    while q:
        known_person = q.popleft()
        
        for party in arr:
            if known_person in party:
                for i in party:
                    if i not in set(person_list):
                        person_list.append(i)
                        q.append(i)
    
    cnt = 0
    for party in arr:
        if len(person_list) == len(set(person_list) - set(party)):
            cnt += 1
    
    print(cnt)