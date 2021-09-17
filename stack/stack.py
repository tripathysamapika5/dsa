class  Stack:
    def __init__(self, capacity):
        self.capacity = capacity
        self.stack = []
        self.top = -1
    def isFull(self):
        if self.top == self.capacity - 1:
            return True
        else:
            return False
    
    def isEmpty(self):
        if  self.top == -1:
            return True
        else:
            return False
    def push(self, item):
        if self.isFull():
            print("Stack is Full. Elements cant be pushed...")
        else:
            self.stack.append(item)
            self.top += 1
    def pop(self):
        if self.isEmpty():
            print("Stack is Empty. Pop operation cant be performed...")
        else:
            temp = self.stack[self.top]
            del self.stack[self.top]
            self.top -= 1
            return temp
        
    def size(self):
        return self.top + 1
    
    def peek(self):
        if self.isEmpty():
            print("Stack is empty...")
        else:
            return self.stack[self.top]
    
    def printStack(self):
        print("Elements in stack: ")
        for elem in self.stack:
            print(elem)

if __name__ == "__main__":
    stk = Stack(5)
    print(stk.peek())
    print('pop',stk.pop())
    stk.push(-2)
    stk.push(5)
    stk.printStack()
    print(stk.peek())
    stk.pop()
    stk.printStack()
    stk.push(10)
    stk.push(15)
    stk.push(20)
    stk.push(25)
    stk.printStack()
    print(stk.peek())
    stk.push(30)





    
    
    
