class Node:
    def __init__(self, data, left=None, right=None):
        self.data = data
        self.left = left
        self.right = right

def preorder(node):
    if node:
        print(node.data, end='')
        preorder(tree[node.left])
        preorder(tree[node.right])

def inorder(node):
    if node:
        inorder(tree[node.left])
        print(node.data, end='')
        inorder(tree[node.right])

def postorder(node):
    if node:
        postorder(tree[node.left])
        postorder(tree[node.right])
        print(node.data, end='')

n = int(input())
tree = {}

for _ in range(n):
    data, left, right = input().split()
    left = None if left == '.' else left
    right = None if right == '.' else right
    tree[data] = Node(data, left, right)

root = tree['A']  # 루트 노드는 항상 'A'

preorder(root)
print()
inorder(root)
print()
postorder(root)
