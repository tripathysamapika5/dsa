class BinarySearchTree {
    private Node root;

    static class Node{
        Node left, right;
        int data;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    BinarySearchTree(){
        this.root = null;
    }

    public void insertNode(int data, Node node){
        /**It will insert an item in a given node
         * Time complexity O(logN)
         */
        Node newNode = new Node(data);
        if (data < node.data){
            if (node.left == null) {
                node.left = newNode;
            }else{
                this.insertNode(data, node.left);
            }
        }else{
            if (node.right == null) {
                node.right = newNode;
            }else{
                this.insertNode(data, node.right);
            }
        }
    }

    public void insert(int data){
        /**It will insert an item in the tree
         * Time complexity O(logN)
         */
        if (this.root == null){
            this.root = new Node(data);
        }else{
            this.insertNode(data, this.root);
            System.out.println("Inserted node : "+data);
        }
    }

    public Node getPredecessor(Node node){
        /**It will return the predecessor leaf node of a node
         * Time complexity O(logN)
         */
        if (node.right != null){
            return this.getPredecessor(node.right);
        }else{
            return node;
        }
    }

    public Node removeNode(int data, Node node){
        /**It will remove a node in a given node
         * Time complexity O(logN)
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
                node.left = this.removeNode(tempNode.data, node.left);
            }else if(node.left != null){
                node = node.left;
            }else if(node.right != null){
                node = node.right;
            }else{
                node = null;
            }
            System.out.println("Removed node : "+data);
        }
        return node;
    }

    public void remove(int data){
        /**It will remove a node in a given node
         * Time complexity O(logN)
         */
        if(this.root == null){
            System.out.println("Underflow");
        }else{
            this.root = this.removeNode(data, this.root);
        }
    }

    public int getMin(Node node){
        /**It will find the min value in a given node
         * Time complexity O(logN)
         */
        if (node.left != null){
            return this.getMin(node.left);
        }else{
            return node.data;
        }
    }
    public int getMinValue(){
        /**It will find the min value in the tree
         * Time complexity O(logN)
         */
        if(this.root == null){
            System.out.println("Underflow");
            System.exit(1);
        }
        return this.getMin(this.root);
    }

    public int getMax(Node node){
        /**It will find the max value in a given node
         * Time complexity O(logN)
         */
        if (node.right != null){
            return this.getMax(node.right);
        }else{
            return node.data;
        }
    }

    public int getMaxValue(){
        /**It will find the max value in the tree
         * Time complexity O(logN)
         */
        if(this.root == null){
            System.out.println("Underflow");
            System.exit(1);
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

class Test {
    public static void main(String args[]) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(13);
        bst.insert(5);
        bst.insert(14);
        bst.remove(10);
        bst.insert(-1);
        bst.insert(3);
        bst.insert(99);
        System.out.println("Min : "+bst.getMinValue());
        System.out.println("Max : "+bst.getMaxValue());
        bst.traverse();
        bst.remove(100);
        bst.traverse();

    }
}
