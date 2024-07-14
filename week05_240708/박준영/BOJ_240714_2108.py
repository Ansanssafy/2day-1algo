import sys

I = sys.stdin.readline

N = int(I())

arr = []

for i in range(N):
    arr.append(int(I()))

arr.sort()

# 산술평균
print(round(sum(arr)/N))

# 중앙값
print(arr[N//2])

# 최빈값
dictionary = dict()
for i in arr:
    if i in dictionary:
        dictionary[i] += 1
    else:
        dictionary[i] = 1
max_value = max(dictionary.values())
max_arr = []

for j in dictionary:
    if max_value == dictionary[j]:
        max_arr.append(j)

if len(max_arr) > 1:
    print(max_arr[1])
else:
    print(max_arr[0])

# 범위
print(max(arr)-min(arr))