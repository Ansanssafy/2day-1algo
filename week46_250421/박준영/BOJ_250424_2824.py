import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
M = int(input())
B = list(map(int, input().split()))

def gcd(a, b):
    while b > 0 :
        tmp = a % b
        a = b
        b = tmp
    return a


a = 1
b = 1

for i in A:
    a *= i
for j in B:
    b *= j

result = gcd(a, b)

print(str(result)[-9:])