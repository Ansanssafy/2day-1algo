import sys
input = sys.stdin.readline

def recur(str):
    if len(str) == 1:
        return str
    word = recur('-'*(len(str)//3)) + ' '*(len(str)//3) + recur('-'*(len(str)//3))
    return word

while True:
    try:
        N = int(input())
        word = '-' * 3**N
        print(recur(word))
    except:
        break

