class Stack:
    def __init__(self, n):
        self.size = 0
        self.items = [None] * n
    
    # get the size of the stack
    # actually, it is not needed since we can use the self.size to get the size of the stack
    def size(self):
        return self.size 
    
    # check if the stack is empty
    def isEmpty(self):
        return self.size == 0
    
    # push an item to the stack
    def push(self, item):
        if self.size < len(self.items): # check if the stack is full
            self.items[self.size] = item # push the item to the stack
            self.size += 1 # increment the size
            return True
        return False

    # pop an item from the stack
    def pop(self):
        if self.isEmpty(): # check if the stack is empty
            return None
        self.size -= 1 # decrement the size
        return self.items[self.size] # return the popped item
    
    # peek the top item from the stack
    def peek(self):
        if self.isEmpty(): # check if the stack is empty
            return None
        return self.items[self.size - 1] # return the top item
    
if __name__ == "__main__":
    stack = Stack(4)
    stack.push("hello")
    stack.push("world")
    stack.push("from")
    stack.push("RMIT")
    stack.push("Pham Logan") # this will return false since the stack is full
    while not stack.isEmpty():
        print(stack.peek())
        stack.pop()


    