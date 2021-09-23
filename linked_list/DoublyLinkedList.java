public class DoublyLinkedList {
    private int size;
    private Node head,tail;

    private class Node{
        int value;
        Node prev,next;
        Node(int item){
            this.value = item;
            this.prev = null;
            this.next = null;
        }
    }
    DoublyLinkedList(){
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public void insertStart(int item){
        /** This method inserts element at the start of the linkedlist */
        Node newNode = new Node(item);
        if (this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }
        else{
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.size++;
        System.out.println("Inserted at start : "+item);
    }
    public void insertEnd(int item){
        /** This method inserts element at the end of the linkedlist */
        Node newNode = new Node(item);
        if (this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }else{
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.size++;
        System.out.println("Inserted at end : "+item);

    }

    public void remove(int item){
        /** This method removes a node from linkedlist if data matches*/
        if (this.head == null){
            return ;
        }else if(this.head == this.tail && this.head.value == item){
            this.head = null;
            this.tail = null;
            this.size--;
            System.out.println("Removed : "+item);
        }else if(this.head.value == item){
            this.head = this.head.next;
            this.head.prev = null;
            this.size--;
            System.out.println("Removed : "+item);
        }else if(this.tail.value == item){
            this.tail = this.tail.prev;
            this.tail.next = null;
            this.size--;
            System.out.println("Removed : "+item);
        }else {
            Node currentNode = this.head.next;
            Node prevNode = this.head;
            while (currentNode != null) {
                if (currentNode.value == item) {
                    prevNode.next = currentNode.next;
                    currentNode.next.prev = prevNode;
                    this.size--;
                    System.out.println("Removed : "+item);
                }
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
        }

    }
    public void traverse() {
        /** This method traverses each node of the lonkedlist */
        if (this.head == null) {
            System.out.println("Underflow");
        } else {
            Node currentNode = this.head;
            System.out.print("DoublyLinkedList : ");
            while (currentNode != null) {
                System.out.print(currentNode.value + " ");
                currentNode = currentNode.next;
            }
            System.out.println("");
        }
    }

    public Boolean search(int item){
        /** This method returns true if an element is found in the linkedlist else returns false */
        Node currentNode = this.head;
        while(currentNode != null){
            if(currentNode.value == item){
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public void sort(){
        /** This method sorts the elements of the linkedlist */
        if (this.head == null) {
            return;
        }else{
            Node currentNode = this.head;
            while(currentNode != null){
                Node indexNode = currentNode.next;
                while(indexNode != null){
                    if(currentNode.value > indexNode.value){
                        int temp = currentNode.value;
                        currentNode.value = indexNode.value;
                        indexNode.value = temp;
                    }
                    indexNode = indexNode.next;
                }
                currentNode = currentNode.next;
            }
        }
    }

    public int size(){
        /** This method returns the size of the linkedlist */
        return this.size;
    }

}

class Test {
    public static void main(String args[]) {
    DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

    doublyLinkedList.traverse();
    System.out.println("size : "+doublyLinkedList.size());

    doublyLinkedList.insertStart(10);
    System.out.println("size : "+doublyLinkedList.size());
    doublyLinkedList.traverse();
    doublyLinkedList.remove(10);
    System.out.println("size : "+doublyLinkedList.size());
    doublyLinkedList.traverse();

    doublyLinkedList.insertEnd(99);
    System.out.println("size : "+doublyLinkedList.size());
    doublyLinkedList.traverse();
    doublyLinkedList.remove(99);
    System.out.println("size : "+doublyLinkedList.size());
    doublyLinkedList.traverse();

    doublyLinkedList.insertStart(5);
    doublyLinkedList.insertStart(10);
    doublyLinkedList.insertEnd(15);
    System.out.println("size : "+doublyLinkedList.size());
    doublyLinkedList.traverse();
    doublyLinkedList.remove(15);
    System.out.println("size : "+doublyLinkedList.size());
    doublyLinkedList.traverse();

    doublyLinkedList.insertStart(-2);
    doublyLinkedList.insertStart(99);
    doublyLinkedList.insertEnd(15);
    System.out.println("size : "+doublyLinkedList.size());
    doublyLinkedList.traverse();

    doublyLinkedList.sort();
    doublyLinkedList.traverse();

    System.out.println("search 1000 : "+doublyLinkedList.search(1000));
    System.out.println("search 99 : "+doublyLinkedList.search(99));

    }
}