class Node:
    def __init__(self, item):
        self.value = item;
        self.next = None;
    
class LinkedList:
    
    def __init__(self):
        ''' Initilalinzing class variables '''
        self.__head = None
        self.__size = 0
    
    def insertStart(self, item):
        ''' This method inserts element at the front of the linkedlist '''
        newNode = Node(item)
        if not self.__head:
            self.__head = newNode
        else:
            newNode.next = self.__head
            self.__head = newNode
            
        self.__size += 1
        print("Inserted at the start : {}".format(item));
    
    def insertEnd(self, item):
        ''' This method inserts element at the end of the linkedlist '''
        newNode = Node(item)
        if not self.__head:
            self.__head = newNode
        else:
            currentNode = self.__head
            while(currentNode.next):
                currentNode = currentNode.next
            currentNode.next = newNode
            
        self.__size += 1     
        print("Inserted at the end : {}".format(item));


    def remove(self, item):
        ''' This method removes a node from linkedlist if the value match is found'''
        found = False
        if not self.__head:
            print("Underflow")
        elif self.__head.value == item and self.__head.next == None:
            found = True
            self.__head = None
            self.__size -=1
        else:
            currentNode = self.__head
            previousNode = None
            while(currentNode and not found):
                if(currentNode.value == item):
                    found = True
                    if(not previousNode):
                        self.__head = currentNode.next
                    else:
                        previousNode.next = currentNode.next
                    self.__size -= 1
                previousNode = currentNode
                currentNode = currentNode.next
        if found:
            print("Removed : {}".format(item))
        else:
            print("{} node not found".format(item))
            
    def traverse(self):
        ''' This method traverses across the linkedlist'''

        if not self.__head:
            print("Underflow")
        else:
            final_str = "LinkedList : "
            currentNode = self.__head
            while currentNode:
                final_str += str(currentNode.value) + " "
                currentNode = currentNode.next
            print(final_str)
    
    def size(self):
        ''' This method returns the size of the linkedlist'''
        return self.__size

if __name__=='__main__':
    linked_list = LinkedList();
    
    linked_list.insertStart(5);
    linked_list.insertStart(10);
    linked_list.insertEnd(15);
    linked_list.traverse();
    print("size : ",linked_list.size());            
        
    linked_list.remove(5);
    linked_list.traverse();
    print("size : ",linked_list.size());            

    linked_list.remove(15);
    linked_list.traverse();
    print("size : ",linked_list.size());            
    
    linked_list.remove(10);
    linked_list.traverse();
    print("size : ",linked_list.size());            

    linked_list.insertEnd(5);
    linked_list.insertEnd(10);
    linked_list.insertStart(15);
    linked_list.insertStart(25);
    linked_list.insertStart(89);
    linked_list.traverse();
    print("size : ",linked_list.size());            

    linked_list.remove(10);
    linked_list.traverse();
    print("size : ",linked_list.size());    
            
    linked_list.remove(99);
    linked_list.traverse();
    print("size : ",linked_list.size());            
