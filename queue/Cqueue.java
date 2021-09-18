public class CQueue {
    /** CQueue is the class for the implementation of circular queue*/
    private int rear, front, capacity, size;
    private int cqueue[];
    CQueue(int capacity){
        this.capacity = capacity;
        this.rear = -1;
        this.front = -1;
        this.cqueue = new int[this.capacity];
        this.size = 0;
    }
    public Boolean isEmpty(){
        /** Checks if the circular queue is empty*/
        return this.rear == -1 && this.front == -1;
    }

    public Boolean isFull(){
        /** Checks if the circular queue is full*/
        return (this.rear == this.capacity && this.front ==0)  || (this.front == this.rear +1);
    }

    public void enqueue(int item){
        /** This method performs enqueue operation on the circular queue*/
        if (this.isFull()){
            System.out.println("Queue is full. Enqueue operation cant be performed...");
            System.exit(1);
        }
        if (this.isEmpty()){
            this.front++;
        }
        this.rear = (this.rear + 1) % this.capacity;
        this.cqueue[this.rear] = item;
        this.size++;
        System.out.println("Inserted : "+ item);
    }

    public int dequeue(){
        /** This method performs dequeue operation on the circular queue*/
        if(this.isEmpty()){
            System.out.println("Queue is empty. Dequeue operation cant be performed...");
            System.exit(1);
        }
        int temp = this.cqueue[this.front];
        if (this.front == this.rear){
            this.front = -1;
            this.rear = -1;
        }
        else{
            this.front = (this.front + 1) % this.capacity;
        }
        this.size--;
        System.out.println("Removed : "+temp);
        return temp;
    }
    public int peek(){
        /** This method returns the front element of the queue*/
        if(this.isEmpty()){
            System.out.println("Queue is empty. Peek operation cant be performed...");
            System.exit(1);
        }
        return this.cqueue[this.front];

    }
    public int size(){
        /** This method returns the size of the queue*/
        return this.size;
    }
    public void display(){
        /** This method displays the elements of the queue*/
        if(this.isEmpty()){
            System.out.println("Queue is empty. Nothing is there to display");
            System.exit(1);
        }else {
            int i = this.front;
            System.out.print("CQueue : " + this.cqueue[i]);
            do {
                i = (i + 1) % this.capacity;
                System.out.print(", " + this.cqueue[i]);
            } while (i != this.rear);
            System.out.println("");
        }
    }
}

class Test {
    public static void main(String args[]) {
        CQueue cqueue = new CQueue(5);
        //System.out.println(queue.peek()); // will raise error
        //System.out.println("dequeue "+ queue.dequeue()); // will raise error
        cqueue.enqueue(-2);
        cqueue.enqueue(5);
        cqueue.display();
        System.out.println(cqueue.peek());
        System.out.println(cqueue.size());
        cqueue.enqueue(6);
        System.out.println(cqueue.size());
        cqueue.display();
        cqueue.dequeue();
        cqueue.display();
        System.out.println(cqueue.peek());
        System.out.println(cqueue.size());
        cqueue.dequeue();
        cqueue.dequeue();
        // cqueue.dequeue(); //Queue empty error
        //cqueue.display();  //Queue empty error
        //System.out.println(cqueue.peek());  //Queue empty error
        System.out.println(cqueue.size());

        cqueue.enqueue(5);
        cqueue.enqueue(10);
        cqueue.enqueue(15);
        cqueue.dequeue();
        cqueue.dequeue();
        cqueue.enqueue(20);
        cqueue.enqueue(25);
        cqueue.enqueue(30);
        cqueue.enqueue(35);

        System.out.println(cqueue.size());
        System.out.println(cqueue.peek());
        cqueue.display();

        cqueue.enqueue(99);


    }
}