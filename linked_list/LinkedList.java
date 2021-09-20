

public class LinkedList {

    /**declaring the class variables*/
    private Node head;
    private int size;

    /**declaring the static Node class*/
    static class Node{
        int value;
        Node next;
        Node(int item){
            this.value = item;
            this.next = null;
        }
    }

    /**Initilaizing  the class variables*/
    LinkedList(){
        this.size = 0;
        this.head = null;
    }

    public void insertStart(int item){
        /** This Method adds nodes at the start of the linked list */
        Node newNode = new Node(item);
        this.size++;
        if (this.head == null) {
            this.head = newNode;
        }else{
            newNode.next = this.head;
            this.head = newNode;
        }
        System.out.println("inserted node at start : "+item);
    }

    public void insertEnd(int item){
        /** This Method adds nodes at the end of the linked list */

        Node newNode = new Node(item);
        this.size++;
        if (this.head == null) {
            this.head = newNode;
        }else{
            Node node = this.head;
            while(node.next != null){
                node = node.next;
            }
            node.next = newNode;
        }
        System.out.println("inserted node at end : "+item);

    }

    public void traverse(){
        /** This Method traverses through linkedlist nodes*/

        if (this.head == null){
            System.out.println("Underflow");
            System.exit(1);
        }
        Node node = this.head;
        System.out.print("LinkedList : ");
        while (node != null){
            System.out.print(node.value +" ");
            node = node.next;
        }
        System.out.println("");
    }

    public void remove(int item){
        /** This Method removes the node from linkedlist where matching data is found*/

        if (this.head == null){
            System.out.println("Underflow");
            System.exit(1);
        }
        Boolean found= false;
        if (this.head.value == item && this.head.next == null) {
            this.head = null;
            found = true;
            this.size--;
        }
        else {
            Node currentNode, previousNode;
            currentNode = this.head;
            previousNode = null;
            while (currentNode != null && !(found)) {
                if (currentNode.value == item ) {
                    found = true;
                    if(previousNode == null){
                        currentNode = currentNode.next;
                        this.head = currentNode;
                    }else {
                        previousNode.next = currentNode.next;
                    }
                    this.size--;
                }
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
        }
        if (found){
            System.out.println("Removed node : "+item);
        }
        else{
            System.out.println(item +" node not found");
        }

    }
    public int size(){
        /** This Method returns the size of the linkedlist*/
        return this.size;
    }


}

class Test {
    public static void main(String args[]) {
        LinkedList linked_list = new LinkedList();
        linked_list.insertStart(5);
        linked_list.insertStart(10);
        linked_list.insertEnd(15);
        linked_list.traverse();
        System.out.println("size : "+linked_list.size());

        linked_list.remove(10);
        System.out.println("size : "+linked_list.size());
        linked_list.traverse();

        linked_list.remove(5);
        linked_list.traverse();
        System.out.println("size : "+linked_list.size());

        linked_list.remove(15);
        System.out.println("size : "+linked_list.size());
        //linked_list.traverse(); // underflow error

        //linked_list.remove(99);// underflow error

        linked_list.insertEnd(5);
        linked_list.insertEnd(10);
        linked_list.insertStart(15);
        linked_list.insertStart(25);
        linked_list.insertStart(89);
        linked_list.traverse();
        System.out.println("size : "+linked_list.size());

        linked_list.remove(10);
        linked_list.traverse();
        System.out.println("size : "+linked_list.size());

        linked_list.remove(99);
        linked_list.traverse();
        System.out.println("size : "+linked_list.size());

    }
}


