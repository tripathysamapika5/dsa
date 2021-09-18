public class Queue {
    int front, rear, capacity;
    int queue[];

    Queue(int capacity){
        this.capacity = capacity;
        this.front = -1;
        this.rear = -1;
        this.queue = new int[capacity];
    }
    public Boolean isEmpty(){
        return this.rear == -1;
    }
    public Boolean isFull(){
        return this.rear - this.front + 1 == this.capacity;
    }
    public void enqueue(int item){
        if (this.isFull()){
            System.out.println("Queue is full. Enqueue operation can not be performed...");
            System.exit(1);
        }
        if (this.isEmpty()){
            this.front++;
        }
        this.queue[++this.rear] = item;
        System.out.println("Inserted <-"+ item);
    }
    public int dequeue(){
        if (this.isEmpty()) {
            System.out.println("Queue is empty. Dequeue operation can not be performed...");
            System.exit(1);
        }
        int temp = this.queue[this.front++];
        if (this.front > this.rear){
            this.front = -1;
            this.rear = -1;
        }
        System.out.println("Removed ->"+ temp);
        return temp;
    }

    public int peek(){
        if (this.isEmpty()){
            System.out.println("Queue is empty. Peek operation can not be performed...");
            System.exit(1);
        }
        return this.queue[this.front];
    }

    public int size(){
        return this.rear - this.front + 1;
    }

    public void display(){
        int i = this.front;
        System.out.print("Queue :");
        while (i <= this.rear){
            System.out.print(this.queue[i] + " ");
            i++;
        }
        System.out.println();
    }

}


class Test {
    public static void main(String args[]){
        Queue queue = new Queue(5);
        //System.out.println(queue.peek()); // will raise error
        //System.out.println("dequeue "+ queue.dequeue()); // will raise error
        queue.enqueue(-2);
        queue.enqueue(5);
        queue.display();
        System.out.println(queue.peek());

        queue.display();
        queue.enqueue(10);
        System.out.println(queue.size());
        queue.enqueue(15);
        System.out.println(queue.size());
        queue.enqueue(20);
        //queue.enqueue(25); //error queue is full
        System.out.println(queue.peek());
        queue.display();
        //System.out.println(queue.peek());
        //queue.enqueue(30); // Error : Queue is full
        System.out.println(queue.size());

        queue.dequeue();
        System.out.println(queue.size());
        System.out.println(queue.peek());
        queue.display();


    }
}

