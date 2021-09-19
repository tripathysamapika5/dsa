class Deque:
    def __init__(self, capacity):
        """ This is the constructor to initialize the private attributes of the class """
        self.__front = -1
        self.__rear = -1
        self.__size = 0
        self.__deque = [None] * capacity
        self.__capacity = capacity
    
    def isFull(self):
        """This method checks if the deque is full or not"""
        return (self.__front == 0 and self.__rear == self.__capacity - 1) or (self.__front == self.__rear + 1)
    
    def isEmpty(self):
        """This method checks if the deque is empty or not"""
        return self.__front == -1 and self.__rear == -1
    
    def insertFront(self, item):
        """This method inserts elemnts at the front of the deque"""
        if self.isFull():
            print("Overflow")
        else:
            if self.isEmpty():
                self.__front = 0
                self.__rear = 0
                
            elif self.__front == 0:
                self.__front = self.__capacity - 1
            else:
                self.__front -= 1
            
            self.__deque[self.__front] = item
            self.__size += 1
            print("Inserted at front : {}".format(item))    
                    
    def insertRear(self, item):
        """This method inserts elemnts at the rear of the deque"""
        if self.isFull():
            print("Overflow")
        else:
            if self.isEmpty():
                self.__front = 0
                self.__rear = 0
            elif self.__rear == self.__capacity - 1:
                self.__rear = 0
            else:
                self.__rear += 1
            
            self.__deque[self.__rear] = item
            self.__size += 1
            print("Inserted at rear : {}".format(item))            

    def deleteFront(self):
        """This method removes elemnts from the front of the deque"""
        if self.isEmpty():
            print("Underflow")
        else:
            temp = self.__deque[self.__front]
            if self.__front == self.__rear:
                self.__front = -1
                self.__rear = -1
            elif self.__front == self.__capacity - 1:
                self.__front = 0
            else:
                self.__front += 1
                    
            self.__size -= 1
            print("Removed from front : {}".format(temp))    
            return temp        

    def deleteRear(self):
        """This method removes elemnts from the rear of the deque"""
        if self.isEmpty():
            print("Underflow")
        else:
            temp = self.__deque[self.__rear]
            if self.__front == self.__rear:
                self.__front = -1
                self.__rear = -1
            elif self.__rear == 0:
                self.__rear = self.__capacity - 1
            else:
                self.__rear -= 1
                    
            self.__size -= 1
            print("Removed from rear : {}".format(temp))    
            return temp        

    def getFront(self):
        """This method to return the front element of the deque"""
        if self.isEmpty():
            print("Underflow")
        else:
            return self.__deque[self.__front]

    def getRear(self):
        """This method to return the rear element of the deque"""
        if self.isEmpty():
            print("Underflow")
        else:
            return self.__deque[self.__rear]
        
    def size(self):
        """This method returns the size of the deque"""
        return self.__size
    
    def display(self):
        """This method displays the elements of the deque"""
        if self.isEmpty():
            print("Underflow")
        elif self.__front <= self.__rear:
            i = self.__front
            final_string = "Deque :"
            while(i <= self.__rear):
                final_string = "{} {},".format(final_string, self.__deque[i])
                i += 1
            print(final_string[:-1])
        else:
            i = self.__front
            final_string = "Deque : {}, ".format(self.__deque[i])
            while(i != self.__rear):
                i = (i + 1) % self.__capacity
                final_string = "{} {},".format(final_string, self.__deque[i])
            print(final_string[:-1])

    

if __name__ == '__main__':
    deque = Deque(5);
    print("front element : ",deque.getFront())
    print("rear element : ",deque.getRear())
    print("delete front ", deque.deleteFront())
    print("delete rear  ", deque.deleteRear())   
    print("size  ", deque.size())   
    deque.display()
    
    deque.insertRear(5);
    deque.insertRear(10);
    deque.insertRear(15);
    print("front element : ",deque.getFront())
    print("rear element : ",deque.getRear())
    print("size :  ", deque.size())   
    deque.display()
    
    deque.deleteFront();
    deque.deleteFront();
    print("front element : ",deque.getFront())
    print("rear element : ",deque.getRear())
    print("size :  ", deque.size())   
    deque.display()
    
    deque.insertFront(20);
    deque.insertFront(25);
    deque.insertFront(30);
    deque.insertFront(35);   
    print("front element : ",deque.getFront())
    print("rear element : ",deque.getRear())
    print("size :  ", deque.size())   
    deque.display()
    
    deque.deleteFront();
    deque.deleteRear();

    print("front element : ",deque.getFront())
    print("rear element : ",deque.getRear())
    print("size :  ", deque.size())   
    deque.display()
