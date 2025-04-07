import sys
input = sys.stdin.readline

laser = input().strip()
c_stack = 0
result = 0
flag = 0
for w in laser:
    if '(' == w:
        c_stack += 1
        
        flag = 0
    elif ')' == w:
        if flag:
            c_stack -= 1
            result += 1
            continue
        c_stack -= 1
        result += c_stack
        
        flag = 1

print(result)