import sys
I = sys.stdin.readline


# #내가 푼 풀이법 1번
# 143264KB / 2216 ms
# N = int(I())

# arr = list(map(int, I().split()))
# _arr = sorted(list(set(arr))) # 정렬된 리스트형태, 중복 없음
# _dict = dict()

# for i in range(len(_arr)):
#     if _arr[i] not in _dict:
#         _dict[_arr[i]] = i

# for j in arr:
#     print(_dict[j], end=' ')

# # 개선 코드 2번
# # 143264 KB / 1896 ms
# # 차이점 : dictionary를 만들 떄 바로 컴프리헨션으로 작성함 (기존 보다 더 빠름)
# N = int(I())

# arr = list(map(int, I().split()))
# _arr = sorted(set(arr)) # sorted를 쓰면 set도 리스트로 바뀜
# _dict = {value:idx for idx, value in enumerate(_arr)}

# for j in arr:
#     print(_dict[j], end=' ')

# # 개선 코드 3번
# # 200576 KB / 1640 ms
# # 차이점 : join을 써서 프린트를 한번만 씀 이러니까 빠르긴한데, 리스트를 하나 더 만들어서 메모리 사용량이 늘었음..
N = int(I())

arr = list(map(int, I().split()))
_arr = sorted(set(arr))
_dict = {value:idx for idx, value in enumerate(_arr)}

arr = [_dict[i] for i in arr]

print(' '.join(map(str, arr)))