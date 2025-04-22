import sys
input = sys.stdin.readline

N = int(input())
answer = list(map(int, input().split()))
arr = [i for i in range(1, N+1)]

def mix(lst, K):
    def recursive(now, i):
        if i > K + 1:
            return now

        if i == 1:
            cnt = 2**K
        else:
            cnt = 2**(K-i+1)

        size = len(now)
        next_part = now[size-cnt:]
        rest = now[:size-cnt]

        return recursive(next_part, i+1) + rest

    return recursive(lst, 1)

for K1 in range(1, 11):
    for K2 in range(1, 11):
        temp = mix(arr, K1)
        temp = mix(temp, K2)
        if temp == answer:
            print(K1, K2)
            sys.exit(0)
