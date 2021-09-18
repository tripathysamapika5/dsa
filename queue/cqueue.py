class CQueue:
    def __init__(self, capacity):
        self.__rear = -1
        self.__front = -1
        self.__size = 0
        self.__capacity = capacity
        self.__cqueue = [None]*capacity
        
    def isFull(self):
        """ isFull method checks if the Circular Queue is full """
        return (self.__front == 0 and self.__rear + 1 == self.__capacity ) or (self.__front == self.__rear+1)
    
    def isEmpty(self):
        """This method checks if the  Circular Queue is empty"""
        return (self.__front == -1 and self.__rear == -1)

    def enqueue(self, item):
        """This menthod will insert elements to the Circular Queue"""
        if self.isFull():
            print("Queue is full. Enqueue operation cant be performed")
        else:
            if self.isEmpty():
                self.__front += 1
            self.__rear = (self.__rear + 1) % self.__capacity
            self.__cqueue[self.__rear] = item
            self.__size += 1
            print("Inserted : {}".format(item))
    
    def dequeue(self):
        """This method removes a element from the front of the circular queue if it is non empty"""
        if self.isEmpty():
            print("Queue is empty. Dqueue operation cant be performed")
        else:
            temp = self.__cqueue[self.__front]
            self.__size -= 1
            if self.__front == self.__rear:
                self.__front = -1
                self.__rear = -1
            else:
                self.__front = (self.__front + 1) % self.__capacity
                
            print("Removed : {}".format(temp))
            return temp
        
    def peek(self):
        """This method returns a element from the front of the circular queue if it is non empty"""
        if self.isEmpty():
            print("Queue is empty. Peek operation cant be performed")
        else:
            return self.__cqueue[self.__front]
 
                
    def size(self):
        """This menthod returns the size of the circular queue"""
        return self.__size
    
    def display(self):
        if self.isEmpty():
            print("Queue is empty. Nothing is there to display")
        else:
            if self.__front <= self.__rear:
                print('CQueue : {}'.format(', '.join([str(item) for item in self.__cqueue[self.__front : self.__rear+1]])))
            else:
                print('CQueue : {}'.format(', '.join([str(item) for item in self.__cqueue[self.__front : self.__capacity] + self.__cqueue[0 : self.__rear+1]   ])))


if __name__ == '__main__':
    cqueue = CQueue(5)
    cqueue.enqueue(-2);
    cqueue.enqueue(5);
    cqueue.display();
    print(cqueue.peek());
    print(cqueue.size());
    cqueue.enqueue(6);
    print(cqueue.size());        
    cqueue.display();
    cqueue.dequeue();
    cqueue.display();
    print(cqueue.peek());
    print(cqueue.size());
    
    cqueue.dequeue();
    cqueue.dequeue();
    cqueue.dequeue(); 
    cqueue.display();
    print(cqueue.peek());
    print(cqueue.size());
    
    cqueue.enqueue(5);
    cqueue.enqueue(10);
    cqueue.enqueue(15);
    cqueue.dequeue();
    cqueue.dequeue();
    cqueue.enqueue(20);
    cqueue.enqueue(25);
    cqueue.enqueue(30);
    cqueue.enqueue(35);
    cqueue.display();
    print(cqueue.peek());
    print(cqueue.size());
    cqueue.enqueue(99);
