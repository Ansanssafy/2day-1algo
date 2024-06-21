import sys
sys.setrecursionlimit(10**6)

class BinaryTree:
    def __init__(self):
        self.nodes = []

    def insert(self, num):
        self.nodes.append(num)

    def postorder_traversal(self):
        def postorder(start, end):
            if start > end:
                return []
            
            mid = start + 1
            while mid <= end and self.nodes[mid] < self.nodes[start]:
                mid += 1
            
            return postorder(start + 1, mid - 1) + postorder(mid, end) + [self.nodes[start]]
        
        return postorder(0, len(self.nodes) - 1)

bst = BinaryTree()
arr = []

while True:
    try:
        num = int(sys.stdin.readline().strip())
        arr.append(num)
    except:
        break

for num in arr:
    bst.insert(num)

postorder_values = bst.postorder_traversal()
for value in postorder_values:
    print(value)
