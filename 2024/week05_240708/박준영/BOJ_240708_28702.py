A = input()
B = input()
C = input()

check = 0

try:
    if int(A):
        check += 1
except:
    try:
        if int(B):
            check += 2
    except:
        try:
            if int(C):
                check += 3
        except:
            pass

num = 0

if check == 1:
    num = int(A) + 3
elif check == 2:
    num = int(B) + 2
elif check == 3:
    num = int(C) + 1

if num % 5 == 0 and num % 3 == 0:
    print('FizzBuzz')
elif num % 5 == 0:
    print('Buzz')
elif num % 3 == 0:
    print('Fizz')
else:
    print(num)