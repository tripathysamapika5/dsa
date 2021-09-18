class Queue:
    def __init__(self, capacity):
        self.front, self.rear = -1,-1
        self.capacity = capacity
        self.queue = []
        
    def isFull(self):
        return self.rear + 1 == self.capacity
    
    def isEmpty(self):
        return self.front == -1
    
    def enqueue(self, item):
        if self.isFull():
            print("Queue is full. Enqueue operation cant be performed..");
        else:
            self.queue.append(item)
            self.rear += 1
            if self.isEmpty():
                self.front += 1
        
    def dequeue(self):
        if self.isEmpty():
            print("Queue is empty. And dequeing cant be performed...")
        else:
            self.rear -= 1
            temp = self.queue.pop(0)
            if self.isEmpty():
                self.front = -1
            return temp
    
    def peek(self):
        if self.isEmpty():
            print("Queue is empty. Peek operation cant be performed...")
        else :
            return self.queue[self.front]
        
    def size(self):
        return self.rear + 1
    
    def display(self):
        for item in self.queue:
            print(item)
 
if __name__ == '__main__':
    queue = Queue(5)
    queue.peek()
    queue.dequeue()   
    
    queue.enqueue(5)  
    queue.enqueue(10)  
    queue.dequeue()   
    queue.display()
    print(queue.peek())
    queue.enqueue(15)
    queue.enqueue(20)
    queue.enqueue(25)
    queue.enqueue(30)
    queue.display()
    print(queue.peek())
    queue.enqueue(35)