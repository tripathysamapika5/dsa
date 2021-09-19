public class Deque {
    private int rear, front, size, capacity;
    private int deque[];

    Deque(int capacity){
        this.capacity = capacity;
        this.rear = -1;
        this.front = -1;
        this.size = 0;
        this.deque = new int[capacity];
    }

    public Boolean isEmpty(){
        /** This method is used to check if the Deque is Empty */
        return this.front == -1 && this.rear == -1;
    }

    public Boolean isFull(){
        /** This method is used to check if the Deque is full or not */
        return (this.front == 0 && this.rear == this.capacity -1) || (this.front == this.rear + 1);
    }

    public void insertFront(int item){
        /** This method is used to add elements at the front of the deque*/
        if (this.isFull()){
            System.out.println("Overflow");
            System.exit(1);
        }
        if (this.isEmpty()){
            this.front = 0;
            this.rear = 0;
        }
        if (this.front == 0){
            this.front = this.capacity - 1;
        }else{
            this.front--;
        }
        this.deque[this.front] = item;
        this.size++;
        System.out.println("Inserted at front : "+item);
    }

    public void insertRear(int item){
        /** This method is used to add elements at the rear side of the deque */
        if (this.isFull()){
            System.out.println("Overflow");
            System.exit(1);
        }
        if (this.isEmpty()){
            this.front = 0;
            this.rear = 0;
        }
        else if (this.rear == this.capacity - 1){
            this.rear = 0;
        }else{
            this.rear++;
        }
        this.deque[this.rear] = item;
        this.size++;
        System.out.println("Inserted at rear : "+item);
    }

    public int deleteFront(){
        /** This method is used to delete elements at the front side of the deque */
        if (this.isEmpty()){
            System.out.println("Underflow");
            System.exit(1);
        }
        int temp = this.deque[this.front];
        if(this.front == this.rear){
            this.front = -1;
            this.rear = -1;
        }else {
            this.front = (this.front + 1) % this.capacity;
        }
        this.size--;
        System.out.println("Removed from front : "+temp);
        return temp;
    }

    public int deleteRear(){
        /** This method is used to delete elements at the rear side of the deque */
        if (this.isEmpty()){
            System.out.println("Underflow");
            System.exit(1);
        }
        int temp = this.deque[this.rear];
        if(this.front == this.rear){
            this.front = -1;
            this.rear = -1;
        }else if (this.rear == 0){
            this.rear = this.capacity -1;
        }else{
            this.rear--;
        }
        this.size--;
        System.out.println("Removed from rear : "+temp);
        return temp;
    }
    public int getFront(){
        /** This method returns the front element of the deque */
        if (this.isEmpty()){
            System.out.println("Underflow");
            System.exit(1);
        }
        return this.deque[this.front];
    }
    public int getRear(){
        /** This method returns the rear element of the deque */
        if (this.isEmpty()){
            System.out.println("Underflow");
            System.exit(1);
        }
        return this.deque[this.rear];
    }
    public int size(){
        /** This method returns the size of the deque */
        return this.size;
    }

    public void display() {
        /** This method is used to desplay the elements of the deque */
        if (this.isEmpty()) {
            System.out.println("Underflow");
            System.exit(1);
        }

        if (this.front > this.rear) {
            int i = this.front;
            System.out.print("Deque : " + this.deque[i]);
            do {
                i = (i + 1) % this.capacity;
                System.out.print(" ~ " + this.deque[i]);
            } while (i != this.rear);
            System.out.println("");

        }else{
            int i = this.front;
            System.out.print("Deque : " + this.deque[i]);
            while (i < this.rear) {
                i++;
                System.out.print(" ~ " + this.deque[i]);
            }
            System.out.println("");

        }

    }



}


class Test {
    public static void main(String args[]) {
        Deque deque = new Deque(5);
        //System.out.println(deque.getFront()); // will raise error Underflow
        //System.out.println(deque.getRear()); // will raise error Underflow
        //System.out.println("delete front "+ deque.deleteFront()); // will raise error Underflow
        //System.out.println("delete rear  "+ deque.deleteRear()); // will raise error Underflow

        deque.insertRear(5);
        deque.insertRear(10);
        deque.insertRear(15);
        System.out.println(deque.getFront());
        System.out.println(deque.getRear());
        System.out.println(deque.size());
        deque.display();
        deque.deleteFront();
        deque.deleteFront();
        System.out.println(deque.getFront());
        System.out.println(deque.getRear());
        System.out.println(deque.size());
        deque.display();

        deque.insertFront(20);
        deque.insertFront(25);
        deque.insertFront(30);
        deque.insertFront(35);
        System.out.println(deque.getFront());
        System.out.println(deque.getRear());
        System.out.println(deque.size());
        deque.display();
        //deque.insertFront(40); // will raise error Overflow
        //deque.insertRear(40);// will raise error Overflow
        deque.deleteFront();
        deque.deleteRear();

        System.out.println(deque.getFront());
        System.out.println(deque.getRear());
        System.out.println(deque.size());
        deque.display();
    }
}