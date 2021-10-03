class Node:
    def __init__(self, item):
        self.left = None
        self.right = None
        self.data = item

class BinarySearchTree:
    def __init__(self):
        self.__root = None

    def insertNode(self, data, node):
        '''It will insert an item in a given node'''
        '''Time complexity O(logN)'''
        newNode = Node(data)
        
        if data < node.data:
            if node.left is None:
                node.left = newNode
            else:
                self.insertNode(data, node.left)
        else:
            if node.right is None:
                node.right = newNode
            else:
                self.insertNode(data, node.right)

            
    def insert(self, data):
        '''It will insert an item in the binary search tree'''
        '''Time complexity O(logN)'''        
        if not self.__root:
            self.__root = Node(data)
        else:
            self.insertNode(data, self.__root)
        
        print("Inserted the node : {}".format(data))
        
    def getPredecessor(self, node):
        if node.right:
            return self.getPredecessor(node.right)
        else:
            return node
    
    def removeNode(self, data, node):    
        '''It will remove an item in the given node'''
        '''Time complexity O(logN)'''     
        if not node:
            pass
        
        elif data < node.data: 
            node.left = self.removeNode(data, node.left)
        elif  data > node.data:
            node.right = self.removeNode(data, node.right)
            
        else:
            if node.left and node.right:
                tempNode = self.getPredecessor(node.left)
                node.data = tempNode.data
                node.left = self.removeNode(tempNode.data, node.left)

            elif node.right:
                node = node.right
            elif node.left:
                node = node.left
            else:
                node = None
            
            print("Node : {} removed".format(data))
        

        return node
            
    def remove(self, data):
        '''It will remove an item in the binary search tree'''
        '''Time complexity O(logN)'''            
        if not self.__root:
            print("Underflow")
        else:
            self.__root = self.removeNode(data, self.__root)
            
    def getMin(self, node):
        '''It will find the min value in a given node'''
        '''Time complexity O(logN)'''            
        if node.left:
            return self.getMin(node.left)
        else:
            return  node.data

    def getMax(self, node):
        '''It will find the max value in a given node'''
        '''Time complexity O(logN)'''            
        if node.right:
            return self.getMax(node.right)       
        else:
            return node.data
            
    def getMinvalue(self):
        '''It will find the min value in the tree'''
        '''Time complexity O(logN)'''            
        if not self.__root:
            print("Underflow")
        else:
            return self.getMin(self.__root)
    
    def getMaxvalue(self):
        '''It will find the max value in the tree'''
        '''Time complexity O(logN)'''            
        if not self.__root:
            print("Underflow")
        else:
            return self.getMax(self.__root)
                
    def traverseInOrder(self, node):
        ''' It will do the inirder traversal of the node
            timeComplexity O(N)'''
        if node.left:
              self.traverseInOrder(node.left)
        
        print(node.data)

        if node.right:
              self.traverseInOrder(node.right)
    
    def traverse(self):
        '''It will do the inirder traversal of the tree'''
        '''Time complexity O(N)'''
        if not self.__root:
            print("Underflow")
        else:
            print("Inorder traversal of tree : ")
            self.traverseInOrder(self.__root)
            


if __name__=='__main__':
    bst = BinarySearchTree()
    bst.insert(10);
    bst.insert(13);
    bst.insert(5);
    bst.insert(14);
    bst.remove(10);
    bst.insert(-1);
    bst.insert(3);
    bst.insert(99);
    print('Min : ',bst.getMinvalue())
    print('Max : ',bst.getMaxvalue())
    bst.traverse();
    bst.remove(100);
    bst.traverse();
   
