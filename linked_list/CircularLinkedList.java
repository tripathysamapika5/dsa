public class CircularLinkedList {
    private int size;
    private Node head,tail;

    private class Node{
        int value;
        Node prev,next;
        Node(int value){
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    CircularLinkedList(){
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public void insertStart(int item){
        /** This method will insert a node at the start of the linked list*/
        Node newNode = new Node(item);
        if (this.head == null){
            this.head = newNode;
            this.tail = this.head;
        }else{
            newNode.prev = this.tail;
            newNode.next = this.head;
            this.tail.next = newNode;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.size++;
        System.out.println("Inserted at start : "+ item);

    }
    public void insertEnd(int item){
        /** This method will insert a node at the end of the linked list*/
        Node newNode = new Node(item);
        if (this.head == null){
            this.head = newNode;
            this.tail = this.head;
        }else{
            newNode.prev = this.tail;
            newNode.next = this.head;
            this.tail.next = newNode;
            this.head.prev = newNode;
            this.tail = newNode;
        }
        this.size++;
        System.out.println("Inserted at end : "+ item);
    }

    public void remove(int item){
        /** This method will remove a node from linked list with matching item*/
        if (this.head == null){
            return;
        }
        else if (this.head == this.tail && this.head.value == item){
            this.head = null;
            this.tail = null;
            this.size--;
            System.out.println("Removed node with data : "+item);
        }
        else if (this.head.value == item){
            this.head = this.head.next;
            this.tail.next = this.head;
            this.head.prev = this.tail;
            this.size--;
            System.out.println("Removed node with data : "+item);
        }
        else if (this.tail.value == item){
            this.head.prev = this.tail.prev;
            this.tail.prev.next = this.head;
            this.tail = this.tail.prev;
            this.size--;
            System.out.println("Removed node with data : "+item);
        }
        else{
            Node currentNode = this.head.next;
            Node prevNode = this.head;
            while(currentNode != this.head){
                if (currentNode.value == item){
                    prevNode.next= currentNode.next;
                    currentNode.next.prev = prevNode;
                    this.size--;
                    System.out.println("Removed node with data : "+item);
                }
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
        }

    }

    public Boolean search(int item){
        /** This method will return true if inpiut item is found in the linkedlist else it will return false*/
        if (this.head == null){
            return false;
        }
        Node currentNode = this.head;
        do{
            if(currentNode.value == item){
                return true;
            }
            currentNode = currentNode.next;
        }while(currentNode != this.head && currentNode != null);

        return false;
    }

    public void traverse(){
        /** This will traverse through each node of the linkedlist and display the values */
        if (this.head == null){
            System.out.println("Underflow");
            return;
        }

        Node currentNode = this.head;
        System.out.print("CircularLinkedList : ");
        do{
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }while(currentNode != this.head  && currentNode != null);
        System.out.println("");
    }

    public int size(){
        /** This will return the size of the linkedlist */
        return this.size;
    }

    public void sort(){
        /** This will sort the elements of the linkedlist in ascending order */
        if (this.head == null){
            return;
        }
        Node currentNode = this.head;
        Node indexNode;
        do{
            indexNode = currentNode.next;
            while(indexNode != this.head  && indexNode != null ){
               if  (currentNode.value > indexNode.value){
                   int temp = currentNode.value;
                   currentNode.value = indexNode.value;
                   indexNode.value = temp;
               }
               indexNode = indexNode.next;
            }
            currentNode = currentNode.next;
        }while(currentNode != this.head && currentNode != null );
    }
}

class Test {
    public static void main(String args[]) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();

        circularLinkedList.traverse();
        System.out.println("size : "+circularLinkedList.size());

        circularLinkedList.insertStart(10);
        System.out.println("size : "+circularLinkedList.size());
        circularLinkedList.traverse();
        circularLinkedList.remove(10);
        System.out.println("size : "+circularLinkedList.size());
        circularLinkedList.traverse();

        circularLinkedList.insertEnd(99);
        System.out.println("size : "+circularLinkedList.size());
        circularLinkedList.traverse();
        circularLinkedList.remove(99);
        System.out.println("size : "+circularLinkedList.size());
        circularLinkedList.traverse();

        circularLinkedList.insertStart(5);
        circularLinkedList.insertStart(10);
        circularLinkedList.insertEnd(15);
        circularLinkedList.insertEnd(20);
        System.out.println("size : "+circularLinkedList.size());
        circularLinkedList.traverse();

        circularLinkedList.remove(15);
        System.out.println("size : "+circularLinkedList.size());
        circularLinkedList.traverse();

        circularLinkedList.remove(10);
        System.out.println("size : "+circularLinkedList.size());
        circularLinkedList.traverse();

        circularLinkedList.remove(20);
        System.out.println("size : "+circularLinkedList.size());
        circularLinkedList.traverse();

        circularLinkedList.remove(5);
        System.out.println("size : "+circularLinkedList.size());
        circularLinkedList.traverse();

        circularLinkedList.insertStart(-2);
        circularLinkedList.insertStart(99);
        circularLinkedList.insertEnd(15);
        circularLinkedList.insertEnd(100);
        circularLinkedList.insertEnd(-25);

        System.out.println("size : "+circularLinkedList.size());
        circularLinkedList.traverse();

        circularLinkedList.sort();
        circularLinkedList.traverse();

        System.out.println("search 1000 : "+circularLinkedList.search(1000));
        System.out.println("search 99 : "+circularLinkedList.search(99));

    }
}