class ArrayQueue:
    def __init__(self, capacity):
        self.capacity = capacity
        self.queue = [None] * capacity
        self.front = 0
        self.rear = 0
        self.size = 0
        
    def is_empty(self):
        return self.size == 0

    def size(self):
        return self.size

    def isFull(self):
        return self.size == self.capacity

    def enQueue(self, item):
        if self.isFull():
            raise Exception("Queue is full")
        
        self.queue[self.rear] = item
        self.rear = (self.rear + 1) % self.capacity
        self.size += 1
        return True

    def deQueue(self):
        if self.is_empty():
            raise Exception("Queue is empty")
        
        item = self.queue[self.front]
        self.front = (self.front + 1) % self.capacity
        self.size -= 1
        return item

    def peek(self):
        if self.is_empty():
            raise Exception("Queue is empty")
        
        return self.queue[self.front]

if __name__ == "__main__":
    queue = ArrayQueue(10)
    # enqueue 1 to 9
    for i in range(1, 10):
        queue.enQueue(i)
    # dequeue 5 times => should get 1 to 5
    for i in range(5):
        print(queue.deQueue(), end=" ")
    
    for i in range(1, 6):
        queue.enQueue(i)

    print()
    print("---------")
    
    while not queue.is_empty():
        print(queue.deQueue(), end=" ")

        