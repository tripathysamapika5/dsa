class Node:
    def __init__(self, value):
        self.value = value
        self.prev = None
        self.next = None

class DoublyLinkedList:
    def __init__(self):
        self.__size = 0
        self.__head = None
        self.__tail = None
    
    def insertStart(self, item):
        ''' This method inserts an item at the start of linkedlist'''
        newNode = Node(item)
        if not self.__head:
            self.__head = newNode  
            self.__tail = self.__head
        else:
            newNode.next= self.__head
            self.__head.prev = newNode
            self.__head = newNode
        self.__size += 1
        print("Inserted at start : {}".format(item))
        
    def insertEnd(self, item):
        ''' This method inserts an item at the end of the linked list'''
        newNode = Node(item)
        if not self.__head:
            self.__head = newNode  
            self.__tail = self.__head
        else:
            self.__tail.next = newNode
            newNode.prev = self.__tail
            self.__tail = newNode
        self.__size += 1
        print("Inserted at end : {}".format(item))
        
    def remove(self, item):
        ''' This method removes an node from the linked list if the input matches its data value'''
        if not self.__head:
            print("Underflow")
        elif self.__head == self.__tail and self.__head.value == item:
            self.__head = None
            self.__tail = None
            self.__size -= 1
            print("Removed : {}".format(item))
        elif self.__head.value == item:
            self.__head = self.__head.next
            self.__head.prev = None
            self.__size -= 1
            print("Removed : {}".format(item))
        elif self.__tail.value == item:
            self.__tail = self.__tail.prev
            self.__tail.next = None
            self.__size -= 1
            print("Removed : {}".format(item))
        else:
            currentNode = self.__head.next
            prevNode = self.__head
            while(currentNode):
                if(currentNode.value == item):
                    prevNode.next = currentNode.next
                    currentNode.next.prev = prevNode
                    self.__size -= 1
                    print("Removed : {}".format(item))
                    break
                prevNode = currentNode
                currentNode = currentNode.next
                
    def traverse(self):
        ''' This method traverses each node of the lonkedlist '''
        if not self.__head:
            print("Underflow")
        else:
            currentNode = self.__head
            final_str = "DoublyLinkedList : "
            while(currentNode):
                final_str= final_str + ' ' + str(currentNode.value)
                currentNode = currentNode.next
            print(final_str)
    
    def search(self, item):
        ''' This method returns true if a item is present in the linkedlist else returns false '''
        currentNode = self.__head 
        while(currentNode):
            if  currentNode.value == item:
                return True
            currentNode = currentNode.next
        return False
          
    def sort(self):
        ''' This method sorts the items in the linkedlist in ascending order '''
        if not self.__head:
            pass
        else:
            currentNode = self.__head 
            while(currentNode):
                indexNode = currentNode.next
                while(indexNode):
                    if indexNode.value < currentNode.value:
                        temp = currentNode.value
                        currentNode.value = indexNode.value
                        indexNode.value = temp
                    indexNode = indexNode.next
                currentNode = currentNode.next
                
    def size(self):
        ''' This method returns the size of the linked list '''
        return self.__size
        
if __name__ == '__main__':
    doublyLinkedList = DoublyLinkedList();
    doublyLinkedList.traverse();
    print("size : {}".format(doublyLinkedList.size()))
    
    doublyLinkedList.insertStart(10);
    doublyLinkedList.traverse();
    print("size : {}".format(doublyLinkedList.size()))
    doublyLinkedList.remove(10);
    doublyLinkedList.traverse();
    print("size : {}".format(doublyLinkedList.size()))

    doublyLinkedList.insertEnd(10);
    doublyLinkedList.traverse();
    print("size : {}".format(doublyLinkedList.size()))
    doublyLinkedList.remove(10);
    doublyLinkedList.traverse();
    print("size : {}".format(doublyLinkedList.size()))
    
    doublyLinkedList.insertStart(5);
    doublyLinkedList.insertStart(10);
    doublyLinkedList.insertEnd(15);
    doublyLinkedList.traverse();
    print("size : {}".format(doublyLinkedList.size()))
    doublyLinkedList.remove(15);
    doublyLinkedList.traverse();
    print("size : {}".format(doublyLinkedList.size()))
    
    doublyLinkedList.insertStart(-2);
    doublyLinkedList.insertStart(99);
    doublyLinkedList.insertEnd(15);
    doublyLinkedList.traverse();
    print("size : {}".format(doublyLinkedList.size()))

    doublyLinkedList.sort();
    doublyLinkedList.traverse();
    
    print("search 1000 : {}".format(doublyLinkedList.search(1000)))
    print("search 99 : {}".format(doublyLinkedList.search(99)))

