class Node:
    
    def __init__(self, value):
        self.value = value
        self.next = None
        self.prev = None

class CircularLinkedList:
    
    def __init__(self):
        self.__size  = 0
        self.__head = None
        self.__tail = None
    
    def insertStart(self, item):
        ''' This method will insert a node at the start of the linkedlist '''
        newNode = Node(item)
        if (not self.__head):
            self.__head = newNode;
            self.__tail = self.__head;
        else:
            self.__head.prev = newNode
            self.__tail.next = newNode
            newNode.prev = self.__tail
            newNode.next = self.__head
            self.__head = newNode
        self.__size += 1
        print("inserted at start : {}".format(item))

    def insertEnd(self, item):
        ''' This method will insert a node at the end of the linkedlist '''
        newNode = Node(item)
        if (not self.__head):
            self.__head = newNode;
            self.__tail = self.__head;
        else:
            self.__head.prev = newNode
            self.__tail.next = newNode
            newNode.prev = self.__tail
            newNode.next = self.__head
            self.__tail = newNode
        self.__size += 1
        print("inserted at end : {}".format(item))
        
    def remove(self, item):
        ''' This method will remove a node from the linkedlist if the input item matches with the node'''
        if (not self.__head):
            pass
        elif (self.__head == self.__tail and self.__head.value == item):
            self.__head = None
            self.__tail = None
            self.__size -= 1
            print("Removed : {}".format(item))
        elif (self.__head.value == item):
            self.__tail.next = self.__head.next
            self.__head.next.prev = self.__tail
            self.__head = self.__head.next
            self.__size -= 1
            print("Removed : {}".format(item))
        elif (self.__tail.value == item):
            self.__tail.prev.next = self.__head
            self.__head.prev  = self.__tail.prev
            self.__tail = self.__tail.prev
            self.__size -= 1
            print("Removed : {}".format(item))
        else:
            currentNode = self.__head.next
            prevNode = self.__head
            while(True):
                if currentNode.value == item:
                    prevNode.next = currentNode.next
                    currentNode.next.prev = prevNode
                    self.__size -= 1
                    print("Removed : {}".format(item))
                prevNode = currentNode
                currentNode = currentNode.next
                if currentNode == self.__head:
                    break
                    
    def traverse(self):
        ''' This method will traverse across the nodes of the linkedlist and will print the values '''
        if (not self.__head):
            print("Underflow")
        else:
            currentNode = self.__head
            final_str = "CircularLinkedList : "
            while True:
                final_str = final_str + str(currentNode.value) + " "
                currentNode = currentNode.next
                if currentNode == self.__head or currentNode is None:
                    break
            print(final_str)
           
    def search(self, item):
        ''' This method will return true if the input item is present in likedlist else it will return false '''
        if (not self.__head):
            return False
        else:
            currentNode = self.__head
            while True:
                if currentNode.value == item:
                    return True
                currentNode = currentNode.next
                if currentNode == self.__head or currentNode is None:
                    break
            return False

    def sort(self):
        ''' This method will sort the elements of the linkedlist in ascending order '''
        if (not self.__head):
            print("Underflow")
        else:
            currentNode = self.__head
            indexNode = None
            while(True):
                indexNode = currentNode.next
                while(indexNode and indexNode != self.__head):
                    if currentNode.value > indexNode.value:
                        temp = currentNode.value
                        currentNode.value = indexNode.value 
                        indexNode.value = temp
                    indexNode = indexNode.next
                currentNode = currentNode.next
                if currentNode is None or currentNode == self.__head:
                    break
        
    def size(self):
        ''' This method will return the size of the linkedlist '''
        return self.__size

if __name__ == '__main__':
    circularLinkedList = CircularLinkedList();
    circularLinkedList.traverse();
    print("size : {}".format(circularLinkedList.size()))
    
    circularLinkedList.insertStart(10);
    circularLinkedList.traverse();
    print("size : {}".format(circularLinkedList.size()))
    circularLinkedList.remove(10);
    circularLinkedList.traverse();
    print("size : {}".format(circularLinkedList.size()))

    circularLinkedList.insertEnd(10);
    circularLinkedList.traverse();
    print("size : {}".format(circularLinkedList.size()))
    circularLinkedList.remove(10);
    circularLinkedList.traverse();
    print("size : {}".format(circularLinkedList.size()))
    
    circularLinkedList.insertStart(5);
    circularLinkedList.insertStart(10);
    circularLinkedList.insertEnd(15);
    circularLinkedList.insertEnd(20);
    circularLinkedList.traverse();
    print("size : {}".format(circularLinkedList.size()))
    
    
    circularLinkedList.remove(15);
    circularLinkedList.traverse();
    print("size : {}".format(circularLinkedList.size()))

    circularLinkedList.remove(10);
    circularLinkedList.traverse();
    print("size : {}".format(circularLinkedList.size()))
    
    circularLinkedList.remove(20);
    circularLinkedList.traverse();
    print("size : {}".format(circularLinkedList.size()))

    circularLinkedList.remove(5);
    circularLinkedList.traverse();
    print("size : {}".format(circularLinkedList.size()))


    
    circularLinkedList.insertStart(-2);
    circularLinkedList.insertStart(99);
    circularLinkedList.insertEnd(15);
    circularLinkedList.insertEnd(100);
    circularLinkedList.insertEnd(-25);
    circularLinkedList.traverse();
    print("size : {}".format(circularLinkedList.size()))

    circularLinkedList.sort();
    circularLinkedList.traverse();
    
    print("search 1000 : {}".format(circularLinkedList.search(1000)))
    print("search 99 : {}".format(circularLinkedList.search(99)))
