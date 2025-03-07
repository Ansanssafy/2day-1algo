import sys
from collections import Counter

I = sys.stdin.readline
N, M = map(int, I().split())
arr = Counter(map(int, I().split()))
# collections 라이브러리의 Counter 클래스 사용
    # Counter는 해시 타입으로 각 요소에 대한 갯수를 카운트 해주는 함수
    # 문자열, 리스트, 튜플 등 반복 가능한 객체를 인수로 받아 각 요소의 개수를 저장
    # 빈 Counter의 객체를 생성하고 나중에 update로 추가도 가능
    # Counter 객체 간의 연산도 가능 => + - & | (덧셈, 뺄셈, 교집합, 합집합)
    # 객체에 most_common 메서드 사용 시 가장 흔한 요소를 찾아줌
    # 객체에 subtract 메서드를 사용하면 특정 요소의 개수를 줄일 수 있음

s = 0
e = max(arr)
result = 0

while s <= e:
    middle = (s + e) // 2
    tree = 0
    for value, count in arr.items():
        if value > middle:
            tree += (value - middle) * count
            if tree > M:
                break
    
    if tree >= M:
        result = middle
        s = middle + 1
    
    else:
        e = middle - 1

print(result)