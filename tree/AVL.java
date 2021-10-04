public class AVL {
    Node root;

    static class Node{
        Node left, right;
        int data, height;

        Node(int data){
           this.data = data;
           this.left = null;
           this.right = null;
           this.height = 0;
        }
    }
    AVL(){
        this.root = null;
    }

    public int getHeight(Node node){
        /**
         * It will return the height of the node
         * Input : AVL node (type Node)
         * output : height (type int)
         */
        if (node == null){
            return -1;
        }
        return node.height;
    }

    public Node rotateLeft(Node node){
        /**
        * Rotating to the left on the node
        */
        Node tempNodeRight = node.right;
        Node tempNode = tempNodeRight.left;

        tempNodeRight.left = node;
        node.right = tempNode;

        node.height = Math.max(this.getHeight(node.left),this.getHeight(node.right)) +1;
        tempNodeRight.height = Math.max(this.getHeight(tempNodeRight.left),this.getHeight(tempNodeRight.right)) +1;

        return tempNodeRight;
    }

    public Node rotateRight(Node node){
        /**
         * Rotating to the right on the node
         */
        Node tempNodeLeft = node.left;
        Node tempNode = tempNodeLeft.right;

        tempNodeLeft.right = node;
        node.left = tempNode;

        node.height = Math.max(this.getHeight(node.left),this.getHeight(node.right)) +1;
        tempNodeLeft.height = Math.max(this.getHeight(tempNodeLeft.left),this.getHeight(tempNodeLeft.right)) +1;

        return tempNodeLeft;
    }

    public int calcBalanceFactor(Node node){
        /**
         * It will calculate the balance factor of the node
         */
        if (node == null){
            return 0;
        }
        return this.getHeight(node.left) - this.getHeight(node.right);
    }

    public Node settleViolations(Node node){
        /**
         * It will balance a node if it is unbalanced
         */
        int balanceFactor = this.calcBalanceFactor(node);
        int balanceFactorLeft = this.calcBalanceFactor(node.left);
        int balanceFactorRight = this.calcBalanceFactor(node.right);
        // case -1 left left heavy unbalanced case
        if (balanceFactor > 1 && balanceFactorLeft > 0){
            return this.rotateRight(node);
        }
        // case -2 left right unbalanced case
        else if (balanceFactor > 1 && balanceFactorLeft < 0){
            node.left = this.rotateLeft(node.left);
            return this.rotateRight(node);
        }
        // case -3 right right heavy unbalanced case
        else if(balanceFactor < -1 && balanceFactorRight < 0){
            return this.rotateLeft(node);
        }
        //case -4 right left unbalanced case
        else if(balanceFactor < -1 && balanceFactorRight > 0){
            node.right = this.rotateRight(node.right);
            return this.rotateLeft(node);
        }
        return node;
    }


    public Node insertNode(int data, Node node){
        /**
         * It will insert a node in the given AVL node
         * Time complexity : O(NlogN)
         */
        if (node == null){
            node = new Node(data);
        }
        else{
            if(data < node.data){
                node.left = this.insertNode(data, node.left);
            }else{
                node.right = this.insertNode(data, node.right);
            }
        }

        node.height = Math.max(this.getHeight(node.left),this.getHeight(node.right)) +1;
        return this.settleViolations(node);
    }

    public void insert(int data){
        /**
         * It will insert a node in the given AVL node
         * Time complexity : O(NlogN)
         */
        this.root = this.insertNode(data, this.root);
        System.out.println("inserted node : "+data);
    }

    public Node getPredecessor(Node node){
        /**
         * It returns the predecessor of the node
         */
        if (node.right == null){
            return node;
        }else{
            return this.getPredecessor(node.right);
        }
    }

    public Node removeNode(int data, Node node){
        /**
         * It will remove a node from the AVL node
         * Time complexity : O(NlogN)
         */
        if (node == null){
            ;
        }else if(data < node.data){
            node.left = this.removeNode(data, node.left);
        }else if(data > node.data){
            node.right = this.removeNode(data, node.right);
        }else{
            if(node.left != null && node.right != null){
                Node tempNode = this.getPredecessor(node.left);
                node.data = tempNode.data;
                node.left = this.removeNode(data, node.left);
            }else if(node.left != null){
                node = node.left;
            }else if(node.right != null){
                node = node.right;
            }else{
                node = null;
            }
            return node;
        }

        if(node == null){
            return node;
        }
        node.height = Math.max(this.getHeight(node.left),this.getHeight(node.right)) +1;
        return this.settleViolations(node);
    }

    public void remove(int data){
        /**
         * It will remove a node from the AVL tree
         * Time complexity : O(NlogN)
         */
        if (this.root == null){
            System.out.println("Underflow");
        }else{
            this.root = this.removeNode(data, this.root);
        }
    }

    public int getMin(Node node){
        /**
         * It will find the min value in the AVL node
         * Time complexity : O(logN)
         */
        if (node.left != null){
            return this.getMin(node.left);
        }
        return node.data;
    }

    public int getMax(Node node){
        /**
         * It will find the max value in the AVL node
         * Time complexity : O(logN)
         */
        if (node.right != null){
            return this.getMax(node.right);
        }
        return node.data;
    }

    public Integer getMinValue(){
        /**
         * It will find the min value in the AVL tree
         * Time complexity : O(logN)
         */
        if(this.root == null){
            return (Integer)null;
        }
        return this.getMin(this.root);
    }

    public Integer getMaxValue(){
        /**
         * It will find the max value in the AVL tree
         * Time complexity : O(logN)
         */
        if(this.root == null){
            return (Integer)null;
        }
        return this.getMax(this.root);
    }

    public void traverseInOrder(Node node){
        /**
         * It will do the inorder traversal of the node
         * timeComplexity O(N)
         */
        if(node.left != null){
            this.traverseInOrder(node.left);
        }

        System.out.println(node.data);
        if(node.right != null){
            this.traverseInOrder(node.right);
        }
    }

    public void traverse(){
        /**
         * It will do the inorder traversal of the tree
         * timeComplexity O(N)
         */
        if(this.root == null){
            System.out.println("Underflow");
        }else{
            System.out.println("Inorder traversal of tree : ");
            this.traverseInOrder(this.root);
        }

    }


}

class Test1{
    public static void main(String args[]){
        AVL avl_tree = new AVL();
        System.out.println("Min : "+avl_tree.getMinValue());
        System.out.println("Max : "+avl_tree.getMaxValue());
        System.out.println(avl_tree.root);

        avl_tree.insert(10);
        System.out.println(avl_tree.root.data);
        avl_tree.insert(13);
        avl_tree.insert(5);
        avl_tree.insert(14);
        avl_tree.insert(-1);
        avl_tree.traverse();
        System.out.println("root left node "+avl_tree.root.left.data);
        avl_tree.insert(3);
        System.out.println("root left node "+avl_tree.root.left.data);
        System.out.println("root right node "+avl_tree.root.right.data);
        avl_tree.insert(99);
        System.out.println("root right node "+avl_tree.root.right.data);

        System.out.println("Min : "+avl_tree.getMinValue());
        System.out.println(avl_tree.root.data);
        System.out.println("Max : "+avl_tree.getMaxValue());
        avl_tree.traverse();
        avl_tree.remove(100);
        avl_tree.traverse();

        AVL avl_tree1 = new AVL();
        avl_tree1.insert(10);
        avl_tree1.insert(9);
        avl_tree1.insert(11);
        avl_tree1.insert(8);
        System.out.println(avl_tree1.root.data +" "+avl_tree1.root.left.data +" "+avl_tree1.root.left.left.data +" "+ avl_tree1.root.right.data);
        avl_tree1.remove(11);
        System.out.println(avl_tree1.root.data+" "+avl_tree1.root.left.data+" "+ avl_tree1.root.right.data);
        avl_tree1.traverse();

        AVL avl_tree2 = new AVL();
        avl_tree2.insert(10);
        avl_tree2.insert(8);
        avl_tree2.insert(11);
        avl_tree2.insert(9);
        System.out.println(avl_tree2.root.data +" "+avl_tree2.root.left.data +" "+ avl_tree2.root.left.right.data +" "+ avl_tree2.root.right.data);
        avl_tree2.remove(11);
        System.out.println(avl_tree2.root.data+" "+avl_tree2.root.left.data+" "+ avl_tree2.root.right.data);
        avl_tree2.traverse();

        AVL avl_tree3 = new AVL();
        avl_tree3.insert(10);
        avl_tree3.insert(8);
        avl_tree3.insert(11);
        avl_tree3.insert(12);
        System.out.println(avl_tree3.root.data+" "+avl_tree3.root.left.data+" "+avl_tree3.root.right.data+" "+ avl_tree3.root.right.right.data);
        avl_tree3.remove(8);
        System.out.println(avl_tree3.root.data+" "+avl_tree3.root.left.data+" "+ avl_tree3.root.right.data);
        avl_tree3.traverse();

        AVL avl_tree4 = new AVL();
        avl_tree4.insert(10);
        avl_tree4.insert(8);
        avl_tree4.insert(12);
        avl_tree4.insert(11);
        System.out.println(avl_tree4.root.data+" "+avl_tree4.root.left.data+" "+avl_tree4.root.right.data+" "+ avl_tree4.root.right.left.data);
        avl_tree4.remove(8);
        System.out.println(avl_tree4.root.data+" "+avl_tree4.root.left.data+" "+ avl_tree4.root.right.data);
        avl_tree4.traverse();

    }
}
