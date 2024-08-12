class Dequeue:
    def __init__(self, capacity):
        self.items = [None] * capacity
        self.capacity = capacity
        self.size = 0
        self.left = 0
        self.right = capacity - 1

    def isEmpty(self):
        return self.size == 0
    
    def isFull(self):
        return self.size == self.capacity
    
    def enqueueLeft(self, item):
        if self.isFull():
            return False
        self.items[self.left] = item
        self.left = (self.left - 1 + self.capacity) % self.capacity
        self.size += 1
        return True
    
    def enqueueRight(self, item):
        if self.isFull():
            return False
        self.items[self.right] = item
        self.right = (self.right + 1) % self.capacity
        self.size += 1
        return True
    
    def dequeueLeft(self):
        if self.isEmpty():
            return None
        item = self.items[self.left]
        self.left = (self.left + 1) % self.capacity
        self.size -= 1
        return item

    def dequeueRight(self):
        if self.isEmpty():
            return None
        item = self.items[self.right]
        self.right = (self.right - 1 + self.capacity) % self.capacity
        self.size -= 1
        return item
    
    def peakLeft(self):
        if self.isEmpty():
            return None
        return self.items[self.left]
    
    def peakRight(self):
        if self.isEmpty():
            return None
        return self.items[self.right]
    
if __name__ == "__main__":
    capacity = 5
    dequeue = Dequeue(capacity)
        
    for i in range(3, 8):
        dequeue.enqueueRight(i)

    # [7] [6] [5] [4] [3]
    # right is at index 4 after finish enqueueRight
        
    while not dequeue.isEmpty():
        print(dequeue.dequeueRight(), end=" ")


