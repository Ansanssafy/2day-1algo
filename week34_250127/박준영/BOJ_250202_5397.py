import sys
input = sys.stdin.readline

class Node:
    def __init__(self, data=None):
        self.data = data
        self.prev = None
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = Node()
        self.cursor = self.head
    
    def insert(self, data):
        new_node = Node(data)
        new_node.prev = self.cursor
        new_node.next = self.cursor.next
        
        if self.cursor.next:
            self.cursor.next.prev = new_node
        
        self.cursor.next = new_node
        self.cursor = new_node
    
    def delete(self):
        if self.cursor != self.head:
            self.cursor.prev.next = self.cursor.next
            
            if self.cursor.next:
                self.cursor.next.prev = self.cursor.prev
            
            self.cursor = self.cursor.prev
    
    def move_left(self):
        if self.cursor != self.head:
            self.cursor = self.cursor.prev
    
    def move_right(self):
        if self.cursor.next:
            self.cursor = self.cursor.next
    
    def solve(self):
        arr = ''
        word = self.head.next
        
        while word:
            arr += word.data
            word = word.next
        
        return arr

T = int(input())

for tc in range(T):
    L = input().strip()
    linkedList = LinkedList()
    
    for word in L:
        if word == '<':
            linkedList.move_left()
        elif word == '>':
            linkedList.move_right()
        elif word == '-':
            linkedList.delete()
        else:
            linkedList.insert(word)
    
    print(linkedList.solve())