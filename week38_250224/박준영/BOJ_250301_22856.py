import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

class Node:
    def __init__(self, num):
        self.mid = num
        self.left = None
        self.right = None
    
N = int(input())
tree = {}

for _ in range(N):
    a, b, c = map(int, input().split())
    
    if a not in tree:
        tree[a] = Node(a)
    
    if b != -1:
        if b not in tree:
            tree[b] = Node(b)
        tree[a].left = tree[b]
    
    if c != -1:
        if c not in tree:
            tree[c] = Node(c)
        tree[a].right = tree[c]

move_cnt = 0

def cnt_move(node, flag):
    global move_cnt
    
    if node.left:
        move_cnt += 2
        cnt_move(node.left, 1)
    
    if node.right:
        move_cnt += 1
        if flag == 0 or node == tree[1]:
            cnt_move(node.right, 0)
        elif flag:
            cnt_move(node.right, flag)
            move_cnt += 1

cnt_move(tree[1], 1)

print(move_cnt)