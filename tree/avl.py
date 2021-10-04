class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None
        self.height = 0
        
class AVL:
    
    def __init__(self):
        self.root = None;
        
    def getHeight(self, node):
        '''
        It will return the height of the node
        Input : AVL node (type Node)
        output : height (type int)
        '''
        if not node:
            return -1
        
        return node.height
    
    def calcBalanceFactor(self, node):
        '''
        It will calculate the balance factor of the node
        '''
        if not node:
            return 0
        
        return self.getHeight(node.left) - self.getHeight(node.right)
    
    def getPredecessor(self, node):
        '''
        It returns the predecessor of the node
        '''
        if not node.right:
            return node
        else:
            return self.getPredecessor(node.right)
    
    def rotateRight(self, node):
        '''
        Rotating to the right on the node
        '''
        tempNode = node.left
        temp = tempNode.right
        tempNode.right = node
        node.left = temp
        
        node.height = max(self.getHeight(node.left), self.getHeight(node.right)) +1
        tempNode.height = max(self.getHeight(tempNode.left), self.getHeight(tempNode.right)) +1        
        
        return tempNode      

    def rotateLeft(self, node):
        '''
        Rotating to the left on the node
        '''
        tempNode = node.right
        temp = tempNode.left
        tempNode.left = node
        node.right = temp
        
        node.height = max(self.getHeight(node.left), self.getHeight(node.right)) +1
        tempNode.height = max(self.getHeight(tempNode.left), self.getHeight(tempNode.right)) +1 
         
        return tempNode
        
    def settleViolation(self, node):
        '''
        It will balance a node if it is unbalanced
        '''
        balanceFactor = self.calcBalanceFactor(node)
        balanceFactorLeft = self.calcBalanceFactor(node.left)
        balanceFactorRight = self.calcBalanceFactor(node.right)
        
        # case 1  -> left left heavy situation
        if balanceFactor > 1 and balanceFactorLeft > 0:
            return self.rotateRight(node)
        
        # case 2  -> left right situation
        elif balanceFactor > 1 and balanceFactorLeft < 0:
            node.left = self.rotateLeft(node.left)
            return self.rotateRight(node)
        
        # case 3  -> right right situation
        elif balanceFactor < -1 and balanceFactorRight < 0:
            return self.rotateLeft(node)
        
        # case 4  -> right left situation
        elif balanceFactor < -1 and balanceFactorRight > 0:
            node.right = self.rotateRight(node.right)
            return self.rotateLeft(node)

        return node            
        
    def insertNode(self, data, node):
        '''
        It will insert a node in the given AVL node
        Time complexity : O(NlogN)
        '''
        if not node:
            node = Node(data)
        else:
            if data < node.data:
                node.left = self.insertNode(data, node.left)
            else:
                node.right = self.insertNode(data, node.right)
        
        node.height = max(self.getHeight(node.left), self.getHeight(node.right)) +1        
        node = self.settleViolation(node)
        
        return node
    
    def insert(self, data):
        '''
        It will insert a node in the given AVL node
        Time complexity : O(NlogN)
        '''
        self.root = self.insertNode(data, self.root)
        print("inserted node : ",data)
        
    def removeNode(self, data, node):
        '''
        It will remove a node from the AVL node
        Time complexity : O(NlogN)
        '''
        if not node:
            pass
        elif data < node.data:
            node.left = self.removeNode(data, node.left)
        elif data > node.data:
            node.right = self.removeNode(data, node.right)
        else:
            if node.left and node.right:
                tempNode = self.getPredecessor(node.left)
                node.data = tempNode.data
                node.left = self.removeNode(tempNode.data, node.left)
            elif node.left:
                node = node.left
            elif node.right:
                node = node.right
            else:
                node = None
                
            return node
                            
        if not node:
            return node;
            
        node.height = max(self.getHeight(node.left), self.getHeight(node.right)) +1  
        #print(node.data,node.height)    
        node = self.settleViolation(node)
        
        return node
        
    def remove(self, data):
        '''
        It will remove a node from the AVL tree
        Time complexity : O(NlogN)
        '''
        if not self.root:
            print("Underflow")
        else:
            self.root = self.removeNode(data, self.root)
            
    def getMin(self, node):
        '''
        It will find the min value in the AVL node
        Time complexity : O(logN)
        '''
        if node.left:
           return self.getMin(node.left) 
        else:
            return node.data

    def getMax(self, node):
        '''
        It will find the max value in the AVL node
        Time complexity : O(logN)
        '''
        if node.right:
           return self.getMax(node.right) 
        else:
            return node.data

    def getMinValue(self):
        '''
        It will find the min value in the AVL tree
        Time complexity : O(logN)
        '''
        if self.root:
            return self.getMin(self.root) 
        else:
            return None

    def getMaxValue(self):
        '''
        It will find the max value in the AVL tree
        Time complexity : O(logN)
        '''
        if self.root:
            return self.getMax(self.root) 
        else:
            return None
        
    def traverseInOrder(self, node):
        '''
        It will do the inorder traversal of all elements the AVL node
        Time complexity : O(N)
        '''
        if node.left:
            self.traverseInOrder(node.left)
        
        print(node.data)
       
        if node.right:
            self.traverseInOrder(node.right)
       
                
    def traverse(self):
        '''
        It will do the inorder traversal of all elements the AVL node
        Time complexity : O(N)
        '''
        print("Inorder traversal of the tree: ")
        if self.root:
            self.traverseInOrder(self.root)        
        else:
            print("Underflow")
       
        
if __name__=='__main__':
    avl_tree = AVL()
    print(avl_tree.root);

    avl_tree.insert(10);
    print(avl_tree.root.data);
    avl_tree.insert(13);   
    avl_tree.insert(5);
    avl_tree.insert(14);
    avl_tree.insert(-1);
    print('root left node ',avl_tree.root.left.data);
    avl_tree.insert(3);
    print('root left node ',avl_tree.root.left.data);
    print('root right node ',avl_tree.root.right.data);
    avl_tree.insert(99);
    print('root right node ',avl_tree.root.right.data);
    
    print('Min : ',avl_tree.getMinValue())
    print(avl_tree.root.data);
    print('Max : ',avl_tree.getMaxValue())
    avl_tree.traverse();
    avl_tree.remove(100);
    avl_tree.traverse();
    
    avl_tree1 = AVL()
    avl_tree1.insert(10)  
    avl_tree1.insert(9) 
    avl_tree1.insert(11) 
    avl_tree1.insert(8)     
    print(avl_tree1.root.data,avl_tree1.root.left.data, avl_tree1.root.left.left.data, avl_tree1.root.right.data)     
    avl_tree1.remove(11);  
    print(avl_tree1.root.data,avl_tree1.root.left.data, avl_tree1.root.right.data)   
    avl_tree1.traverse();

    avl_tree2 = AVL()
    avl_tree2.insert(10)  
    avl_tree2.insert(8) 
    avl_tree2.insert(11) 
    avl_tree2.insert(9)     
    print(avl_tree2.root.data,avl_tree2.root.left.data, avl_tree2.root.left.right.data, avl_tree2.root.right.data)     
    avl_tree2.remove(11);  
    print(avl_tree2.root.data,avl_tree2.root.left.data, avl_tree2.root.right.data)   
    avl_tree2.traverse();

    avl_tree3 = AVL()
    avl_tree3.insert(10)  
    avl_tree3.insert(8) 
    avl_tree3.insert(11) 
    avl_tree3.insert(12)     
    print(avl_tree3.root.data,avl_tree3.root.left.data, avl_tree3.root.right.data, avl_tree3.root.right.right.data)     
    avl_tree3.remove(8);  
    print(avl_tree3.root.data,avl_tree3.root.left.data, avl_tree3.root.right.data)   
    avl_tree3.traverse();

    avl_tree4 = AVL()
    avl_tree4.insert(10)  
    avl_tree4.insert(8) 
    avl_tree4.insert(12) 
    avl_tree4.insert(11)     
    print(avl_tree4.root.data,avl_tree4.root.left.data, avl_tree4.root.right.data, avl_tree4.root.right.left.data)     
    avl_tree4.remove(8);  
    print(avl_tree4.root.data,avl_tree4.root.left.data, avl_tree4.root.right.data)  
    avl_tree4.traverse(); 
